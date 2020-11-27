package com.nothing.thread;

/**
 * @author haining
 */
public class ITread3 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        ITread3 tread2 = new ITread3();
        new Thread(tread2){
            @Override
            public void run() {
                System.out.println("sss");
            }
        }.start();
        Thread.sleep(100000L);
    }

    @Override
    public void run() {
        System.out.println("run...");
    }
}
