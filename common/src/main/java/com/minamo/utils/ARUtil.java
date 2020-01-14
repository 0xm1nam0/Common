package com.minamo.utils;


public class ARUtil {
    private int screenWidth;
    private int screenHeight;
    private float[] glProjectMatrix;
    private static ARUtil _instance = new ARUtil();

    ARUtil() {
    }

    public static ARUtil Instance() {
        return _instance;
    }

    public void setScreenSize(int width, int height) {
        screenWidth = width;
        screenHeight = height;
    }



    //图片比例与显示比例不一致，需调整投影矩阵
    private static void resizeProjectMatrix(int picW, int picH, int sW, int sH, float[] pro) {
        int screenWidth = sW > sH ? sW : sH;
        int screenHeight = sW > sH ? sH : sW;
        float screenRatio = screenWidth * 1.0f / screenHeight;
        float picRatio = picW * 1.0f / picH;
        float ratio = 1.0f;
        if (screenRatio > picRatio) {
            float tempHeight = picH * screenWidth * 1.0f / picW;
            ratio = tempHeight * 1.0f / screenHeight;
            pro[5] *= ratio;
            pro[9] *= ratio;
        } else if (screenRatio < picRatio) {
            float tempWidth = picW * screenHeight * 1.0f / picH;
            ratio = tempWidth * 1.0f / screenWidth;
            pro[0] *= ratio;
            pro[8] *= ratio;
        }
    }

}
