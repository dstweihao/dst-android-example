package com.jweihao.jdemo.java;

/**
 * Created by weihao on 2018/4/11.
 */
public class z {

    public static void main(String[] args) {

        ///////////////   1.2.1 继承Thread类 执行start()方法的顺序不代表线程启动的顺序  ////////////////////////

        MyThread tl1 = new MyThread(1);
        MyThread tl2 = new MyThread(2);
        MyThread tl3 = new MyThread(3);
        MyThread tl4 = new MyThread(4);
        MyThread tl5 = new MyThread(5);
        MyThread tl6 = new MyThread(6);
        MyThread tl7 = new MyThread(7);
        MyThread tl8 = new MyThread(8);
        MyThread tl9 = new MyThread(9);
        MyThread tl10 = new MyThread(10);
        MyThread tl11 = new MyThread(11);
        MyThread tl12 = new MyThread(12);
        MyThread tl13 = new MyThread(13);
        tl1.start();
        tl2.start();
        tl3.start();
        tl4.start();
        tl5.start();
        tl6.start();
        tl7.start();
        tl8.start();
        tl9.start();
        tl10.start();
        tl11.start();
        tl12.start();
        tl13.start();

    }


    public static class MyThread extends Thread {

        private int i;

        public MyThread(int i) {
            super();
            this.i = i;
        }

        @Override
        public void run() {
            super.run();
            System.out.println(i);
        }
    }
}

