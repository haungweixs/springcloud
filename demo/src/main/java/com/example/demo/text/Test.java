package com.example.demo.text;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Hw
 * 21/03/26 11:52
 */
public class Test{

    //注意线程开启不一定立即执行

    public static void main(String[] args){
//        GetMarried o = (GetMarried) Proxy.newProxyInstance(GetMarried.class.getClassLoader(),You.class.getInterfaces(),new Wedding(new You()));
//        o.HappyMarried();
        GetMarried getMarried=new You();
        new Thread(() -> { System.out.println("草泥马"); }).start();
        new Wedding(getMarried).HappyMarried();
    }

}
