package com.utils;
/**
 * 图片处理工具类
 * @author qi
 */

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;

public class Image_Util {

    /**
     * 传入一张图片，将其裁切为圆形。
     * @param img
     * @return Image 圆形图片
     */
    public static Image crop(Image img) {
        double d = Math.min(img.getWidth(),img.getHeight());
        double x = (d-img.getWidth())/2;
        double y = (d-img.getHeight())/2;
        Canvas canvas = new Canvas(d, d);
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.fillOval(0, 0, d, d);
        g.setGlobalBlendMode(BlendMode.SRC_ATOP);
        /*
        SRC_OVER,
    SRC_ATOP,
    ADD,
    MULTIPLY,
    SCREEN,
    OVERLAY,
    DARKEN,
    LIGHTEN,
    COLOR_DODGE,
    COLOR_BURN,
    HARD_LIGHT,
    SOFT_LIGHT,
    DIFFERENCE,
    EXCLUSION,
    RED,
    GREEN,
    BLUE;
         */
        g.drawImage(img, x, y);
        return canvas.snapshot(null, null);
    }
}
