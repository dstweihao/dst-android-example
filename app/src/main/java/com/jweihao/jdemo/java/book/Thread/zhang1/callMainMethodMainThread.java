package com.jweihao.jdemo.java.book.Thread.zhang1;

/**
 * Created by weihao on 2018/4/11.
 */
public class callMainMethodMainThread {
    public static void main(String[] args) {
        ///////////////   《Java多线程编程核心技术》  ////////////////////////
        ///////////////   1.2 使用多线程  ////////////////////////
        ///////////////   1.2.1 继承Thread类  ////////////////////////

        System.out.println(Thread.currentThread().getName());
        // 输出mian
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");


    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("MyThread");
        }
    }

}
