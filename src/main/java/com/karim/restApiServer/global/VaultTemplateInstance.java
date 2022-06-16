package com.karim.restApiServer.global;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * packageName    : com.karim.restApiServer.global
 * author         : sblim
 * date           : 2022-06-16 오전 11:25
 * description    :
 */

public class VaultTemplateInstance extends ConcurrentHashMap<String, String> {
    private volatile static VaultTemplateInstance _instance;
    @Getter
    @Setter
    private String auth;

    @Getter
    @Setter
    private String password;


    public static VaultTemplateInstance getInstance() {
        if (_instance == null) {
            synchronized (VaultTemplateInstance.class) {
                if (_instance == null) {
                    _instance = new VaultTemplateInstance();
                }
            }
        }
        return _instance;
    }

    private VaultTemplateInstance() {
    }
}
