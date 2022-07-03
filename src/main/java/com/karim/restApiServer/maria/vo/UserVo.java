package com.karim.restApiServer.maria.vo;

import lombok.Data;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : sblim
 * date           : 2022-06-18 오전 01:33
 * description    :
 */

@Data
public class UserVo{
    private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String userAuth;
    private String appendDate;
    private String updateDate;
}
