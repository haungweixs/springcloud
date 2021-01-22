package com.huangwei.springcloud.controller;

import com.huangwei.springcloud.entities.Iteminfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by Hw
 * 21/01/22 15:11
 */
@RestController
@Slf4j
@RequestMapping("/Order")
@Api(tags = "消费者")
public class OrderController {

    public static  final  String PAYMENT_URL="http://localhost:8001/Iteminfo";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/query")
    @ApiOperation("消费者消费服务")
    private Iteminfo queryIteminfo(String id)
    {
         return restTemplate.postForObject(PAYMENT_URL+"/querybyid",id,Iteminfo.class);
    }
}
