package com.huangwei.springcloud.bean.req;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Hw
 * 21/04/09 16:30
 */
public class RandomNo {

    public static String  createNo(){
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHH");
        Date date =new Date();
        String str=simpleDateFormat.format(date);
        Random random=new Random();
        int rannum=(int) (random.nextDouble()*(99999-10000+1))+10000;//获取5位随机数
        String  No =str +"-"+  rannum;
        return  No;
    }
}
