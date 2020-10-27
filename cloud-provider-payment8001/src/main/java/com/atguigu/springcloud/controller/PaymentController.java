package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.guigu.springcloud.entity.CommonResult;
import com.guigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    //通过端口不同实现轮询负载
    @Value("${server.port}")
    private String serverPort;
    //对注册进eureka里面的微服务，可以通过服务发现来获取该服务的信息
    @Resource
    private DiscoveryClient discoveryClient;


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


    /*服务发现Discovery*/
    @GetMapping("payment/discovery")
    public Object discovery(){
        /*
        这个services是指的:所有的微服务注册的名称CLOUD-CONSUMER-ORDER | CLOUD-PAYMENT-SERVICE
        */
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element:"+element);
        }
        //这里的instances是： payment8002 , payment8001
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            //serverId：CLOUD-PAYMENT-SERVICEhost:192.168.200.1 port:8002
            //serverId：CLOUD-PAYMENT-SERVICEhost:192.168.200.1 port:8001
            log.info("*****serverId："+instance.getServiceId()+"/t"+"host:"+instance.getHost()+"/t"+"port:"+instance.getPort());
        }
        return this.discoveryClient;
    }

}
