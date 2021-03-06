package com.ccl.springcloud.controller;

import com.ccl.springcloud.entities.CommonResult;
import com.ccl.springcloud.entities.Payment;
import com.ccl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymnetController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody  Payment payment){
        int result = paymentService.save(payment);
        log.info("********插入結果，"+result);

        if(result>0){
            return new CommonResult(200,"插入数据库成功，serverPort "+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败，serverPort "+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果，"+payment);

        if(payment != null){
            return new CommonResult(200,"查询成功，serverPort"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有这条记录，查询ID："+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object dicovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services){
            log.info("*****: " + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //暂停几秒钟
        try{ TimeUnit.SECONDS.sleep(3); }catch (InterruptedException e){  e.printStackTrace();}
        return serverPort;
    }
}
