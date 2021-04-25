package com.example.demo.text;

/**
 * Created by Hw
 * 21/03/26 15:03
 */

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**模拟龟兔赛跑*/
public class Race implements Runnable{

    /**声明胜利者*/
    public String winner;

    Lock lock=new ReentrantLock();

    @SneakyThrows
    @Override
    public  void run() {
       for (int i=0;i<=100;i++){
           //上锁
           lock.lock();
           if(gameOver(i)){
               break;
           }
               System.out.println(Thread.currentThread().getName()+"跑了第"+i+"步");
           lock.unlock();
       }
    }

    public boolean gameOver(int steps)
    {
        if (winner!=null){
            return true;
        }
        {
            if(steps==100)
            {
                this.winner=Thread.currentThread().getName();
                System.out.println(this.winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race=new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
