package com.me.article;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.me.user.mapper")
public class userApplication {
    public static void main(String[] args) {
        SpringApplication.run(userApplication.class);


    }
}
