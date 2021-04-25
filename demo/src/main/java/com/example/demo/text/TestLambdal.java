package com.example.demo.text;

import org.apache.logging.log4j.util.LambdaUtil;
import org.springframework.boot.util.LambdaSafe;

/**
 * Created by Hw
 * 21/04/01 13:31
 */
public class TestLambdal {
    //静态内部类
    public static void main(String[] args) {
        Thread thread1=new Thread(new Like());
        thread1.start();

        for(int i=0;i<1000;i++){
            System.out.println("主线程循环数"+i);
            if(i==900){
                Like.bool=false;
            }
        }
    }


}


interface Ilike{
    void lamber(Integer a);
}

class  Like implements Runnable
{
   static boolean bool=true;
   int i=0;
    @Override
    public void run() {
        while (bool){
            System.out.println("likeRunnable-----"+i++);
        }
    }
}

