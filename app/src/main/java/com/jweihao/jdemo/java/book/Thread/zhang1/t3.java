package com.jweihao.jdemo.java.book.Thread.zhang1;

/**
 * Created by weihao on 2018/4/11.
 */
public class t3 {

    public static void main(String[] args) {

        ///////////////   1.2.3 实例变量与线程安全 多线程进行交互，不共享数据的情况  ////////////////////////

        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }

    public static class MyThread extends Thread {
        private int count = 5;

        public MyThread(String name) {
            super();
            //设置线程名称
            this.setName(name);
        }

        @Override
        public void run() {
            super.run();
            while (count > 0) {
                count--;
                System.out.println("由" + MyThread.currentThread().getName() + "计算.count=" + count);

            }
        }
    }
}

