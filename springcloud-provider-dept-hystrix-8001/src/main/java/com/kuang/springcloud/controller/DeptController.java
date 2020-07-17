package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "queryByIdHystrix")
    public Dept queryById(@PathVariable( "id" ) Long id) {
        Dept dept = deptService.queryById(id);
        if (null == dept){
            throw new RuntimeException("没有这个部门，查询失败");
        }
        return dept;
    }

    @RequestMapping( "/list" )
    public List<Dept> queryAll() {

        return deptService.queryAll();
    }


    public Dept queryByIdHystrix(Long id) {
        Dept dept = new Dept("id=>"+id+",没有这个id");
        dept.setDeptno(id);
        dept.setDb_source("服务熔断进来的");
        return dept;
    }


}
