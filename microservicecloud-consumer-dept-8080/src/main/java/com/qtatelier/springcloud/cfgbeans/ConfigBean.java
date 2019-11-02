package com.qtatelier.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author JazzXia
 * @create 2019-11-01-16:39
 * @email jazzxiaw@qq.com
 * @since 2019
 *
 * RestTemplate提供了多种便捷访问远程Http服务的方法，
 * 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
 *
 */

@Configuration
public class ConfigBean {

    /**
     * RestTemplate
     *
     * @return
     */
    @Bean
    @LoadBalanced//Spring Ribbon是基于Netfix Ribbom实现的一套客户端  负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//applcationContext.xml == ConfigBean(@Configuration)
/**
 * <bean id="userService" class="com.qtatelier.tmall.UserServiceImpl"></bean>
 *
 *     @Bean
 *     public UserService getUserServie(){
 *         return new UserServiceImpl();
 *     }
 */