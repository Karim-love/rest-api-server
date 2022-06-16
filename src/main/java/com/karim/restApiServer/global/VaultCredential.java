package com.karim.restApiServer.global;

import lombok.Data;

/**
 * packageName    : com.karim.restApiServer.global
 * author         : sblim
 * date           : 2022-06-16 오전 11:27
 * description    :
 */
@Data
public class VaultCredential {
    private String username;
    private String password;
}