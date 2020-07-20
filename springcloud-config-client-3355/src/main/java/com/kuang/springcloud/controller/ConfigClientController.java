package com.kuang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("/config")
    public String getConfig(){
        return "port:"+port+"name:"+name;
    }

}
