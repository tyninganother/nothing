package com.nothing.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author haining
 */
public class ITread {
    public static int aaa = 1;
    static {
        System.out.println("fdsafdsafds");
    }

    public void setAtomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        //未加锁的时候
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(null, 1);
        Object object = new Object();
        synchronized (object) {

        }

        //CAS实现 compareAndSwap 比较与更改 汇编指令cmpxchg(非原子性)  lock_if_Mp() : cmpxchg
        //lock指令是说北桥芯片的

    }

    public static void main(String[] args) {

//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("fdsafdasfds");
//                super.run();
//            }
//        };
//        thread.start();
//        StringBuffer;

//        System.out.println(ClassLayout.parseInstance(ITread.class).toPrintable());
//        System.out.println(ClassLayout.parseInstance(ITread.class).toPrintable());
//
//        List<String> a = new ArrayList();
//        a.add("fdafdasfdasfdasfsdq");
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        //一个对象的内存存储结构
        //需要知道每一个基本类型的长度
        //对象头有两个，第二个 classpointer 如果是压缩就是4个字节，不压缩就是8个字节  后边有个data 还有一个对齐
        //锁的信息是在对象头的markword中  用jol对比对对象加锁的布局


        //
        /*
        上锁的过程
        synchronize锁升级的过程  new对象开始>偏向锁>轻量级锁>重量级锁  偏向锁可以关闭
         */

    }



}
