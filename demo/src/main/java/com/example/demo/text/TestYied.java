package com.example.demo.text;

/**
 * Created by Hw
 * 21/04/01 17:42
 */

//礼让不一定成功
//测试线程礼让
public class TestYied {

    public static void main(String[] args) {
        MyYield myYield=new MyYield();
        new Thread(myYield,"A").start();
        new Thread(myYield,"B").start();
    }

}

class MyYield implements Runnable
{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程结束执行");
    }
}
