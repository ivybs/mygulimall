package com.ibs.gulimall.product;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.ibs.gulimall.product.dao")
@EnableDiscoveryClient
public class GulimallProductApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplicationStarter.class,args);
    }
}
