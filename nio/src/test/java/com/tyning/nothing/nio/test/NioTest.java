package com.tyning.nothing.nio.test;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    @Test
    public void test() throws IOException {




    }

    private void readFile() throws IOException {
        FileInputStream fin = new FileInputStream("readandshow.txt");
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
    }

    private void writeFile(byte[] message) throws IOException {
        FileOutputStream fout = new FileOutputStream("writesomebytes.txt");
        FileChannel fc = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < message.length; ++i) {
            buffer.put(message[i]);
        }
        buffer.flip();
        fc.write(buffer);
    }
}
