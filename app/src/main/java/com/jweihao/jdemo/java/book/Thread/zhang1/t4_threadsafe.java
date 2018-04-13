package com.jweihao.jdemo.java.book.Thread.zhang1;

import android.util.Log;

/**
 * Created by weihao on 2018/4/11.
 */
public class t4_threadsafe {

    public static void main(String[] args) {

        ///////////////  1.2.3 实例变量与线程安全 实现非线程安全的环境，通过synchronized关键字  ////////////////////////

        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }

    public static class LoginServlet {
        private static String usernameRef;
        private static String passwordRef;

       synchronized public static void doPost(String username, String password) {
            usernameRef = username;
            if (username.equals("a")) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            passwordRef = password;
            System.out.println("username=" + usernameRef + "  password=" + passwordRef);

        }
    }

    public static class ALogin extends Thread {
        @Override
        public void run() {
            LoginServlet.doPost("a", "aa");
        }
    }

    public static class BLogin extends Thread {
        @Override
        public void run() {
            LoginServlet.doPost("b", "bb");
        }
    }


}

