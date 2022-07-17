package com.ibs.gulimall.member;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1.想要远程调用别的服务
 * 1）.引入open-feign
 * 2).编写一个接口，告诉springcloud这个接口需要调用远程服务
 * 3).开启远程调用概念@EnableFeignClients
 *
 * */
@EnableFeignClients("com.ibs.gulimall.member.feign")
@SpringBootApplication
@MapperScan("com.ibs.gulimall.member.dao")
@EnableDiscoveryClient
public class GulimallMemberApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplicationStarter.class,args);
    }
}
