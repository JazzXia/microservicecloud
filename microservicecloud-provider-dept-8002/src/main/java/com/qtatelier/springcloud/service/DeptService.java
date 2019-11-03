package com.qtatelier.springcloud.service;

import com.qtatelier.springcloud.entities.Dept;

import java.util.List;

/**
 * @author JazzXia
 * @create 2019-11-01-14:40
 * @email jazzxiaw@qq.com
 * @since 2019
 */


public interface DeptService {
    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}

