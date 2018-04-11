package com.jweihao.jdemo.java;

/**
 * Created by weihao on 2018/4/11.
 */
public class sameNum {

    public static void main(String[] args) {

        ///////////////   1.2.3 留意i--与System.out.println()的异常   ////////////////////////

        MyThread run = new MyThread();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        Thread t5 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    public static class MyThread extends Thread {
        private int i = 5;
        @Override
       synchronized public void run() {
            super.run();
            System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
            //注意：代码i--由前面项目中单独一行运行改成在当前项目中在println()方法中直接进行打印

        }
    }
}
