package com.xxxx.ScoreQuery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.xxxx.ScoreQuery.dao")
public class Starter extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(Starter.class);
    }

}
