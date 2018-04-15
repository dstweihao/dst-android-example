package com.jweihao.jdemo.java.book.Thread.zhang2;

/*
 * 创建者 韦豪
 * 创建时间 2018/4/15 0015 9:16
 */
public class class227_2 {

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }

    public static class Service {
        private String anyString = new String();

        public void a() {
            try {
                synchronized (anyString) {
                    System.out.println("a begin");
                    Thread.sleep(3000);
                    System.out.println("a   end");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized public void b() {
            System.out.println("b begin");
            System.out.println("b   end");
        }
    }


    public static class ThreadA extends Thread {
        private Service mService;

        public ThreadA(Service service) {
            mService = service;
        }

        @Override
        public void run() {
            super.run();
            mService.a();
        }
    }

    public static class ThreadB extends Thread {
        private Service mService;

        public ThreadB(Service service) {
            mService = service;
        }

        @Override
        public void run() {
            super.run();
            mService.b();
        }
    }
}
