package com.jweihao.jdemo.java.book.Thread.zhang2;

/**
 * Created by weihao on 2018/4/13.
 */
public class class211 {

    public static void main(String[] args) {

        //2.1.1 方法内的变量为线程安全
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        Thread aThread = new ThreadA(numRef);
        aThread.start();
        ThreadB bThread = new ThreadB(numRef);
        bThread.start();
    }

    public static class HasSelfPrivateNum {
        //在方法前使用synchronized关键字
        synchronized public void addI(String username) {
            try {
                int num = 0;
                if (username.equals("a")) {
                    num = 100;
                    System.out.println("a set over!");
                    Thread.sleep(2000);
                } else {
                    num = 200;
                    System.out.println("b set over!");
                }
                System.out.println(username + " num=" + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadA extends Thread {
        private HasSelfPrivateNum numRef;

        public ThreadA(HasSelfPrivateNum numRef) {
            super();
            this.numRef = numRef;
        }

        @Override
        public void run() {
            super.run();
            numRef.addI("a");
        }
    }

    public static class ThreadB extends Thread {
        private HasSelfPrivateNum numRef;

        public ThreadB(HasSelfPrivateNum numRef) {
            this.numRef = numRef;
        }

        @Override
        public void run() {
            super.run();
            numRef.addI("b");
        }
    }


}
