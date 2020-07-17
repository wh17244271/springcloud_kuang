package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 监控的服务必须配置固定写法  案例 (springcloud-provider-dept-hystrix-8001 包中的 启动类 有例子 )
 */
@SpringBootApplication
@EnableHystrixDashboard //开启监控
public class DeptConsumer_Dashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Dashboard_9001.class, args);
    }
}
