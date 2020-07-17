package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {
    @RequestMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") Long id);
    @RequestMapping("/dept/list")
    List<Dept> queryAll();
    @RequestMapping("/dept/add")
    boolean addDept(Dept dept);
}
