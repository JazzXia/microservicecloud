package com.qtatelier.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JazzXia
 * @create 2019-11-03-9:58
 * @email jazzxiaw@qq.com
 * @since 2019
 *
 * 在这里书写自己需要的算法，这里仅仅是实验随机
 *
 */
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        return new RandomRule();//Ribbon默认是轮询，我自定义为随机
    }
}