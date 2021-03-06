package com.huangwei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Hw
 * 21/01/22 15:09
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain8002.class,args);
    }

}
