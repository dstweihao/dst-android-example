package com.jweihao.jdemo.java.book.Thread.zhang2;

/*
 * 创建者 韦豪
 * 创建时间 2018/4/14 0014 21:15
 */
public class class226 {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        MyThread1 thread1 = new MyThread1(task);
        thread1.start();
        Thread.sleep(100);
        MyThread2 thread2 = new MyThread2(task);
        thread2.start();
    }

    public static class Task {
        synchronized public void otherMethod() {
            System.out.println("----------------------------------------------------------run--otherMethod");
        }

        public void doLongTimeTask() {
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
            super();
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
            super();
            mTask = task;
        }

        @Override
        public void run() {
            super.run();
            mTask.otherMethod();
        }
    }

}
