package com.huangwei.springcloud.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huangwei.springcloud.bean.req.*;
import com.huangwei.springcloud.service.WorkOrderService;
import com.huangwei.springcloud.util.Constants;
import com.huangwei.springcloud.util.MD5;
import org.springframework.stereotype.Service;

/**
 * Created by Hw
 * 21/04/12 13:52
 */

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    @Override
    public String workorderMessage(WorkOrderReq workOrderReq) {
        Constants.dateTime= com.huangwei.springcloud.util.DateUtils.getNowDateTimeString();
        String SigParameter= MD5.encode(Constants.ACCOUNTSid+ Constants.ACCOUNT_TOKEN+Constants.dateTime);
        String YUNUrl="https://app.cloopen.com:8883/2013-12-26/Accounts/8a48b5515350d1e201537968ad5642ea/SMS/TemplateSMS?sig="+SigParameter;
        YunTo yunTo=new YunTo();
        yunTo.setTo(workOrderReq.getPhone());
        yunTo.setAppId("8a216da878005a800178b5a3e5fc43b0");
        yunTo.setTemplateId("947909");
        YsAddress ysAddress= JSONObject.parseObject(workOrderReq.getAddress(),YsAddress.class);
        yunTo.setDatas("['"+workOrderReq.getSeqno()+"','"+ysAddress.getAddress()+"']");
        yunTo.setSubAppend("8888");
        yunTo.setReqId(RandomNo.createNo());
        String json= JSON.toJSONString(yunTo);
        String yuntojson= HttpClient.postNotData(json,YUNUrl,"utf-8",yunTo);
        return yuntojson;
    }
}
