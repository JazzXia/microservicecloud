package com.qtatelier.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author JazzXia
 * @create 2019-11-01-15:07
 * @email jazzxiaw@qq.com
 * @since 2019
 *
 *
 * 传统数据库(SQLServer,Mysql,Oracle)遵从ACID:
 * 一个事务本质上有四个特点ACID：
 * Atomicity原子性
 * Consistency一致性
 * Isolation隔离性
 * Durability耐久性
 *
 *
 * noSQL(Redis/MongDB)(CAP+BASE)
 * CAP:强一致性，可用性，分区容错性
 * P是固定的
 * C
 * A
 * 针对整个淘宝网站，11.11当天，你觉得你来选择的话，你选择AP，还是CP
 * 答案是AP，C是强一致性，双十一那天选择AP高可用，等到双十一过去再选择CP来核对数据
 *
 * Zookeeper保证的是CP，Eureka是AP
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProvider8001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
