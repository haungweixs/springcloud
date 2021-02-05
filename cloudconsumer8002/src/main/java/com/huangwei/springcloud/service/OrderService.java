package com.huangwei.springcloud.service;

import com.huangwei.springcloud.config.ApiResult;
import com.huangwei.springcloud.entities.Req;
import com.huangwei.springcloud.entities.Rkson;
import com.huangwei.springcloud.service.impl.OrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Hw
 * 21/02/01 15:07
 */
@FeignClient(name = "cloud-payemt-service",path = "/Iteminfo",fallback = OrderServiceFallback.class)
public interface OrderService {


     @GetMapping(value = "/findList/{id}")
     ApiResult<List<Rkson>> findRksonList(@PathVariable("id")String id);

     @PostMapping(value = "/querybyid")
     ApiResult updateRepertory(@RequestBody Req req);
}
