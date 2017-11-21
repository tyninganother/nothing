package com.tyning.nothing.netty.http.client;


import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * 
 * 
 * @author:tyning
 * 
 * @createDate:
 *
 */
public class HttpClient {

    //首先我先做的事情是协议个客户端
    //那么这个客户端需要完成什么任务呢?
    //要建立一个连接,然后传输协议
    //那么这两部分我是放在一个方法来时两个方法里呢?
    //这个吧都是可以的

    public void sendMessage(){
        EventLoopGroup workerGroup = new NioEventLoopGroup();
    }

}
