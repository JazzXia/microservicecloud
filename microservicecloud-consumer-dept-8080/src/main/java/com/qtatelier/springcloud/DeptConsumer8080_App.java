package com.qtatelier.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author JazzXia
 * @create 2019-11-01-18:41
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer8080_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8080_App.class,args);
    }
}
