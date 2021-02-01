package com.huangwei.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.huangwei.springcloud.entities.Iteminfo;
import com.huangwei.springcloud.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
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

    @Autowired
    OrderService orderService;

    @GetMapping("/query")
    @ApiOperation("消费者消费服务")
    private Iteminfo queryIteminfo(String id)
    {
        return orderService.queryIteminfo(id);
    }
}


