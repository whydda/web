package com.example.demo.service;

import com.example.demo.core.CommonMap;
import com.example.demo.dto.UserDto;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-03-11
 * Time: 오후 8:26
 */
public interface UserService {

    public UserDto selectUser(String userId);

}
