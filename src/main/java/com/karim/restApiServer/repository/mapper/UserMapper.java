package com.karim.restApiServer.repository.mapper;
import com.karim.restApiServer.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : sblim
 * date           : 2022-06-18 오전 01:18
 * description    :
 */

@Mapper
public interface UserMapper{
    void setUser(User user);

    List<User> getUserAll();

}