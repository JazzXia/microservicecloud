package com.qtatelier.springcloud.service.impl;

import com.qtatelier.springcloud.dao.DeptDao;
import com.qtatelier.springcloud.entities.Dept;
import com.qtatelier.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author JazzXia
 * @create 2019-11-01-14:43
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Resource
    DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return false;
    }

    @Override
    public Dept get(Long id) {
        return null;
    }

    @Override
    public List<Dept> list() {
        return null;
    }
}
