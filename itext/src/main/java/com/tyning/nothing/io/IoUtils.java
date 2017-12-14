package com.tyning.nothing.io;

import java.io.*;

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

    /**
     * write String ：write String to file
     *
     * @param str
     * @param desc
     * @throws Exception
     */
    public static void writeStringToFile(String str, String desc) throws Exception {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(desc);
            byte[] strBytes = str.getBytes("UTF-8");
            for (int i = 0; i * 1024 < strBytes.length; i++) {
                fileOutputStream.write(strBytes, i, 1024);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }

    }

    /**
     * filepath conver: filepath to bytes
     *
     * @param file
     * @return
     */
    public static byte[] fileToBytes(File file) throws IOException {
        byte[] buffer = null;
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] b = new byte[1000];
            int n;
            while ((n = fileInputStream.read(b)) != -1) {
                byteArrayOutputStream.write(b, 0, n);
            }
            buffer = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw e;
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        }
        return buffer;
    }

    /**
     * get txt from file be txt type
     *
     * @param file
     * @return
     */
    public static String getTxtToString(File file){
        StringBuilder result = new StringBuilder();
        try{
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            //使用readLine方法，一次读一行
            while((s = br.readLine())!=null){
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            throw new RuntimeException("",e);
        }
        return result.toString();
    }

}
