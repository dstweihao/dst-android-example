package com.jweihao.jdemo.java;

/**
 * Created by weihao on 2018/4/11.
 */
public class sleep {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        System.out.println("begin =" + System.currentTimeMillis());
        //myThread1.run();  //MyThread1使用run()方法测试
        myThread1.start();  //MyThread2使用start()方法测试，代码相同，略。
        System.out.println("end =" + System.currentTimeMillis());
    }

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("run threadName=" + MyThread1.currentThread().getName() + " begin");
                Thread.sleep(2000);
                System.out.println("run threadName=" + MyThread1.currentThread().getName() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
