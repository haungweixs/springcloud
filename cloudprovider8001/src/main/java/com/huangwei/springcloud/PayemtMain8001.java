package com.huangwei.springcloud;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Hw
 * 21/01/21 17:55
 */
@SpringBootApplication
@ComponentScan("com.huangwei")
@EnableDiscoveryClient
public class PayemtMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PayemtMain8001.class,args);
    }

}
