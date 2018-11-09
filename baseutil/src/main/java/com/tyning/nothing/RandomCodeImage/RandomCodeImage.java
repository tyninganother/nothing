package com.tyning.nothing.RandomCodeImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RandomCodeImage {

    public static BufferedImage drawRandomCode(int width, int height, int fontNum) {   //调用时只需要传入三个参数，宽.高，字符数；
        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d = (Graphics2D) bufferedImage.getGraphics();
        Color color = new Color((int) (Math.random() * 35) + 219,
                (int) (Math.random() * 35) + 219, (int) (Math.random() * 35) + 219);
        graphics2d.setBackground(color);
        graphics2d.clearRect(0, 0, width, height);

        //产生随机的颜色分量来构造颜色值，输出的字符的颜色值都将不同；
        Color fColor = new Color((int) (Math.random() * 71) + 55,
                (int) (Math.random() * 71) + 55, (int) (Math.random() * 71) + 55);


        //画边框
        graphics2d.setColor(Color.black);
        graphics2d.drawRect(0, 0, width - 1, height - 1);


        graphics2d.setColor(fColor);

        //设置字体，字体的大小应该根据图片的高度来定
        graphics2d.setFont(new Font("Times new Roman", Font.BOLD, height - 20));


        //randomCode用于保存随机产生的验证码，以便于用户登录后进行验证
        StringBuffer randomCode = new StringBuffer();

        //随机产生的文字输出Y坐标，也跟高度有关系
        int sp = (int) (Math.random() * (height - 23)) + 22;
        for (int i = 0; i < fontNum; i++) {
            //随机产生的4位验证码字符
            char strRand = (char) (Math.random() > 0.50 ? (int) (Math.random() * 9) + 48
                    : (int) (Math.random() * 25) + 97);
            //用随机产生的颜色将验证码绘制到图像中。
            graphics2d.drawString(String.valueOf(strRand), 24 * i + 12
                    , sp + (int) (Math.random() * 5));
            //将4个随机产生的数组合到一起
            randomCode.append(strRand);

        }

        //随机生成几条干扰线条，最少2条，最多5条；
        for (int i = 1; i < (int) (Math.random() * 3) + 3; i++) {
            graphics2d.drawLine(0, sp - (int) (Math.random() * 20), width
                    , sp - (int) (Math.random() * 20));
        }
        return bufferedImage;
    }

}
