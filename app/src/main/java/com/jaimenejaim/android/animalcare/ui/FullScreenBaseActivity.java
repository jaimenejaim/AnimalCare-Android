package com.jaimenejaim.android.animalcare.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by Jaime Nascimento Nejaim on 3/14/2018.
 */

@SuppressLint("Registered")
public class FullScreenBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        super.onCreate(savedInstanceState);
    }
}