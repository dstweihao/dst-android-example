package com.jweihao.jdemo.java.book.Thread.zhang2;

/**
 * Created by weihao on 2018/4/13.
 */
public class class216 {

    public static void main(String[] args) {

        //例子1：synchronized拥有锁重入的功能
        MyThread1 t1 = new MyThread1();
        t1.start();

        //////////////////////////////


        //例子2：可重入锁也支持在父子类继承的环境中。
        MyThread2 t2 = new MyThread2();
        t2.start();

        //此实验说明，当存在
    }


    public static class Service {

        synchronized public void service1() {
            System.out.println("service1");
            service2();
        }

        synchronized public void service2() {
            System.out.println("service2");
            service3();
        }

        synchronized public void service3() {
            System.out.println("service3");
        }
    }

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            Service service = new Service();
            service.service1();
            System.out.println("/////////////////////");
        }
    }

    /////////////////////////////////////////////

    //例子2：可重入锁也支持在父子类继承的环境中。

    public static class Main {
        public int i = 10;

        synchronized public void operateIMainMethod() {
            try {
                i--;
                System.out.println("main print i=" + i);
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Sub extends Main {
        synchronized public void operateISubMethod() {
            try {
                while (i > 0) {
                    i--;
                    System.out.println("sub print i=" + i);
                    Thread.sleep(100);
                    this.operateIMainMethod();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThread2 extends Thread {
        @Override
        public void run() {
            Sub sub = new Sub();
            sub.operateISubMethod();
        }
    }


}
