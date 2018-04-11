package com.jweihao.jdemo.java;

/**
 * Created by weihao on 2018/4/11.
 */
public class t4 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");
        Thread e = new Thread(myThread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }


    public static class MyThread extends Thread {
        private int count = 5;

        // 通过在run方法前加入synchronized关键字，使多个线程在执行run方法时，以排队的方式进行处理。
        @Override
        synchronized public void run() {
            super.run();
            count--;
            //此示例不要用for语句，因为使用同步后其他线程就得不到运行的机会了，会一直由一个线程进行减法运算。
            System.out.println("由" + MyThread.currentThread().getName() + " 计算.count=" + count);
        }
    }
}
