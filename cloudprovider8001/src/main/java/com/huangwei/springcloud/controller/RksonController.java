package com.huangwei.springcloud.controller;

import com.huangwei.springcloud.config.ApiResult;
import com.huangwei.springcloud.entities.Req;
import com.huangwei.springcloud.entities.Rkson;
import com.huangwei.springcloud.service.CksonService;
import com.huangwei.springcloud.service.RksonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hw
 * 21/01/22 10:46
 */
@RestController
@Slf4j
@RequestMapping("/Iteminfo")
@Api(tags = "测试接口")
public class RksonController {

    @Autowired
    RksonService rksonService;
    @Autowired
    CksonService cksonService;

    @PostMapping("/querybyid")
    @ApiOperation("查询测试功能")
    private ApiResult updateRepertory(@RequestBody Req req)
    {
//        if (req.getType()==0){
//          rksonService.updateProduct(req);
//        }else {
//          cksonService.updateProduct(req);
//        }
        return new ApiResult(req);
    }

    @GetMapping("/findList/{id}")
    @ApiOperation("返回列表")
    public ApiResult<List<Rkson>> findRksonList(@PathVariable("id") String id)
    {
        if (id.equals("1")){
            throw new RuntimeException("报错");
        }else {
            return ApiResult.success(rksonService.findRksonList());
        }
    }

}