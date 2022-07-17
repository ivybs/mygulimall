package com.ibs.gulimall.coupon;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * 1.引入依赖
 * 2.创建文件bootstrap.properties
 * 3.需要给配置中心默认添加一个叫数据集(Data Id)
 *      gulimall-coupon.properties.默认规则:应用名.properties
 * 4.给应用名.properties添加任何配置
 * 5.动态获取配置 : @RefreshScope 和 @Value
 *      如果配置中心和当前应用的配置文件中都配置了相同的项
 *      会优先使用配置中心的配置
 *
 * 6.一些细节
 *  1) 命名空间 配置隔离:默认public 默认新增的所有配置都在public空间
 *      ①.开发\测试\生产: 利用命名空间来做环境隔离
 *      注:在bootstrap.properties配置上需要使用的命名空间
 *      spring.cloud.nacos.config.namespace=命名空间的唯一id
 *      ②.每一个微服务之间互相隔离配置,每一个微服务都创建自己的命名空间
 *      只加载自己命名空间下的所有配置
 * 2) 配置集: 所有的配置的集合
 * 3) 配置集id: 类似配置文件名
 * 4) 配置分组: 默认所有的配置集都属于DEFAULT_GROUP
 * 项目中的使用，每个微服务创建自己的命名空间，使用配置分组区分环境:dev test prod
 *
 * 同时加载多个配置集
 *
 *
 *
 * */
@SpringBootApplication
@MapperScan("com.ibs.gulimall.coupon.dao")
@EnableDiscoveryClient
public class GulimallCouponApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplicationStarter.class,args);
    }
}
