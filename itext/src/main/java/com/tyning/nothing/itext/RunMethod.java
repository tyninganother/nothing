package com.tyning.nothing.itext;

import com.tyning.nothing.io.IoUtils;

import java.io.File;

public class RunMethod {
    public static void main(String[] args){
        String htmlPath = args[0];
        String desc = args[1];
        String html = IoUtils.getTxtToString(new File(htmlPath));
        ItextComponent.createPdfFile(desc,html);
    }
}
