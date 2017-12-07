package com.nothing.netty.test.client;

import com.tyning.nothing.netty.http.client.TimeClient;
import org.junit.Test;

/**
 * time client test
 * 
 * @author:tyning
 * 
 * @createDate:2017/11/21
 *
 */
public class TimeClientTest {
    @Test
    public void test(){
        String host = "10.10.1.238";
        int port = Integer.parseInt("8081");
        TimeClient client = new TimeClient();
        client.sendMessage(host,port);
    }
}