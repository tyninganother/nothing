package com.tyning.nothing.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.tyning.nothing.itext.bean.PdfCoordinate;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * itext demo
 *
 * @author:tyning
 * @createDate:2017/12/7
 */
public class ItextComponent {

    /**
     * html to pdf
     *
     * @param html
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static byte[] coverHtmlStrToPdfFileIoBytes(String html) throws IOException, DocumentException {
        if (StringUtils.isBlank(html)) {
            return null;
        }
        byte[] pdfbytes = null;
        ByteArrayInputStream htmlSteam = null;
        ByteArrayOutputStream outputStream = null;
        try {
            htmlSteam = new ByteArrayInputStream(html.getBytes());
            outputStream = new ByteArrayOutputStream();
            Document document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
            document.open();
            PdfPageEventHelper pdfPageEventHelper = new PdfPageEventHelper();
            pdfPageEventHelper.onEndPage(pdfWriter, document);
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            worker.parseXHtml(pdfWriter, document, htmlSteam, null, new AsianFontProvider());
            document.close();
            pdfbytes = outputStream.toByteArray();
        } catch (Exception e) {
            throw e;
        } finally {
            if (htmlSteam != null) {
                htmlSteam.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        return pdfbytes;
    }

    public static class AsianFontProvider extends XMLWorkerFontProvider {
        @Override
        public Font getFont(final String fontname, final String encoding,
                            final boolean embedded, final float size, final int style,
                            final BaseColor color) {
            BaseFont bf = null;
            try {
                bf = BaseFont.createFont("ttf/Microsoft YaHei.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Font font = new Font(bf, size, style, color);
            font.setColor(color);
            return font;
        }
    }

    /**
     * 将数据，填入pdf表单域
     */
    public static OutputStream generate(PdfReader template, Map data)
            throws Exception {

        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);


        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfStamper stamp = new PdfStamper(template, out);
            AcroFields form = stamp.getAcroFields();


            // set the field values in the pdf form
            for (Iterator it = data.keySet().iterator(); it.hasNext(); ) {
                String key = (String) it.next();
                String value = (String) data.get(key);
                form.setFieldProperty(key, "textfont", bfChinese, null);
                form.setField(key, value);

            }

            stamp.setFormFlattening(true);
            stamp.close();
            template.close();

            return out;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }

    }


    /**
     * 获取pdf中关键字的坐标
     *
     * @param filePath
     * @param keyWord
     * @return
     */
    public static List<PdfCoordinate> getKeyWords(String filePath, String keyWord) {
        List<PdfCoordinate> textInPdfCoordinates = new ArrayList();
        try {
            PdfReader pdfReader = new PdfReader(filePath);
            int pageNum = pdfReader.getNumberOfPages();
            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(pdfReader);
            if (pageNum > 0) {
                // 下标从1开始
                for (int i = 1; i <= pageNum; i++) {
                    MyTextRenderListener myTextRenderListener = new MyTextRenderListener(i, keyWord);
                    myTextRenderListener = pdfReaderContentParser.processContent(i, myTextRenderListener);
                    if (myTextRenderListener.getTextInPdfCoordinates() != null && myTextRenderListener.getTextInPdfCoordinates().size() > 0) {
                        textInPdfCoordinates.addAll(myTextRenderListener.getTextInPdfCoordinates());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("在pdf文件[filePath:" + filePath + "]获取关键字[keyWord:" + keyWord + "]失败.");
        }
        return (textInPdfCoordinates == null || textInPdfCoordinates.size() < 1) ? null : textInPdfCoordinates;
    }

}
