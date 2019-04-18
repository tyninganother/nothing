package com.tyning.nothing.designmode.abstractfactory;

public class SendSmsFactory implements Provider {
    public Sender produce() {
        return new SmsSender();
    }
}

