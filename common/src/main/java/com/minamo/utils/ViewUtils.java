package com.minamo.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * @author Minamo
 * @e-mail kleinminamo@gmail.com
 * @time 2019/12/12
 * @des
 */
public class ViewUtils {


    /**
     * 避免OOM兜底方案
     * 在Activity onDestory的时候，遍历View树，清空backGround、Drawable、EditText的TextWatcher等
     * @param root
     */
    public static void cleanViewMemory(ViewGroup root) {
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            final View child = root.getChildAt(i);
            if (child instanceof ViewGroup) {
                child.setBackground(null);
                cleanViewMemory((ViewGroup) child);
            } else {
                if (child != null) {
                    child.setBackground(null);
                }
                if (child instanceof ImageView) {
                    ((ImageView) child).setImageDrawable(null);
                }
//                else if (child instanceof EditText) {
//                    ((EditText) child).cleanWatchers();
//                }
            }
        }
    }
}
