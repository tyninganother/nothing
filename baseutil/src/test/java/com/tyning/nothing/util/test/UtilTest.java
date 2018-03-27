package com.tyning.nothing.util.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class UtilTest {

    @Test
    public void testSerializable(){
//        String projectIdstr = "2";
//        System.out.println(projectIdstr.replaceAll("1","1"));
        long a= 11321l;
        Long b = 111l;
        System.out.println(b.equals(new Long(a)));
    }



}
