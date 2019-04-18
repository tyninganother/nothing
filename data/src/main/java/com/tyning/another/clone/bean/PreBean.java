package com.tyning.another.clone.bean;

public class PreBean implements Cloneable {
    private int a = 0;
    private Integer b = 0;
    private PrePropertyBean prePropertyBean;

    public PreBean(int a, Integer b, PrePropertyBean prePropertyBean) {
        this.a = a;
        this.b = b;
        this.prePropertyBean = prePropertyBean;
    }

    @Override
    public PreBean clone() throws CloneNotSupportedException {
        return (PreBean) super.clone();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public PrePropertyBean getPrePropertyBean() {
        return prePropertyBean;
    }

    public void setPrePropertyBean(PrePropertyBean prePropertyBean) {
        this.prePropertyBean = prePropertyBean;
    }
}
