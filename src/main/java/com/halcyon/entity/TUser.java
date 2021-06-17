package com.halcyon.entity;

import lombok.Data;

@Data
public class TUser {
    private Long tuId;

    //private Long userId;
    private String userId;

    private String userNickname;

    private String userPwd;

    private String userEmail;

    private String userTel;
    private String userFlag;

}