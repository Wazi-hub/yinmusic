package com.istudy.collection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.istudy.collection.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class CollectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollectionApplication.class,args);
    }
}
