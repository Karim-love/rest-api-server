package com.karim.restApiServer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.karim.restApiServer.domain.Member;
import com.karim.restApiServer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * Member에 회원을 등록한다.
     * @param body
     * @param httpSession
     */
    // curl -X POST http://127.0.0.1:8080/join? -d "{\"userName\":\"karim\"}" -H "Content-Type:application/json;charset=UTF-8"
    @PostMapping(path = "/join", produces = "application/json;charset=UTF-8")
    public void join(@RequestBody HashMap<String, Object> param) {
        Member member = new Member();
        member.setUserName( param.get("userName").toString() );

        memberService.join( member );
    }
}
