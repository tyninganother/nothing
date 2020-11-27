package com.tyning.another.proxy;

public class MyOpera implements Operr{
    @Override
    public String saySomeThing(String someThing) {
        System.out.println(someThing);
        return someThing;
    }
}
