package com.lt.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;


/**
 * @ClassName: HystrixDashboardMain9001
 * @Author: XunZQ
 * @Description:
 * @Date: Create in 18:46 2020/10/22
 * @Modificd By:
 * @Version: 1.0
 */

@SpringBootApplication
// 启动图形化监控
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }

    // 为解决 hystrix图形化监控界面出现的Unable to connect to Command Metric Stream错误提示
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;

    }
}
