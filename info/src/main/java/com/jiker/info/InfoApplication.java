package com.jiker.info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@MapperScan("com.jiker.info.dao.mapper")
//@EnableResourceServer
public class InfoApplication{

    public static void main(String[] args) {
        //System.out.println("in application main");
        SpringApplication.run(InfoApplication.class, args);
    }
}
