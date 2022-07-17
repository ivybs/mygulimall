package com.ibs.gulimall.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1.开启服务注册与发现@EnableDiscoveryClient
 *      （配置nacos的注册中心）
 *
 *
 * */
// 排除了和数据源相关的配置，因为引入了mybatis的依赖但其实没有用到
// 如果不排除就会报找不到没有配置数据源的错误
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class GulimallGatewayApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(GulimallGatewayApplicationStarter.class,args);
    }
}
