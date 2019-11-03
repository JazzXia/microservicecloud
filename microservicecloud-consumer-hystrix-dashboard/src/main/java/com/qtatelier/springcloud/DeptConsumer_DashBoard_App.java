package com.qtatelier.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author JazzXia
 * @create 2019-11-03-16:09
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@SpringBootApplication
@EnableHystrixDashboard//开启仪表盘的图形化界面注解
public class DeptConsumer_DashBoard_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
    }
}
