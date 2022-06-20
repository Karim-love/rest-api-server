package com.karim.restApiServer.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.karim.restApiServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : sblim
 * date           : 2022-06-16 오전 10:45
 * description    :
 */
// curl -X POST http://127.0.0.1:8080/api/v2/setUser/tb_user?timeout=1 -d "{\"userId\":\"karim\",\"userPw\":\"karim\",\"userName\":\"카림\"}" -H "Content-Type:application/json;charset=UTF-8"
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/{method}/{table}/**", produces = "application/json;charset=UTF-8")
    public void post(@PathVariable("method") String methodName,
                       @PathVariable("table") String tableName,
                       HttpSession httpSession,
                       @RequestParam(value = "timeout") String timeout,
                       @RequestBody String body) {
        System.out.println(methodName);
        System.out.println(tableName);
        System.out.println(body);
        System.out.println(httpSession);
        System.out.println(timeout);

        JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();

        if (methodName.equals("setUser")){
            if (tableName.equals("tb_user")){
                userService.setUser(jsonObject);
            }
        }
    }
}
