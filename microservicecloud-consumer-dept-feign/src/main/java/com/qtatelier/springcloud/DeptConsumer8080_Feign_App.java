package com.qtatelier.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author JazzXia
 * @create 2019-11-01-18:41
 * @email jazzxiaw@qq.com
 * @since 2019
 */
//自定义Ribbon的负载均衡算法
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.qtatelier.springcloud"})
@ComponentScan("com.qtatelier.springcloud")

public class DeptConsumer8080_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8080_Feign_App.class,args);
    }
}
