package com.qtatelier.springcloud.controller;

import com.qtatelier.springcloud.entities.Dept;
import com.qtatelier.springcloud.service.DeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author JazzXia
 * @create 2019-11-01-14:56
 * @email jazzxiaw@qq.com
 * @since 2019
 */

@RestController
public class Controller {

    @Resource
    private DeptService service;

    //@RequestMapping(value="/dept/add",method = RequestMethod.POST)
    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }


    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return service.list();
    }
}
