package com.lt.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName: PaymentFallbackService
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 15:23 2020/10/22
 * @Modificd By:
 * @Version: 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---PaymentFabllbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---PaymentFabllbackService fall back-paymentInfo_TimeOut";
    }
}
