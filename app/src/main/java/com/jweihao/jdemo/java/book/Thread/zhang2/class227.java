package com.jweihao.jdemo.java.book.Thread.zhang2;

/*
 * 创建者 韦豪
 * 创建时间 2018/4/14 0014 22:51
 */
public class class227 {

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
        private String usernameParam;
        private String passwordParam;
        private String anyString = new String();

        public void setUsernamePassword(String username, String password) {
            try {
                //例子2：代码更改，如下新new String()对象，这里的anyString和上面的anyString不是同一对象。
                //所以不是同一个对象监视器，运行的结果就是异步调用了，就会交叉运行。
                //String anyString = new String();
                synchronized (anyString) {
                    System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");
                    usernameParam = username;
                    Thread.sleep(3000);
                    passwordParam = password;
                    System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
            mService.setUsernamePassword("a", "aa");
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
            mService.setUsernamePassword("b", "bb");
        }
    }
}
