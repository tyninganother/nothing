package com.tyning.nothing.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class MyDatagramChannelClient {
    private int port = 9975;
    Selector selector;
    DatagramChannel datagramChannel;
    ByteBuffer byteBuffer;

    public void init() throws IOException {
        selector = Selector.open();
        datagramChannel = DatagramChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("localhost", port);
        datagramChannel.bind(socketAddress);
//        datagramChannel.socket().bind(new InetSocketAddress(port));
        //注册事件
        datagramChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

}
