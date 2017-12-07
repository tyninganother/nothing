package com.tyning.nothing.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * IO util
 *
 * @author:tyning
 * @createDate:2017/12/7
 */
public class IoUtils {

    final static int READ_BUFFER_SIZE_INT = 100;

    /**
     * Stream conver ：InputStream To bytes
     *
     * @param stream
     * @return
     * @throws Exception
     */
    public static byte[] converToBytes(InputStream stream) throws Exception {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        try {
            while ((rc = stream.read(buff, 0, READ_BUFFER_SIZE_INT)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            return swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return null;
    }
}
