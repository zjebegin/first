package com.jiker.authentication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
@MapperScan("com.jiker.authentication.dao.mapper")
public class AuthenticationApplication {

    public static void main(String[] args) {

        SpringApplication.run(AuthenticationApplication.class, args);
    }


}
