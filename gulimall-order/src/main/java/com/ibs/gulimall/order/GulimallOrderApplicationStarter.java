package com.ibs.gulimall.order;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.ibs.gulimall.order.dao")
@EnableDiscoveryClient
public class GulimallOrderApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(GulimallOrderApplicationStarter.class,args);
    }
}
