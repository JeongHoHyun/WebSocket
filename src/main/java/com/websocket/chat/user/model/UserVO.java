package com.websocket.chat.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserVO {
    private Long user_idx;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String reg_date;
    private String status;
}
