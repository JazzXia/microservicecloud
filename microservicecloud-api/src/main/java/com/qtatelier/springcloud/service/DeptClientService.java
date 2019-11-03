package com.qtatelier.springcloud.service;

import com.qtatelier.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author JazzXia
 * @create 2019-11-03-12:15
 * @email jazzxiaw@qq.com
 * @since 2019
 *
 *
 * 这个适用于Feign负载均衡的Service
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
  @FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept);
}
