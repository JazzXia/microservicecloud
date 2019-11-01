package com.qtatelier.springcloud;

import com.qtatelier.springcloud.service.DeptService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-11-01-16:06
 * @email jazzxiaw@qq.com
 * @since 2019
 */

@SpringBootTest
public class TestController {

    @Resource
    DeptService deptService;

    @Test
    public void testController(){
        int id = 65;
        System.out.println(deptService.get((long) id));
    }
    
}
