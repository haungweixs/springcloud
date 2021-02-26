package com.huangwei.springcloud.controller;

import com.huangwei.springcloud.config.ApiResult;
import com.huangwei.springcloud.entities.Product;
import com.huangwei.springcloud.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Hw
 * 21/02/24 13:39
 */
@Api(tags = "产品管理")
@RestController("product")
public class ProductController {

    @Resource
    ProductService productService;
    @Resource
    RabbitTemplate rabbitTemplate;

    @ApiOperation(value = "查询产品")
    @GetMapping("querylist")
    public ApiResult<List<Product>> findList()
    {
        rabbitTemplate.convertAndSend("TopicExchange","topic.man",productService.list().get(0));
//        rabbitTemplate.convertAndSend("FanoutExchange",null,productService.list().get(0));
        return ApiResult.success(productService.list());
    }

    @ApiOperation(value = "新增产品")
    @GetMapping("addproduct")
    public ApiResult<List<Product>> addProduct()
    {
        rabbitTemplate.convertAndSend("TopicExchange",".woman.topic",productService.list().get(0));
//        rabbitTemplate.convertAndSend("FanoutExchange",null,productService.list().get(0));
        return ApiResult.success(productService.list());
    }

}
