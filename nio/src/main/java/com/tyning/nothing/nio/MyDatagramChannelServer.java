package com.tyning.nothing.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class MyDatagramChannelServer {

    public void init() throws IOException {
        System.out.println("start.............");
        int port = 9975;
        Selector selector;
        DatagramChannel datagramChannel;
        ByteBuffer byteBuffer = ByteBuffer.allocate(65507);
        selector = Selector.open();
        datagramChannel = DatagramChannel.open();
        //非阻塞
        datagramChannel.configureBlocking(false);
        SocketAddress socketAddress = new InetSocketAddress("localhost", port);
        datagramChannel.bind(socketAddress);
//        datagramChannel.socket().bind(new InetSocketAddress(port));
        //注册事件
//        datagramChannel.register(selector, SelectionKey.OP_ACCEPT);
        datagramChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("start.............");
        selector.select();
        SocketAddress address = datagramChannel.receive(byteBuffer); // read into buffer.
        String clientAddress = address.toString().replace("/", "").split(":")[0];
        String clientPost = address.toString().replace("/", "").split(":")[1];
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "\t" + address.toString());
        byteBuffer.flip(); // make buffer ready for read
        String content = "";
        while (byteBuffer.hasRemaining()) {
            byteBuffer.get(new byte[byteBuffer.limit()]);// read 1 byte at a time
            byte[] tmp = byteBuffer.array();
            content += new String(tmp);
        }
        byteBuffer.clear(); // make buffer ready for writing次
        System.out.println(threadName + "接收：" + content.trim());
        System.out.println("start.............");
    }

    public static void main(String[] args) throws IOException {
        MyDatagramChannelServer server = new MyDatagramChannelServer();
        server.init();
    }
}
