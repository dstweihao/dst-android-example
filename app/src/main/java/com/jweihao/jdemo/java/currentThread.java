package com.jweihao.jdemo.java;

/**
 * Created by weihao on 2018/4/11.
 */
public class currentThread {

    public static void main(String[] args) {

        ///////////////   1.3 currentThread()方法  ////////////////////////

        System.out.println(Thread.currentThread().getName());
        //打印输出 main

        MyThread myThread = new MyThread();
        myThread.start();
        //myThread.run();

        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        t1.setName("A");
        t1.start();
    }

    public static class MyThread extends Thread {
        public MyThread() {
            System.out.println("构造方法的打印：" + Thread.currentThread().getName());

        }

        @Override
        public void run() {
            System.out.println("run方法的打印：" + Thread.currentThread().getName());
        }
    }

    public static class CountOperate extends Thread {
        public CountOperate() {
            System.out.println("CountOperate----begin");
            System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
            System.out.println("this.getName()=" + this.getName());
            System.out.println("CountOperate----end");

        }
    }

}
