package com.qtatelier.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
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


    /**
     * 改变原先Ribbon的负载均衡算法
     *
     * 如果需要自己写算法可以自己封装
     * 从默认的轮询算法修改为随机算法
     *
     *
     * RoundRobinRule
     *   轮询
     * RandomRule
     *   随机
     * AvailabilityFilteringRule
     *   会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务， 还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
     * WeightedResponseTimeRule
     *   根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。 刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够， 会切换到WeightedResponseTimeRule
     * RetryRule
     *   先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
     * BestAvailableRule
     *   会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
     * ZoneAvoidanceRule
     *   默认规则,复合判断server所在区域的性能和server的可用性选择服务器
     *
     *
     *
     * @return 系统写好的随机算法
     */
    @Bean
    public IRule myRule(){
        //return new RoundRobinRule();轮询
        //return new RandomRule();随机
        return new RetryRule();//先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
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