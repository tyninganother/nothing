package com.tyning.nothing.netty.http.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;

/**
 * echoServer
 *
 * @author:tyning
 * @createDate:2017/11/28
 */
public class EchoServer {
    public void start(){
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        serverBootstrap.group(eventLoopGroup);
        serverBootstrap.channel(NioSctpServerChannel.class);
    }
    
}
