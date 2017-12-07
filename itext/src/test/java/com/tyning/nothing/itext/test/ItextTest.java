package com.tyning.nothing.itext.test;

import com.itextpdf.text.DocumentException;
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
//        ItextAddFieldUtil.manipulatePdfPushbuttonField(ItextComponent.coverHtmlStrToPdfFileIoBytes(html), DEST);
        ItextAddFieldUtil.manipulatePdfText(ItextComponent.coverHtmlStrToPdfFileIoBytes(html), DEST);
    }
}
