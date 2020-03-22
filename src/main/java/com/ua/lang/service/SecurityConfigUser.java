package com.ua.lang.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
public class SecurityConfigUser extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/index")
                .authorizeRequests()
                .anyRequest()
                .hasRole("USER")
                .and()
                .httpBasic().authenticationEntryPoint(authenticationEntryPointUser());
    }
    @Bean
    AuthenticationEntryPoint authenticationEntryPointUser(){
        BasicAuthenticationEntryPoint entryPoint =
                new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("user realm");
        return entryPoint;

    }
}
