package com.huangwei.springcloud.controller;

import com.huangwei.springcloud.entities.Iteminfo;
import com.huangwei.springcloud.service.IteminfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hw
 * 21/01/22 10:46
 */
@RestController
@Slf4j
@RequestMapping("/Iteminfo")
@Api(tags = "测试接口")
public class IteminfoController {

    @Autowired
    IteminfoService iteminfoService;

    @PostMapping("/querybyid")
    @ApiOperation("查询测试功能")
    private Iteminfo queryIteminfo(@RequestBody String id)
    {
        log.info("进入查询方法");
        return iteminfoService.getById(id);
    }


}
