package com.websocket.chat.user.mapper;

import com.websocket.chat.user.model.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USERS (user_id, user_pw, user_name) VALUES (#{user_id}, #{user_pw}, #{user_name})") // 어노테이션으로 쿼리를 작성할 경우, xml에 따로 등록하지 않아도 되지만, mapper.xml에서의 id와 메소드 명이 같으면 인식을 하지못하여 오류가난다.
    int registerUser(UserVO vo);

    @Select("SELECT COUNT(*) FROM USERS WHERE user_id = #{user_id}") // id 중복체크
    int duplicationCheck(String user_id);
}
