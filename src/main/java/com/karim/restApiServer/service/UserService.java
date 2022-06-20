package com.karim.restApiServer.service;

import com.google.gson.JsonObject;
import com.karim.restApiServer.maria.mapper.UserMapper;
import com.karim.restApiServer.maria.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);
    private final UserMapper userMapper;

    public void setUser(JsonObject jsonObject){
        UserVo userVo = new UserVo();
        userVo.setUserId(jsonObject.get("userId") != null ? jsonObject.get("userId").getAsString() : "");
        userVo.setUserPw(jsonObject.get("userPw") != null ? jsonObject.get("userPw").getAsString() : "");
        userVo.setUserName(jsonObject.get("userName") != null ? jsonObject.get("userName").getAsString() : "");
        userVo.setUserAuth("USER");
        userVo.setAppendDate(localTime);
        userVo.setUpdateDate(localTime);
        userMapper.setUser(userVo);
    }
}
