package com.jweihao.jdemo.java;

/**
 * Created by weihao on 2018/4/11.
 */
public class randomThread {

    public static void main(String[] args) {

        ///////////////   演示Thread线程的随机性  ////////////////////////

        MyThread thread = new MyThread();
        thread.setName("myThread");
        thread.start();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 10; i++) {
                    int time = (int) (Math.random() * 1000);
                    Thread.sleep(time);
                    System.out.println("run=" + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
