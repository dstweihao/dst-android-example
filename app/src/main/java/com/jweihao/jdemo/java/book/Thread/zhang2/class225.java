package com.jweihao.jdemo.java.book.Thread.zhang2;

/**
 * Created by weihao on 2018/4/14.
 */
public class class225 {

    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }


    public static class ObjectService {
        public void serviceMethodA() {
            try {
                synchronized (this) {
                    System.out.println("A begin time=" + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("A end    end=" + System.currentTimeMillis());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void serviceMethodB() {
            synchronized (this) {
                System.out.println("B begin time=" + System.currentTimeMillis());
                System.out.println("B end    end=" + System.currentTimeMillis());
            }
        }
    }

    public static class ThreadA extends Thread {
        private ObjectService mService;

        public ThreadA(ObjectService service) {
            mService = service;
        }

        @Override
        public void run() {
            super.run();
            mService.serviceMethodA();
        }
    }

    public static class ThreadB extends Thread {
        private ObjectService mService;

        public ThreadB(ObjectService service) {
            mService = service;
        }

        @Override
        public void run() {
            super.run();
            mService.serviceMethodB();
        }
    }


}
