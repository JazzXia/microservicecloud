package com.qtatelier.springcloud.dao;

import com.qtatelier.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author JazzXia
 * @create 2019-11-01-14:25
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}

