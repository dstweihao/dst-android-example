package com.jweihao.jdemo.java.book.Thread.zhang2;

/**
 * Created by weihao on 2018/4/13.
 */
public class class215 {

    public static void main(String[] args) {

        //共2个例子：出现脏读，不出现脏读。

        try {
            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();
            Thread.sleep(200); //打印结果受此值大小影响
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static class PublicVar {
        public String username = "A";
        public String password = "AA";

        //同步方法setValue()的锁属于类PublicVar的实例
        synchronized public void setValue(String username, String password) {
            try {
                this.username = username;
                Thread.sleep(5000);
                this.password = password;
                System.out.println("setValue method thread name=" + Thread.currentThread().getName() + " username=" + username + " password=" + password);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //ToDo:
        //例子1：不加上synchronized，出现脏读
        //例子2：在方法前加上synchronized关键字，不再出现脏读。
        synchronized public void getValue() {
            System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " username=" + username + " password=" + password);
        }
    }
    public static class ThreadA extends Thread {
        private PublicVar mPublicVar;

        public ThreadA(PublicVar publicVar) {
            super();
            mPublicVar = publicVar;
        }

        @Override
        public void run() {
            super.run();
            mPublicVar.setValue("B", "BB");
        }
    }

}
