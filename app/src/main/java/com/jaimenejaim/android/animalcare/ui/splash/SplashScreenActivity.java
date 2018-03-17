package com.jaimenejaim.android.animalcare.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.FullScreenBaseActivity;

public class SplashScreenActivity extends FullScreenBaseActivity implements SplashScreenView {


    private TextView textViewLoading;
    private ImageView imageViewLogo;

    private SplashScreenPresenterImpl presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initComponents(findViewById(android.R.id.content));

        intiPresenter();
        setListeners();


    }

    @Override
    public void initComponents(View view) {
        imageViewLogo = view.findViewById(R.id.imageViewLogo);
        textViewLoading = view.findViewById(R.id.textViewLoading);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void intiPresenter() {
        presenter = new SplashScreenPresenterImpl(this);
    }



    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void nofityDataCharged(String msg) {
        textViewLoading.setText(msg);
    }


    @Override
    public void openActivity(Object activity) {
        Intent intent = new Intent(SplashScreenActivity.this, activity.getClass());
        startActivity(intent);
        finish();
    }


    @Override
    public void setImageResource(int resource) {
        imageViewLogo.setImageResource(resource);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public TextView getTextViewLoading() {
        return this.textViewLoading;
    }

    @Override
    public ImageView getImageViewLoading() {
        return this.imageViewLogo;
    }




}
