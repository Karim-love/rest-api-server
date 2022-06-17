package com.karim.restApiServer.controller;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : sblim
 * date           : 2022-06-16 오전 10:45
 * description    :
 */

// curl -X POST http://127.0.0.1:8080/api/v1/category/action?timeout=1 -d "{\"key\":\"value\"}" -H "Content-Type:application/json;charset=UTF-8"
@RestController
@RequestMapping("/api/v1")
public class PostTestController {

    @PostMapping(path = "/{category}/{action}/**", produces = "application/json;charset=UTF-8")
    public String post(@PathVariable("category") String category,
                           @PathVariable("action") String action,
                           HttpSession httpSession,
                           @RequestParam(value = "timeout") String timeout,
                           @RequestBody String body) {
        System.out.println(category);
        System.out.println(action);
        System.out.println(body);
        System.out.println(httpSession);
        System.out.println(timeout);
        return new JsonObject().toString();
    }
}
