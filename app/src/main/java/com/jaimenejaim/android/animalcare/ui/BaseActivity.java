package com.jaimenejaim.android.animalcare.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.jaimenejaim.android.animalcare.utils.ActivityUtil;

/**
 * Created by Jaime Nascimento Nejaim on 3/14/2018.
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    @Override
    public void finish() {
        super.finish();
        ActivityUtil.overridePendingTransitionExit(this);
    }

    public void finish(String arg) {
        super.finish();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        ActivityUtil.overridePendingTransitionEnter(this);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        ActivityUtil.overridePendingTransitionEnter(this);
    }


}