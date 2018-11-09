package com.tyning.nothing.html2image;

import com.tyning.nothing.html2image.image.generator.HtmlImageGenerator;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Mainjava {

    public static void main(String[] args) throws IOException {
        htmlToPic(args[0]);
//        htmlToPic("/Users/haining/");
    }
    /**
     * html内容变为图片
     *
     * @param targetFilePath
     * @throws IOException
     */
    public static String htmlToPic(String targetFilePath) throws IOException {
        String htmlContent = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n";
        htmlContent = htmlContent.concat("<html><head></head><body>测试文字</body></html>");
        String fileType = ".png";
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        imageGenerator.loadHtml(htmlContent);
        byte[] bytes = null;
        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(imageGenerator.getBufferedImage(), fileType, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
        String filePath = String.valueOf(System.currentTimeMillis()) + fileType;
        imageGenerator.saveAsImage(targetFilePath + filePath);
        return filePath;
    }
}
