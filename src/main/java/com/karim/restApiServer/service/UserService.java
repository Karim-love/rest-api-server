package com.karim.restApiServer.service;

import com.google.gson.JsonObject;
import com.karim.restApiServer.maria.mapper.UserMapper;
import com.karim.restApiServer.maria.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public List<UserVo> getUserAllNoCache(){
        return userMapper.getUserAllNoCache();
    }


    /**
     * value 는 캐쉬 뭉탱이의 이름이라고 생각하면 된다. (RDBMS 의 테이블)
     * key 는 RDBMS 의 테이블의 PK 라고 생각하면 됨
     * getUserAllCache("id") 를 호출하면 메소드가 한번 실행된 후에 리턴되는 List 가 karimCache 에 id 키에 캐쉬된다.
     * 다시 똑같은 파라메터로 karimCache("id") 호출하면 메소드가 실행되지 않고 karimCache 캐쉬에 있는 id 키를 찾아서 저장된 값을 리턴한다.
     * 참고예제 : https://stove99.github.io/java/2019/08/01/springboot-with-ehcache/
     * 참고예제2 : https://jojoldu.tistory.com/57
     * */
    @Cacheable(value="karimCache", key="#id")
    public List<UserVo> getUserAllCache(String id){
        return userMapper.getUserAllCache();
    }

    // @CacheEvict : 캐시를 지울 때 쓰는 어노테이션
    @CacheEvict(value="karimCache", key="#id")
    public void refresh(String id) {
        System.out.println("cache clear");
    }
}
