package com.jaimenejaim.android.animalcare.ui.splash;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.pref.Session;
import com.jaimenejaim.android.animalcare.ui.home.HomeActivity;
import com.jaimenejaim.android.animalcare.ui.login.LogInActivity;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenView {


    private TextView textViewLoading;
    private ImageView imageViewLogo;




    private SplashScreenPresenterImpl presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        presenter = new SplashScreenPresenterImpl(this, new SplashScreenInteractorImpl(this));
    }



    @Override
    protected void onDestroy() {

        removeCallbacksFromLoading();
        removeCallbacksFromImageView();

        super.onDestroy();
    }

    @Override
    public void nofityDataCharged(String msg) {
        textViewLoading.setText(msg);
    }

    @Override
    public void setBackgroundImageViewLogo(int drawable) {
        imageViewLogo.setBackgroundResource(drawable);
    }



    @Override
    public void removeCallbacksFromLoading() {
        textViewLoading.removeCallbacks(runnableTextView);
    }

    @Override
    public void removeCallbacksFromImageView() {
        imageViewLogo.removeCallbacks(runnableImageViewLogo);
    }



    @Override
    public void openActivity(Object activity) {
        Intent intent = new Intent(SplashScreenActivity.this, activity.getClass());
        startActivity(intent);
        finish();
    }


}
