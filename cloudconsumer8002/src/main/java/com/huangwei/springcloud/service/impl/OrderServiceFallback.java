package com.huangwei.springcloud.service.impl;


import com.huangwei.springcloud.config.ApiResult;
import com.huangwei.springcloud.entities.Req;
import com.huangwei.springcloud.entities.Rkson;
import com.huangwei.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Hw
 * 21/02/01 15:07
 */
@Slf4j
@Component
public class OrderServiceFallback implements OrderService {

    @Value("${server-url.provider-service-url}")
    public String PAYMENT_URL;


    @Override
    public ApiResult<List<Rkson>> findRksonList(String id) {
        log.info("熔断");
        return null;
    }

    @Override
    public ApiResult updateRepertory(Req req) {
        log.info("熔断");
        return null;
    }
}
