package com.lt.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: PaymentHystrixService
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 12:13 2020/10/22
 * @Modificd By:
 * @Version: 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE" , fallback = PaymentFallbackService .class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
