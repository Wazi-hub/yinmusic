package com.istudy.songlist;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@MapperScan("com.istudy.songlist.dao")
@SpringBootApplication
public class SongListApplication {
    public static void main(String[] args) {
        SpringApplication.run(SongListApplication.class);
    }
}
