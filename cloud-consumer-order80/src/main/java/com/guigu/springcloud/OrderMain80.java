package com.guigu.springcloud;

import com.guigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: OrderMain80
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 19:32 2020/10/10
 * @Modificd By:
 * @Version: 1.0
 */

@SpringBootApplication
/*@ComponentScan(basePackages = {"com.guigu.springcloud.config",
                            "com.guigu.springcloud.controller"})*/
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }

}
