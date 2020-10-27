package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentMain8004
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 23:41 2020/10/12
 * @Modificd By:
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient//该注解用于zookeeper和consul作为注册中心的服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
