package com.tyning.nothing.itext.bean;

public class ImagInPdfFileCoordinate extends PdfCoordinate {

    byte[] imagBtyeStream = null;
    public ImagInPdfFileCoordinate(int pageNum, float x, float y, byte[] imagBtyeStream) {
        super(pageNum,x,y);
        this.imagBtyeStream = imagBtyeStream;
    }

    public byte[] getImagBtyeStream() {
        return imagBtyeStream;
    }

    public void setImagBtyeStream(byte[] imagBtyeStream) {
        this.imagBtyeStream = imagBtyeStream;
    }
}
