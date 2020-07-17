package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/dept" )
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

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

    //服务信息，需要在启动类上启动
    @RequestMapping( "/discovery" )
    public Object discovery(){
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }

        List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept");
        for (ServiceInstance instance : instances) {
            System.out.println(
                  instance.getHost()+"\t"+
                  instance.getPort()+"\t"+
                  instance.getServiceId()
            );
        }
        return this.client;
    }
}
