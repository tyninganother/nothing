package com.nothing.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author haining
 */
public class ITread4 implements Callable<String> {

    public static void main(String[] args) throws Exception {
        ITread4 tread2 = new ITread4();
        FutureTask<String> futureTask = new FutureTask<>(tread2);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        futureTask.run();
        futureTask.isDone();
    }

    @Override
    public String call() throws Exception {
        System.out.println("shisiisiijjj");
        return "fdsafdsa";
    }
}
