package com.huangwei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by Hw
 * 21/01/21 17:55
 */
@SpringBootApplication
@ComponentScan("com.huangwei")
public class PayemtMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PayemtMain8001.class,args);
    }

}
