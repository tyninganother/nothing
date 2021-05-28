package com.tyning.nothing.nio;

import com.tyning.nothing.nio.beans.TestXbean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        TestXbean testXbean = (TestXbean)applicationContext.getBean("testx");
        System.out.println(testXbean.toString());
    }
}
