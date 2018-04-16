package com.jweihao.jdemo.java.book.Thread.zhang2;

import java.util.ArrayList;
import java.util.List;

/*
 * 创建者 韦豪
 * 创建时间 2018/4/15 0015 9:46
 */
public class class227_3 {

    public static void main(String[] args) {
        MyList myList = new MyList();
        MyThreadA a = new MyThreadA(myList);
        a.setName("A");
        a.start();
        MyThreadB b = new MyThreadB(myList);
        b.setName("B");
        b.start();
    }

    public static class MyList {
        private List mList = new ArrayList<>();

        synchronized public void add(String username) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "执行了add方法！");
            mList.add(username);
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "退出了add方法！");
        }

        synchronized public int getSize() {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "执行了getSize方法！");
            int sizeValue = mList.size();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "退出了getSize方法");
            return sizeValue;
        }
    }

    public static class MyThreadA extends Thread {
        private MyList mList;

        public MyThreadA(MyList list) {

            mList = list;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 1000; i++) {
                mList.add("threadA" + (i + 1));
            }
        }
    }

    public static class MyThreadB extends Thread {
        private MyList mList;

        public MyThreadB(MyList list) {

            mList = list;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 1000; i++) {
                mList.add("threadB" + (i + 1));
            }
        }
    }

}
