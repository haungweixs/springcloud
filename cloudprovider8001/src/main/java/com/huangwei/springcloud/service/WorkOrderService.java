package com.huangwei.springcloud.service;

import com.huangwei.springcloud.bean.req.WorkOrderReq;

/**
 * Created by Hw
 * 21/04/12 13:52
 */
public interface WorkOrderService {

     String workorderMessage(WorkOrderReq workOrderReq);
}
