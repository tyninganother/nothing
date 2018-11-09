package com.tyning.nothing.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class MyFileChannelDemo {
    public void init() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        SocketChannel service = null;
        Selector serviceSelector = null;
        service.register(serviceSelector, 1);
        SocketChannel client = null;
    }

}
