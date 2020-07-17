package com.kuang.springcloud;

import com.kuang.myrule.kuangRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在配置微服务的时候，能记载我们自定义的ribbon类  （该注解不是必须的）
@RibbonClient(name="SPRINGCLOUD-PROVIDER-DEPT",configuration = kuangRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
