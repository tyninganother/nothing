package com.tyning.nothing.itext;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.tyning.nothing.itext.bean.PdfCoordinate;

import java.util.ArrayList;
import java.util.List;


public class MyTextRenderListener implements RenderListener {

    List<PdfCoordinate> textInPdfCoordinates = new ArrayList<>();
    private int pageNum;
    private String keyWord;

    MyTextRenderListener(int pageNum, String keyWord) {
        this.pageNum = pageNum;
        this.keyWord = keyWord;
    }

    public List<PdfCoordinate> getTextInPdfCoordinates() {
        return textInPdfCoordinates;
    }

    @Override
    public void renderText(TextRenderInfo textRenderInfo) {
        String text = textRenderInfo.getText();
        if (null != text && text.contains(keyWord)) {
            Rectangle2D.Float boundingRectange = textRenderInfo.getBaseline().getBoundingRectange();
            textInPdfCoordinates.add(new PdfCoordinate(pageNum,boundingRectange.x, boundingRectange.y));
        }
    }

    @Override
    public void renderImage(ImageRenderInfo arg0) {}

    @Override
    public void endTextBlock() {}

    @Override
    public void beginTextBlock() {}
}
