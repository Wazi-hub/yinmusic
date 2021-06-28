package com.istudy.listsong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.istudy.listsong.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class ListSongApplication {
    public static void main(String[] args) {
        SpringApplication.run(ListSongApplication.class);
    }
}
