package com.minamo.common;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.minamo.utils.LoggerUtils;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoggerUtils.d("onCreate");
    }
}
