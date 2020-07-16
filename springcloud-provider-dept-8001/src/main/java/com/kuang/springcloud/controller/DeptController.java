package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/dept" )
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping( "/add" )
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping( "/get/{id}" )
    public Dept queryById(@PathVariable( "id" ) Long id) {
        return deptService.queryById(id);
    }

    @RequestMapping( "/list" )
    public List<Dept> queryAll() {

        return deptService.queryAll();
    }
}
