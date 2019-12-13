package com.minamo.commonapp;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.minamo.utils.LoggerUtils;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoggerUtils.d("onCreate");
    }
}
