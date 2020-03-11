package com.example.demo.core.security;

import com.example.demo.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-03-11
 * Time: 오후 20:46
 */
@Setter
@Getter
@ToString
public class SecureUser extends User {

    private static final long serialVersionUID = 2550249307461767130L;

    public SecureUser(UserDto userDto, Collection<? extends GrantedAuthority> authorities) {
        super(userDto.getUserId(), userDto.getPassword(), authorities);
        this.setPassword(userDto.getPassword());
        this.setRole(authorities.toString());
    }

    public SecureUser getSecureUser() {
        return this;
    }

    //생성된 토큰 키
    private Long userId = 0L;
    private String password = "";
    private String name = "";
    private String role = "";

}
// :)--
