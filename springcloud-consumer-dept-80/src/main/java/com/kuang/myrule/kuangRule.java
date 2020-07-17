package com.kuang.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//该类的包，不能放在启动类同级 (官网规定)
@Configuration
public class kuangRule {
    @Bean
    public IRule myRule(){
        return new KuangRandomRule();
    }

}
