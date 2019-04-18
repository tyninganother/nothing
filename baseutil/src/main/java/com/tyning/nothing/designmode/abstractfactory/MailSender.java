package com.tyning.nothing.designmode.abstractfactory;

/**
 * @author haining
 */
public class MailSender implements Sender {
    public void send() {
        System.out.println("this is mailsender!");
    }
}
