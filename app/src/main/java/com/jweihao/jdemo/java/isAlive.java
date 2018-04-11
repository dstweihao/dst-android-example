package com.jweihao.jdemo.java;

/**
 * Created by weihao on 2018/4/11.
 */
public class isAlive {


    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("begin ==" + myThread.isAlive());
        myThread.start();
        Thread.sleep(1000);
        System.out.println("end ==" + myThread.isAlive());


        /////////////////////
        System.out.println("///////////////////////");

        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive=" + t1.isAlive());
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("run=" + this.isAlive());
        }
    }

    public static class CountOperate extends Thread {
        public CountOperate() {
            System.out.println("CountOperate---begin");
            System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
            System.out.println("this.getName()=" + this.getName());
            System.out.println("this.isAlive()=" + this.isAlive());
            System.out.println("CountOperate---end");

        }

        @Override
        public void run() {
            System.out.println("run---begin");
            System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
            System.out.println("this.getName()=" + this.getName());
            System.out.println("this.isAlive()=" + this.isAlive());
            System.out.println("run---end");
        }
    }

}
