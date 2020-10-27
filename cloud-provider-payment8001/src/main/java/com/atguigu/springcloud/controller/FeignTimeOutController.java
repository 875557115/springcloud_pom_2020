package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: FeignTimeOutController
 * @Author: XunZQ
 * @Description:    测试链接超时，openfeign直接报错
 * @Date: Create in 14:20 2020/10/14
 * @Modificd By:
 * @Version: 1.0
 */
@RestController
@Slf4j
public class FeignTimeOutController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

}
