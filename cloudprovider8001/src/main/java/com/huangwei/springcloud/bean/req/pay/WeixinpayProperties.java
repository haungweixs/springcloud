package com.huangwei.springcloud.bean.req.pay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Hw
 * 21/04/14 10:57
 */

@Data
@Component
@ConfigurationProperties(prefix = "weixinpayconfig")
public class WeixinpayProperties {
    private String appid;

    private String mch_id;

    private String device_info;

    private String key;

    private String url;

    private String notify_url;

    private String return_url;

    private String wx_package;
}
