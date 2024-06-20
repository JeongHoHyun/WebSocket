package com.websocket.chat.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserVO {
    private Long user_idx;
    private String id;
    private String pw;
    private String reg_date;
    private String status;
}
