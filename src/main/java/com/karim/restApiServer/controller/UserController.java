package com.karim.restApiServer.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.karim.restApiServer.domain.User;
import com.karim.restApiServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2")
@EnableCaching // 어노테이션을 이용한 캐시기능을 사용하겠다는 선언
public class UserController {

    private final UserService userService;

    /**
     * 전달 받은 해당 테이블 및 메소드 정보로
     * DB에 User를 등록한다.
     * @param tableName
     * @param methodName
     * @param httpSession
     * @param timeout
     * @param body
     */
    // curl -X POST http://127.0.0.1:8080/api/v2/tb_user/setUser?timeout=1 -d "{"userId":"karim","userPw":"karim","userName":"카림"}" -H "Content-Type:application/json;charset=UTF-8"
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

    /**
     * 전달 받은 해당 테이블 및 메소드 정보로
     * DB에서 전체 사용자를 검색한다.
     * @param tableName
     * @param methodName
     * @param httpServletRequest
     * @param httpSession
     * @return
     */
    @GetMapping(path = "/{table}/{method}")
    public String getUserAllNoCache(@PathVariable("table") String tableName,
                          @PathVariable("method") String methodName,
                          HttpServletRequest httpServletRequest,
                          HttpSession httpSession){

        StringBuilder stringBuilder = new StringBuilder();

        JsonObject jsonObject = new JsonObject();

        if (methodName.equals("getUserAll")){
            if (tableName.equals("tb_user")){
                // curl -X GET http://127.0.0.1:8080/api/v2/tb_user/getUserAll
                long start = System.currentTimeMillis(); // 수행시간 측정
                List<User> userList = userService.getUserAllNoCache();
                long end = System.currentTimeMillis();
                System.out.println("No Cache 수행시간 : "+ (end-start));
                for (User user : userList){
                    jsonObject.addProperty("userNo", user.getUserNo());
                    jsonObject.addProperty("userId", user.getUserId());
                    jsonObject.addProperty("userPw", user.getUserPw());
                    jsonObject.addProperty("userName", user.getUserName());
                    jsonObject.addProperty("userAuth", user.getUserAuth());
                    jsonObject.addProperty("appendTime", user.getAppendDate());
                    jsonObject.addProperty("updateTime", user.getUpdateDate());

                    stringBuilder.append(jsonObject).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 전달 받은 해당 테이블 및 메소드 정보로
     * ehCache에서 전체 사용자를 검색한다.
     * @param tableName
     * @param methodName
     * @param httpServletRequest
     * @param httpSession
     * @return
     */
    @GetMapping(path = "/cache/{table}/{method}")
    public String getUserAllCache(@PathVariable("table") String tableName,
                      @PathVariable("method") String methodName,
                      HttpServletRequest httpServletRequest,
                      HttpSession httpSession){

        StringBuilder stringBuilder = new StringBuilder();
        JsonObject jsonObject = new JsonObject();

        if (methodName.equals("getUserAll")){
            if (tableName.equals("tb_user")){
                // curl -X GET http://127.0.0.1:8080/api/v2/cache/tb_user/getUserAll
                long start = System.currentTimeMillis(); // 수행시간 측정
                List<User> userList = userService.getUserAllCache("karim");
                long end = System.currentTimeMillis();
                System.out.println("Cache 수행시간 : "+ (end-start));

                for (User user : userList){
                    jsonObject.addProperty("userNo", user.getUserNo());
                    jsonObject.addProperty("userId", user.getUserId());
                    jsonObject.addProperty("userPw", user.getUserPw());
                    jsonObject.addProperty("userName", user.getUserName());
                    jsonObject.addProperty("userAuth", user.getUserAuth());
                    jsonObject.addProperty("appendTime", user.getAppendDate());
                    jsonObject.addProperty("updateTime", user.getUpdateDate());

                    stringBuilder.append(jsonObject).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * ehCache refresh
     * @return
     */
    @GetMapping(path = "/cache/refresh")
    @ResponseBody
    public String refresh(){
        userService.refresh("karim"); // 캐시제거
        return "cache clear";
    }
}
