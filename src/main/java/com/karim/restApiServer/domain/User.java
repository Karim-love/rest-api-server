package com.karim.restApiServer.domain;

import lombok.Data;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : karim
 * date           : 2022-06-18 오전 01:33
 * description    :
 */

@Data
public class User {
    private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String userAuth;
    private String appendDate;
    private String updateDate;
}
