package com.tyning.nothing.io.text.test;

import com.tyning.nothing.io.IoUtils;
import com.tyning.nothing.io.text.RemoveHtmlCode;
import org.junit.Test;

public class IOUtilTest {

    @Test
    public void ioUtilsTest() throws Exception {
        String DEST = "/test/field_added.txt";
        String htmlStr = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html>\n" +
                "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta http-equiv=\"X-UA-COMPATIBLE\" content=\"IE=edge,chrome=1\"/>\n" +
                "    <title>范德萨范德萨</title>\n" +
                "    <meta name=\"description\" content=\"\"/>\n" +
                "    <meta name=\"keywords\" content=\"\"/>\n" +
                "    <style type='text/css'>\n" +
                "        body {\n" +
                "            font-family: \"Microsoft YaHei\", Helvetica, Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            outline: 0; }\n" +
                "\n" +
                "        .text-center {\n" +
                "            text-align: center; }\n" +
                "\n" +
                "        .pos-relative {\n" +
                "            position: relative; }\n" +
                "        p, ol, h1, h2, h3 {\n" +
                "            margin: 0; }\n" +
                "\n" +
                "        p, h1, h2, h3 {\n" +
                "            line-height: 3; }\n" +
                "\n" +
                "        h1, h2 {\n" +
                "            text-align: center; }\n" +
                "\n" +
                "        h1 {\n" +
                "            font-size: 2em; }\n" +
                "\n" +
                "        b {\n" +
                "            font-size: 1.1em; }\n" +
                "\n" +
                "        ul {\n" +
                "            list-style-type: none; }\n" +
                "\n" +
                "        table {\n" +
                "            border-collapse: collapse;\n" +
                "            width: 100%;\n" +
                "            border: 1px solid #ccc;\n" +
                "            border-spacing: 0;\n" +
                "            margin: 0 auto; }\n" +
                "\n" +
                "        table tbody tr td, table thead tr th {\n" +
                "            border: 1px solid #ccc;\n" +
                "            padding: 5px;\n" +
                "            text-align: center; }\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"contract\">\n" +
                "    <h1 class=\"text-center\">来来来闪乱神乐</h1>\n" +
                "    <p class=\"text-center\">\n" +
                "    </p>\n" +
                "<p class=\"text-center\">\n" +
                "    范德萨范德萨签署：\n" +
                "</p>\n" +
                "\n" +
                "    <p>\n" +
                "        <b>范德萨范德萨范德萨&nbsp;</b>\n" +
                "    </p>\n" +
                "    <p>\n" +
                "        范德萨范德萨：&nbsp;\n" +
                "    </p>\n" +
                "#if($creditorIdCardCode)\n" +
                "    <p>\n" +
                "        <b> 范德萨范德萨:&nbsp;&nbsp;$!creditorName&nbsp;&nbsp;</b>\n" +
                "    </p>\n" +
                "    <p>范德萨范德萨</p>\n" +
                "#else\n" +
                "    <p>\n" +
                "        <b>范德萨范德萨</b>\n" +
                "    </p>\n" +
                "    <p>范德萨范德萨\n" +
                "\n" +
                "    <p>\n" +
                "        住所：&nbsp;fdsafdasfd的发送范德萨\n" +
                "    </p>\n" +
                "#end\n" +
                "\n" +
                "    <p><b>丙方：&nbsp;fdsafdsafdsafdsafdsafdsa</b></p>\n" +
                "\n" +
                "    <p>fdsafdsafdsafdsafdsafdsafd8</p>\n" +
                "\n" +
                "    <p>fdsafdsafdsa</p>\n" +
                "\n" +
                "    <p>（fdsafdsa”，范德萨范德萨“范德萨范德萨”）</p>\n" +
                "\n" ;
        IoUtils.writeStringToFile(RemoveHtmlCode.removeHtml(htmlStr), DEST);
    }
}
