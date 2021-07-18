package com.ccl.springcloud.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @auther ccl
 * @create 2020/9/12 11:49
 */
@RestController
@Log4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/payment/zk")
    public String payentzk(){
        return "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
