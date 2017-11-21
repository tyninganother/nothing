package com.nothing.netty.test.client;

import com.tyning.nothing.netty.http.client.TimeClient;

/**
 * time client test
 * 
 * @author:tyning
 * 
 * @createDate:2017/11/21
 *
 */
public class Test {
    @org.junit.Test
    public void test(){
        TimeClient client = new TimeClient();
        client.sendMessage();
    }
}
