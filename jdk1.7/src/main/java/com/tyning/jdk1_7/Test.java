package com.tyning.jdk1_7;

import org.omg.CORBA.Current;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1",2);
        HashMap hashMap = new HashMap<>();
        hashMap.put(1,"1");
        hashMap.put(1,"1");
        hashMap.put(17,"2");
        System.out.println(hashMap);
        Entity<String,Integer> newce = new Entity<>();
        newce.key ="newckey1";
        newce.value = 110;

        Entity<String,Integer> ce = new Entity<>();
        ce.key ="ckey1";
        ce.value = 10;
        Entity<String,Integer> e = new Entity<>();
        e.key ="key1";
        e.value = 1;
        e.next = ce;
        Entity<String,Integer>[] newTable = new Entity[5];
        newTable[2] = newce;


        Entity<String,Integer> next = e.next;
        int i = 2;
        e.next = newTable[i];
        newTable[i] = e;
        e = next;

    }


}