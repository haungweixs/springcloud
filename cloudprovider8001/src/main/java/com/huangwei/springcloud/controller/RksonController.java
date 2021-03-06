package com.huangwei.springcloud.controller;

import com.huangwei.springcloud.config.ApiResult;
import com.huangwei.springcloud.entities.Req;
import com.huangwei.springcloud.entities.Rkson;
import com.huangwei.springcloud.service.CksonService;
import com.huangwei.springcloud.service.RksonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.SoftHashMap;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Hw
 * 21/01/22 10:46
 */
@RestController
@Slf4j
@RequestMapping("/Iteminfo")
@Api(tags = "库存管理")
public class RksonController {

    @Resource
    RksonService rksonService;
    @Resource
    CksonService cksonService;

    @PostMapping("/updateInventory")
    @ApiOperation("库存更新")
    private ApiResult updateRepertory(Req req) {
        if (req.getType()==0){
          rksonService.updateProduct(req);
        }else {
          cksonService.updateProduct(req);
        }
        return new ApiResult(req);
    }

    @GetMapping("/findList/{id}")
    @ApiOperation("返回列表")
    public ApiResult<List<Rkson>> findRksonList(@PathVariable("id") String id) {
        if (id.equals("1")) {
            throw new RuntimeException("报错");
        } else {
            return ApiResult.success(rksonService.findRksonList());
        }
    }

}
