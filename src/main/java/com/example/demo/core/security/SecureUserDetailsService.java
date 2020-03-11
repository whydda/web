package com.example.demo.core.security;

import com.example.demo.dto.UserDto;
import com.example.demo.em.Role;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-03-11
 * Time: 오후 20:46
 */
@Service(value = "secureUserDetailsService")
public class SecureUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDetails userDetails = getUser(userId);
        return userDetails;
    }

    private SecureUser getUserRole(UserDto userDto) {
        return new SecureUser(userDto, AuthorityUtils.createAuthorityList("ROLE_anonymousUser"));
    }

    private SecureUser getUser(String userId) {
        //DB호출 후 계정정보 리턴
        UserDto userDto = userService.selectUser(userId);
        SecureUser user = new SecureUser(userDto, AuthorityUtils.createAuthorityList(Role.ROLE_USER.name()));
        return user;
    }
}
