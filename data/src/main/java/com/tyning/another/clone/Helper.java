package com.tyning.another.clone;

import com.tyning.another.clone.bean.PreBean;
import com.tyning.another.clone.bean.PrePropertyBean;

public class Helper {

    public static void main(String[] args) throws CloneNotSupportedException {
        PrePropertyBean prePropertyBean = new PrePropertyBean(1,2,"ppoewiewi");
        PreBean preBean = new PreBean(3,4,prePropertyBean);
        PreBean afterBean = preBean.clone();
        //复制得到的对象获取的是
        afterBean.getPrePropertyBean().setA(99);
        afterBean.setB(22);
//        System.out.println(preBean.getPrePropertyBean().getA());
        System.out.println(preBean.getB());
    }
}
