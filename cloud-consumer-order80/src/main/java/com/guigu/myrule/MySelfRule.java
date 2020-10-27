package com.guigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MySelfRule
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 19:15 2020/10/13
 * @Modificd By:
 * @Version: 1.0
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule getRule(){
        return new RandomRule();  //随机
    }
}