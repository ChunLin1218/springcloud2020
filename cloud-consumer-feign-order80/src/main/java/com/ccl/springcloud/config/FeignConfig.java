package com.ccl.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther ccl
 * @create 2020/12/12 20:07
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
