package com.example.demo.service.impl;

import com.example.demo.core.CommonMap;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-03-11
 * Time: 오후 8:26
 */
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public UserDto selectUser(CommonMap params) {
        return userMapper.selectUser(params).orElse(null);
    }
}
