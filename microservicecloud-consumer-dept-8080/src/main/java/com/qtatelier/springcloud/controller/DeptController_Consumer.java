package com.qtatelier.springcloud.controller;

import com.qtatelier.springcloud.entities.Dept;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author JazzXia
 * @create 2019-11-01-18:18
 * @email jazzxiaw@qq.com
 * @since 2019
 *
 * 消费者类
 * 本质上来说，消费者仅仅用就可以
 * 不需要服务层
 *
 * 只需要通过restTemplate来进行对RESTful编码风格的请求进行修改
 *
 *  使用restTemplate访问restful接口非常的简单粗暴无脑。
 *  restTemplate.postForObject(url, requestMap, ResponseBean.class)这三个参数分别代表
 *  REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
 *
 */
@RestController
public class DeptController_Consumer {
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //修改客户端的访问类，也就是说从原先通过8001端口访问修改为通过微服务名来访问。
    //这样写的好处就是不再是写死的端口号，而是动态的服务名
    //Ribbon和Eureka整合后Consumer可以直接调用服务而不用再关心地址和端口号
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Resource
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> get(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }


    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    }

}
