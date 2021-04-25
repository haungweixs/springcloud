package com.huangwei.springcloud.bean.req;

import com.huangwei.springcloud.bean.http.Header;
import com.huangwei.springcloud.util.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Map;

/**
 * Created by Hw
 * 21/04/09 16:43
 */
public class HttpClient {


    public static String postNotData(String requestStr, String uri, String charset,Header header){
        HttpURLConnection urlcon=null;
        InputStream in = null;
        OutputStream out = null;
        String result = null;
        try {
            URL url = new URL(uri);
            urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setRequestMethod("POST");
            // 设置通用的请求属性
            urlcon.setRequestProperty("accept", "*/*");
            urlcon.setRequestProperty("connection", "Keep-Alive");
            urlcon.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            urlcon.setRequestProperty("Content-Type", "application/json");
            for(Map.Entry<String,String> map:header.httpurlConnectionFactory().entrySet()){
                 urlcon.setRequestProperty(map.getKey(),map.getValue());
            }
            urlcon.setDoOutput(true);
            urlcon.setDoInput(true);
            urlcon.connect();// 获取连接
            out = urlcon.getOutputStream();
            out.write(requestStr.getBytes(charset));
            out.flush();
            in = urlcon.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(in, charset));
            StringBuffer bs = new StringBuffer();
            String line = null;
            while ((line = buffer.readLine()) != null) {
                bs.append(line);
            }
            result = bs.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null!=in)
                    in.close();
                if (null!=out)
                    out.close();
                if (null!=urlcon)
                    urlcon.disconnect();
            }catch (Exception e1){

            }
        }
        return result;
    }
}
