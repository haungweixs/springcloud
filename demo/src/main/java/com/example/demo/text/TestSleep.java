package com.example.demo.text;

import lombok.SneakyThrows;

/**
 * Created by Hw
 * 21/04/01 17:01
 */
//模拟网络延时
public class TestSleep implements Runnable {


    int ticket=10;

    public ThreadLocal threadLocal=new ThreadLocal();

    @SneakyThrows
    @Override
    public void run() {
       while (true){
           threadLocal.set(ticket);
           Integer threadLocalTicket=Integer.valueOf(threadLocal.get().toString());
           if(threadLocalTicket<=0){
               break;
           }
           Thread.sleep(100);
           System.out.println(Thread.currentThread().getName()+"拿到了---》"+ticket--);
       }
    }

    public static void main(String[] args) {
        TestSleep testSleep=new TestSleep();
        Thread thread1=new Thread(testSleep,"小明");
        Thread thread2=new Thread(testSleep,"小黄");
        Thread thread3=new Thread(testSleep,"黄牛");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
