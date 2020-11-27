package com.nothing.thread;

/**
 * @author haining
 */
public class ITread2 extends Thread {

    public static void main(String[] args) {
        ITread2 tread2 = new ITread2();
        tread2.run();
        tread2.start();
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
