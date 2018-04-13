package com.jweihao.jdemo.java.book.Thread.zhang1;

/**
 * Created by weihao on 2018/4/11.
 */
public class t2 {

    public static void main(String[] args) {

        ///////////////   实现Runnable接口  ////////////////////////

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束！");
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("运行中！");
        }
    }
}
