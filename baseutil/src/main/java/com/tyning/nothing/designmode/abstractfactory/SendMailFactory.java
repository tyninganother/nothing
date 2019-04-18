package com.tyning.nothing.designmode.abstractfactory;


public class SendMailFactory implements Provider {

    public Sender produce() {
        return new MailSender();
    }
}

