package com.tyning.nothing.itext.bean;

public class PdfCoordinate {
    private int pageNum;
    private float x;
    private float y;

    public PdfCoordinate(int pageNum, float x, float y) {
        this.pageNum = pageNum;
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "x:" + x + "-------y:" + y + "--------pageNum:" + pageNum;
    }
}
