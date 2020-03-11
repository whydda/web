package com.example.demo.core.security;

import com.example.demo.core.CommonMap;
import com.example.demo.util.PasswordEncodeUtils;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    SecureUserDetailsService secureUserDetailsService;

    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userId = authentication.getName().toLowerCase();
        String password = authentication.getCredentials().toString();

        UserDetails user;
        Collection<? extends GrantedAuthority> authorities;

        try {
            //패스워드 체크
            CommonMap commonMap= new CommonMap();
            commonMap.put("userId", userId);
            commonMap.put("password", password);

            UserDto userDto = userService.selectUser(userId);

            if (null == userDto) {
                throw new UsernameNotFoundException("사용자가 없습니다.");
            }

            //패스워드 체크
            if (!PasswordEncodeUtils.matchesPassword(password, userDto.getPassword())) {
                throw new UsernameNotFoundException("패스워드가 틀렸습니다.");
            }

            user = secureUserDetailsService.loadUserByUsername(userId);
            authorities = user.getAuthorities();

        } catch (Exception e) {
            log.info(e.toString());
            throw new UsernameNotFoundException("");
        }

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);

    }
}
