package com.tyning.another.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyProxyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("fdsafdasfdsafdsa");
        method.invoke(proxy, args);
        return null;
    }
}
