package com.huangwei.springcloud.bean.req;

import com.google.common.collect.Maps;
import com.huangwei.springcloud.bean.http.Header;
import com.huangwei.springcloud.service.impl.WorkOrderServiceImpl;
import com.huangwei.springcloud.util.Constants;
import lombok.Data;
import org.apache.shiro.util.SoftHashMap;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;
import java.util.Map;

/**
 * Created by Hw
 * 21/04/09 16:27
 */
@Data
public class YunTo implements Header {
    private  String to;
    private  String appId;
    private  String templateId;
    private  String datas;
    private  String data;
    private  String subAppend;
    private  String reqId;
    private  String dateTime;

    @Override
    public Map httpurlConnectionFactory() throws Exception {
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = Constants.ACCOUNTSid+":"+Constants.dateTime;
        final byte[] textByte = text.getBytes("UTF-8");
        final String encodedText = encoder.encodeToString(textByte);
        Map<String, String> header = Maps.newHashMap();
        header.put("Authorization",encodedText);
        return header;
    }
}
