package com.lt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: PaymentHystrixMain8001
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 22:20 2020/10/20
 * @Modificd By:
 * @Version: 1.0
 */

@SpringBootApplication
@EnableEurekaClient
//开启服务降级
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}
