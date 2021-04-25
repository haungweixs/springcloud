package com.huangwei.springcloud.bean.req;

import lombok.Data;

/**
 * Created by Hw
 * 21/04/12 14:03
 */
@Data
public class WorkOrderReq {
    private String phone;
    private String address;
    private String seqno;
}
