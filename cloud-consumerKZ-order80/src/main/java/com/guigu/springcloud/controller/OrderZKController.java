package com.guigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: OrderZKController
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 8:59 2020/10/13
 * @Modificd By:
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumerZK")
public class OrderZKController {

    @Autowired
    private RestTemplate restTemplate;
    private static final String url="http://cloud-provider-payment";

    @GetMapping("/payment/zk")
    public String paymentZk(){
        log.info("*****开始进行远程调用8004端口号*****");
        return restTemplate.getForObject(url+"/payment/zk",String.class);
    }
}
