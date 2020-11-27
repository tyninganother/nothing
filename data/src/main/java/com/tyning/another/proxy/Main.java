package com.tyning.another.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Operr operra = new MyOpera();
        MyProxyHandler myProxyHandler = new MyProxyHandler();
        Operr operr = (Operr) Proxy.newProxyInstance(myProxyHandler.getClass().getClassLoader(), operra.getClass().getInterfaces(), myProxyHandler);
        operr.saySomeThing("adasdasdas");
    }
}
