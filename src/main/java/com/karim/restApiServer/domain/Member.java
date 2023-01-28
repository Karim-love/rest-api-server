package com.karim.restApiServer.domain;

import lombok.Data;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : sblim
 * date           : 2022-06-18 오전 01:33
 * description    :
 */

@Data
public class Member {
    private Long userId;
    private String userName;
}
