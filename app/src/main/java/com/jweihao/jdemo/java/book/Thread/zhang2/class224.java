package com.jweihao.jdemo.java.book.Thread.zhang2;

/**
 * Created by weihao on 2018/4/14.
 */
public class class224 {

    public static void main(String[] args) {
        Task task = new Task();
        MyThread1 thread1 = new MyThread1(task);
        thread1.start();
        MyThread2 thread2 = new MyThread2(task);
        thread2.start();
    }

    public static class Task {
        public void doLongTimeTask() {
            for (int i = 0; i < 100; i++) {
                System.out.println("nosynchronized threadName=" + Thread.currentThread().getName() + " i=" + (i + 1));

            }
            System.out.println("");
            synchronized (this) {
                for (int i = 0; i < 100; i++) {

                    System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " i=" + (i + 1));

                }
            }
        }
    }

    public static class MyThread1 extends Thread {
        private Task mTask;

        public MyThread1(Task task) {
            mTask = task;
        }

        @Override
        public void run() {
            super.run();
            mTask.doLongTimeTask();
        }
    }

    public static class MyThread2 extends Thread {
        private Task mTask;

        public MyThread2(Task task) {
            mTask = task;
        }

        @Override
        public void run() {
            super.run();
            mTask.doLongTimeTask();
        }
    }

}
