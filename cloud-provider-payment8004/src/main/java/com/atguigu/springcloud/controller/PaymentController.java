package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName: PaymentController
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 23:42 2020/10/12
 * @Modificd By:
 * @Version: 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springclloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
