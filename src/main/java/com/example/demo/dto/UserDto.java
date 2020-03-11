package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-03-11
 * Time: 오후 8:22
 */
@Setter
@Getter
@ToString
public class UserDto {
    private String userId;
    private String password;
    private String userName;

}
