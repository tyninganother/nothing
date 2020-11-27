package com.nothing.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author haining
 */
public class ITread5 {

    public static void main(String[] args) throws Exception {
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("2").append("1");
        List<Long> a = new ArrayList<>();
        a.add(null);
        Iterator<Long> longIterator = a.iterator();
        while (longIterator.hasNext()){
            Long b = longIterator.next();
            System.out.println(b.longValue());
        }

        System.out.println("ente rpr,is ，eIds".replaceAll(" ", "").replaceAll("，", ","));
    }

    public String call() throws Exception {
        System.out.println("shisiisiijjj");
        return "fdsafdsa";
    }
}
