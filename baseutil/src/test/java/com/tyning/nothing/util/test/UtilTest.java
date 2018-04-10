package com.tyning.nothing.util.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilTest {

    @Test
    public void testSerializable(){
//        String projectIdstr = "2";
//        System.out.println(projectIdstr.replaceAll("1","1"));
//        String filePath = "//fdsafdsa//fasfdsa/fdsafdsa";
//        if (filePath.contains("//")){
//            filePath = filePath.replaceAll("//","/");
//        }
//        System.out.println(filePath);
       System.out.println( new BigDecimal("10.1000").setScale(2, RoundingMode.HALF_UP).toString());
    }



}
