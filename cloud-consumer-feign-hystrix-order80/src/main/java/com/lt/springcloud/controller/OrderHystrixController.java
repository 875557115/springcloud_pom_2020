package com.lt.springcloud.controller;

import com.lt.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderHystrixController
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 11:24 2020/10/21
 * @Modificd By:
 * @Version: 1.0
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod" )
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /*1>.OK*/
    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    /*2>.timeOut*/
   @GetMapping("/consumer/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value= "1000")
    })
    //@HystrixCommand
    //这里设置的时间是1.5s,就是说调用服务会等待1.5s,如果超过了就会走fallbackMethod方法
    //而我们在支付的微服务中,时间是3s
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10分钟后再试或者自己运行出错请检查自己！";
    }

    //globol fallback

    //下面是全局fallback方法
   public String payment_Global_FallbackMethod(){
        return "Global异常处理信息,请稍后再试！！";
    }

}
