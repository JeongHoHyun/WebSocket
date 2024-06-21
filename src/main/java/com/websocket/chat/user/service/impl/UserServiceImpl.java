package com.websocket.chat.user.service.impl;

import com.websocket.chat.user.mapper.UserMapper;
import com.websocket.chat.user.model.UserVO;
import com.websocket.chat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public int registerUser(UserVO vo) {
        return userMapper.registerUser(vo);
    }

    @Override
    public int duplicationCheck(String id) {
        return userMapper.duplicationCheck(id);
    }
}
