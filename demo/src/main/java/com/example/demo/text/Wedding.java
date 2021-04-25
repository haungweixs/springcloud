package com.example.demo.text;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Hw
 * 21/03/26 16:58
 */
public class Wedding implements GetMarried,InvocationHandler {

    GetMarried getMarried;

    public Wedding(GetMarried getMarried) {
        this.getMarried=getMarried;
    }

    @Override
    public void HappyMarried() {
        before();
        getMarried.HappyMarried();
        after();
    }

    private void after() {
        System.out.println("婚庆结束,收尾款");
    }

    private void before() {
        System.out.println("婚庆开始,准备布置!");
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke=method.invoke(getMarried,args);
        after();
        return invoke;
    }
}
