package com.example.demo.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-01-28
 * Time: 오후 12:36
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "*//**")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/api/user/regi").permitAll()
                .antMatchers("/login/proc").permitAll()
//                .antMatchers("/api/**").hasAnyRole("USER")
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login/page")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login/proc").permitAll().successForwardUrl("/main")
                .and()
                .cors()
                .and().logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("SESSION").logoutUrl("/logout").logoutSuccessUrl("/");
        ;
        //세션 처리
        http
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false) //동시접속 막기
        ;
    }
}
