package com.tyning.nothing.itext.test;

import com.itextpdf.text.DocumentException;
import com.tyning.nothing.io.IoUtils;
import com.tyning.nothing.io.text.CompareTextFile;
import com.tyning.nothing.io.text.RemoveHtmlCode;
import com.tyning.nothing.itext.ItextAddFieldUtil;
import com.tyning.nothing.itext.ItextComponent;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ItextTest {
    public static final String DEST = "/test/field_added.pdf";

    @Test
    public void itextTest() throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html>\n" +
                "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta http-equiv=\"X-UA-COMPATIBLE\" content=\"IE=edge,chrome=1\"/>\n" +
                "    <title>test</title>\n" +
                "    <meta name=\"description\" content=\"\"/>\n" +
                "    <meta name=\"keywords\" content=\"\"/>\n" +
                "    <style type='text/css'>\n" +
                "        body {\n" +
                "            font-family: \"Microsoft YaHei\", Helvetica, Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            outline: 0;\n" +
                "        }\n" +
                "        .text-center{\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .right{\n" +
                "            float: right;\n" +
                "        }\n" +
                "        .text-indent{\n" +
                "            text-indent: 2em;\n" +
                "            line-height: 1.4em\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<br/>\n" +
                "<br/>\n" +
                "<br/>\n" +
                "<br/>\n" +
                "<br/>\n" +
                "</body>\n" +
                "</html>";
        ItextAddFieldUtil.manipulatePdfText(ItextComponent.coverHtmlStrToPdfFileIoBytes(html), DEST);
    }

    @Test
    public void compareTest() throws IOException, DocumentException {
        CompareTextFile.compare();
    }

    @Test
    public void readTextFromPdfTest() throws Exception {
        String pdfPath = "src/main/resources/pdf/";
        String pdfTxtPath = "src/main/resources/pdf/txt/";
        File[] pdfList = new File(pdfPath).listFiles();
        for (File file : pdfList) {
            if (file.isFile() && file.getAbsolutePath().endsWith("pdf")) {
                System.out.println("*********************************************************");
                IoUtils.writeStringToFile(ItextComponent.getTextFromPdf(file.getAbsolutePath()),pdfTxtPath+file.getName()+".txt");
                System.out.println("*********************************************************");
            }
        }
        String vmPath = "src/main/resources/vm/";
        String vmTxtPath = "src/main/resources/vm/txt/";
        File[] vmList = new File(vmPath).listFiles();
        for (File file : vmList) {
            if (file.isFile() && file.getAbsolutePath().endsWith("vm")) {
                System.out.println("*********************************************************");
                IoUtils.writeStringToFile(RemoveHtmlCode.removeHtml(IoUtils.getTxtToString(file)),vmTxtPath+file.getName()+".txt");
                System.out.println("*********************************************************");
            }
        }

    }

    public void write(String desc) throws Exception {
        String filetxtcontent = ItextComponent.getTextFromPdf("");
        IoUtils.writeStringToFile(filetxtcontent,desc);
    }
}
