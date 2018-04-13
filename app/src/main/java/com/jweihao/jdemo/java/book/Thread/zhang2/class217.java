package com.jweihao.jdemo.java.book.Thread.zhang2;

/**
 * Created by weihao on 2018/4/13.
 */
public class class217 {

    public static void main(String[] args) {

        // 程序运行：Exception in thread "a" java.lang.NumberFormatException: For input string: "a"
        // 线程a出现异常并释放锁，线程b进入方法正常打印，实现结论就是出现异常的锁被自动释放了。


        try {
            Service service = new Service();
            ThreadA a = new ThreadA(service);
            a.setName("a");
            a.start();
            Thread.sleep(500);
            ThreadB b = new ThreadB(service);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static class Service {
        synchronized public void testMethod() {
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " run beginTime=" + System.currentTimeMillis());
                int i = 1;
                while (i == 1) {
                    if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                        System.out.println("ThreadName=" + Thread.currentThread().getName() + " run  exceptionTime=" + System.currentTimeMillis());
                        Integer.parseInt("a");
                    }
                }
            } else {
                System.out.println("Thread B run Time=" + System.currentTimeMillis());
            }
        }
    }

    public static class ThreadA extends Thread {
        private Service mService;

        public ThreadA(Service service) {
            super();
            mService = service;
        }

        @Override
        public void run() {
            mService.testMethod();
        }
    }

    public static class ThreadB extends Thread {
        private Service mService;
        public ThreadB(Service service) {
            super();
            mService = service;
        }

        @Override
        public void run() {
            mService.testMethod();
        }
    }


}
