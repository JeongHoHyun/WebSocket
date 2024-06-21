package com.websocket.chat.user.service;

import com.websocket.chat.user.model.UserVO;

public interface UserService {
    int registerUser(UserVO vo);

    int duplicationCheck(String id);
}
