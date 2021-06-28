package com.istudy.singer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.istudy.singer.dao")
@SpringBootApplication
public class SingerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SingerApplication.class);
    }
}
