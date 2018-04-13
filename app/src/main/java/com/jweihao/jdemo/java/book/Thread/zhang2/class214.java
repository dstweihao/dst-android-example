package com.jweihao.jdemo.java.book.Thread.zhang2;

/**
 * Created by weihao on 2018/4/13.
 */
public class class214 {

    public static void main(String[] args) {

        //共有4个例子

        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }

    public static class MyObject {
        //通过是否使用关键字synchronized来观察运行效果
        //例子1 ，不使用关键字synchronized
        //例子2 ，使用关键字synchronized
        synchronized public void methodA() {
            try {
                System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //通过是否使用关键字synchronized来观察运行效果
        //例子3 ，不使用关键字synchronized
        //例子4 ，使用关键字synchronized
        synchronized public void methodB() {
            try {
                System.out.println("begin methodB threadName=" + Thread.currentThread().getName() + " begin time=" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadA extends Thread {
        private MyObject mObject;

        public ThreadA(MyObject myObject) {
            super();
            this.mObject = myObject;
        }

        @Override
        public void run() {
            super.run();
            mObject.methodA();
        }
    }

    public static class ThreadB extends Thread {
        private MyObject mObject;

        public ThreadB(MyObject myObject) {
            super();
            this.mObject = myObject;
        }

        @Override
        public void run() {
            super.run();
//            mObject.methodA();  //例子1、2使用，是否使用关键字synchronized
            mObject.methodB();    //例子3、4使用,调用不同方法的线程类
        }
    }

}
