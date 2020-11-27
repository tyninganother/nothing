package com.tyning.nothing.thread;

import com.sun.deploy.util.DeploySysAction;

import java.security.Security;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {
//    public static void main(String[] args) {
//        class Test {
//            public String aaa() {
//                System.out.println("zaaaa");
//                return null;
//            }
//        }
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                new Test(){
//                    @Override
//                    public String aaa() {
//                        System.out.println("aaaa");
//                        return null;
//                    }
//                }.aaa();
//                System.out.println("fdsafdasfds");
//            }
//        };
//        thread.start();
//        // 匿名类实现了接口并且可以调用，匿名类中的方法
//        Runnable a = new Runnable(){
//            @Override
//            public void run() {
//                System.out.println("runnable");
//            }
//        };
//        new Thread(a).start();
//        Callable callable = null;
//        try {
//            callable = new Callable() {
//
//                @Override
//                public Object call() throws Exception {
//                    System.out.println("calable call");
//                    return 1;
//                }
//            };
////            System.out.println(callable.call());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        Future = executorService.submit(callable);
//
//    }

    static int age1 = 1;

    static{
        System.out.println("这是静态代码块" + age1);
        age1 = 10;
        System.out.println("这是静态代码块" + + age1);
    }

    {
        System.out.println("这是普通代码块"+age1);
    }

    public ThreadTest(){
        System.out.println("这是构造方法");
    }

    public void fun(){
        System.out.println("这是普通方法fun");
    }

    public static void show(){
        System.out.println("这是静态方法"+age1);
    }

    public static void main(String[] args) {
        System.out.println(ThreadTest.class);
//        System.err.println("==============");
//
//        ThreadTest.show();
//
//        ThreadTest t=new ThreadTest();
//        ThreadTest t1=new ThreadTest();
//        t.fun();
//        t.fun();
    }
}
