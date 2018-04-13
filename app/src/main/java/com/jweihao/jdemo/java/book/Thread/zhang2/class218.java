package com.jweihao.jdemo.java.book.Thread.zhang2;

/**
 * Created by weihao on 2018/4/13.
 */
public class class218 {

    public static void main(String[] args) {
        Sub subRef = new Sub();
        MyThreadA a = new MyThreadA(subRef);
        a.setName("A");
        a.start();

        MyThreadB b = new MyThreadB(subRef);
        b.setName("B");
        b.start();
    }

    public static class Main {
        synchronized public void serviceMethod() {
            try {

                System.out.println("int main 下一步 sleep begin threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("int main 下一步 sleep   end threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Sub extends Main {
        @Override
        public synchronized void serviceMethod() {
            try {
                System.out.println("int  sub 下一步 sleep begin threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("int  sub 下一步 sleep   end threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
                super.serviceMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class MyThreadA extends Thread {
        private Sub mSub;

        public MyThreadA(Sub sub) {
            mSub = sub;
        }

        @Override
        public void run() {
            mSub.serviceMethod();
        }
    }

    public static class MyThreadB extends Thread {
        private Sub mSub;

        public MyThreadB(Sub sub) {
            mSub = sub;
        }

        @Override
        public void run() {
            mSub.serviceMethod();
        }
    }

}
