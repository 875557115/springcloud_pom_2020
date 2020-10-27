package com.lt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: PaymentHystrixMain80
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 10:43 2020/10/21
 * @Modificd By:
 * @Version: 1.0
 */

@SpringBootApplication
@EnableFeignClients
// 启动Hystrix
@EnableHystrix
public class PaymentHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain80.class,args);
    }


}
