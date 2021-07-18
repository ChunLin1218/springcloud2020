package com.ccl.springcloud;

import com.ccl.springcloud.entities.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther ccl
 * @create 2020/9/12 11:45
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用户向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
