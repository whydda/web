package com.example.demo.service.mapper;

import com.example.demo.core.CommonMap;
import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-03-11
 * Time: 오후 8:28
 */
@Repository("userMapper")
public interface UserMapper {
    Optional<UserDto> selectUser(CommonMap params);
}
