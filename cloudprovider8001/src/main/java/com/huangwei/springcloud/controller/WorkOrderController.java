package com.huangwei.springcloud.controller;

import com.huangwei.springcloud.bean.req.WorkOrderReq;
import com.huangwei.springcloud.config.ApiResult;
import com.huangwei.springcloud.service.WorkOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Hw
 * 21/04/09 16:16
 */
@Api(tags = "工单管理")
@RestController
@RequestMapping("/workorder")
public class WorkOrderController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    WorkOrderService workOrderService;

    @PostMapping("/addmessage")
    @ApiOperation(value = "到货提醒")
    public ApiResult<String> workorderMessage(WorkOrderReq workOrderReq) throws Exception {

        return ApiResult.success(workOrderService.workorderMessage(workOrderReq));
    }
}
