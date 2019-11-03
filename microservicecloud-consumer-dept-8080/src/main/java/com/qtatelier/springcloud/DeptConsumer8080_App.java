package com.qtatelier.springcloud;

import com.qtatelier.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author JazzXia
 * @create 2019-11-01-18:41
 * @email jazzxiaw@qq.com
 * @since 2019
 */
//自定义Ribbon的负载均衡算法
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer8080_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8080_App.class,args);
    }
}
