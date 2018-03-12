package com.jaimenejaim.android.animalcare.ui.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenViewImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initComponents(findViewById(android.R.id.content));
        setListeners();


    }

    @Override
    public void initComponents(View view) {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void onBackPressed() {

    }

}
