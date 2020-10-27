package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.guigu.springcloud.entity.CommonResult;
import com.guigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentController
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 18:36 2020/10/12
 * @Modificd By:
 * @Version: 1.0
 */

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;


    @PostMapping("payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = this.paymentService.create(payment);
        log.info("****插入结果"+result);
        if(result>0){
            return new CommonResult(200,"插入成功"+serverPort,result);
        }else{
            return new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = this.paymentService.getPaymentById(id);
        log.info("****查询结果为"+payment);
        if(null!=payment){
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }else{
            return new CommonResult(400,"查询失败",null);
        }
    }





}
