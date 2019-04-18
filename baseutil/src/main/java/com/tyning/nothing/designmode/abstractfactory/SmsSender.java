package com.tyning.nothing.designmode.abstractfactory;

public class SmsSender implements Sender {
    public void send() {
        System.out.println("this is sms sender!");
    }

}
