package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-08-24
 **/
@Configuration
public class MyselfRule {
    @Bean
    public IRule myselfRule(){
        return new RandomRule();
    }
}
