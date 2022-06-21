package com.karim.restApiServer.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.karim.restApiServer.maria.vo.UserVo;
import com.karim.restApiServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : sblim
 * date           : 2022-06-16 오전 10:45
 * description    :
 */
// curl -X POST http://127.0.0.1:8080/api/v2/tb_user/setUser?timeout=1 -d "{"userId":"karim","userPw":"karim","userName":"카림"}" -H "Content-Type:application/json;charset=UTF-8"
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/{table}/{method}/**", produces = "application/json;charset=UTF-8")
    public void post(@PathVariable("table") String tableName,
                     @PathVariable("method") String methodName,
                     HttpSession httpSession,
                     @RequestParam(value = "timeout") String timeout,
                     @RequestBody String body) {

        JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();

        if (methodName.equals("setUser")){
            if (tableName.equals("tb_user")){
                userService.setUser(jsonObject);
            }
        }
    }

    @GetMapping(path = "/{table}/{method}")
    public void get(@PathVariable("table") String tableName,
                    @PathVariable("method") String methodName,
                    HttpServletRequest httpServletRequest,
                    HttpSession httpSession){
        if (methodName.equals("getUserAll")){
            if (tableName.equals("tb_user")){
                // curl -X GET http://192.168.124.131:8080/api/v2/tb_user/getUserAll
                userService.getUserAll();
            }
        }
    }
}
