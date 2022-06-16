package com.karim.restApiServer.controller;

import com.google.gson.JsonObject;
import com.karim.restApiServer.global.VaultTemplateInstance;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : sblim
 * date           : 2022-06-16 오전 10:45
 * description    :
 */

@RestController
@RequestMapping("/api/v1")
public class VaultApiController {
    @GetMapping(path = "/vault")
    public String get() {
        String user = VaultTemplateInstance.getInstance().get("user");
        String auth = VaultTemplateInstance.getInstance().get("auth");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("user", user);
        jsonObject.addProperty("auth", auth);
        return jsonObject.toString();
    }
}
