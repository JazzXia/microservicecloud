package com.qtatelier.springcloud.controller;

import com.qtatelier.springcloud.entities.Dept;
import com.qtatelier.springcloud.service.DeptClientService;
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
 * <p>
 * 消费者类
 * 本质上来说，消费者仅仅用就可以
 * 不需要服务层
 * <p>
 * 只需要通过restTemplate来进行对RESTful编码风格的请求进行修改
 * <p>
 * 使用restTemplate访问restful接口非常的简单粗暴无脑。
 * restTemplate.postForObject(url, requestMap, ResponseBean.class)这三个参数分别代表
 * REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
 */
@RestController
public class DeptController_Consumer {

    @Resource
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept) {
        return this.service.add(dept);
    }

}
