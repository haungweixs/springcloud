package com.huangwei.springcloud.controller;

import com.huangwei.springcloud.config.ApiResult;
import com.huangwei.springcloud.entities.Req;
import com.huangwei.springcloud.entities.Rkson;
import com.huangwei.springcloud.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Hw
 * 21/01/22 15:11
 */
@RestController
@Slf4j
@RequestMapping("/Order")
@Api(tags = "消费者")
public class OrderController {

    @Resource
    OrderService orderService;

    @GetMapping("/query")
    @ApiOperation("消费者消费服务")
    private ApiResult<List<Rkson>> queryIteminfo(String id){
//        try { TimeUnit.MILLISECONDS.sleep(800); }catch (InterruptedException e){ e.printStackTrace(); }
        return orderService.findRksonList(id);
    }

    @PostMapping("/querybyid")
    @ApiOperation("查询测试功能")
    private ApiResult updateRepertory(@RequestBody Req req)
    {
        return orderService.updateRepertory(req);
    }
}


