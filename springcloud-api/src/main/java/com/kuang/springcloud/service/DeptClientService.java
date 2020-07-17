package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
//value = eureka中服务名称
//fallbackFactory = 服务降级的实现类
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallFactory.class)
public interface DeptClientService {
    @RequestMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") Long id);
    @RequestMapping("/dept/list")
    List<Dept> queryAll();
    @RequestMapping("/dept/add")
    boolean addDept(Dept dept);
}
