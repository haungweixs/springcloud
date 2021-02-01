package com.huangwei.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.huangwei.springcloud.entities.Iteminfo;
import com.huangwei.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by Hw
 * 21/02/01 15:07
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Value("${server-url.provider-service-url}")
    public String PAYMENT_URL;

    @Resource
    private RestTemplate restTemplate;

    @Override
    @SentinelResource(value = "queryIteminfo",fallback = "exceptionHandler",blockHandler = "blockHandler")
    public Iteminfo queryIteminfo(String id) {

        if (id.equals("1")){
            throw new RuntimeException("报错");
        }
        return restTemplate.postForObject(PAYMENT_URL+"/querybyid",id,Iteminfo.class);
    }

    // 限流与阻塞处理
    public  Iteminfo exceptionHandler(String id) {
        Iteminfo iteminfo=new Iteminfo();
        iteminfo.setId("41515151");
        return iteminfo;
    }

    // 限流与阻塞处理
    public  Iteminfo blockHandler(String id,BlockException blockexception) {
        Iteminfo iteminfo=new Iteminfo();
        iteminfo.setId("配置规则报错");
        return iteminfo;
    }
}
