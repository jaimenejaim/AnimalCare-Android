package com.jaimenejaim.android.animalcare.ui.splash;

import android.content.Intent;
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

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenViewImpl {


    private TextView textViewLoading;
    private Handler handlerTextViewLoading;
    private Runnable runnableTextView;


    private ImageView imageViewLogo;
    private Runnable runnableImageViewLogo;


    private SplashScreenPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        initComponents(findViewById(android.R.id.content));

        intiPresenter();
        setListeners();

        startRunnableLoadingDots();
        startRunnableBlinkOfEyes();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                verifySession();
            }
        }, 2000);

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
        this.presenter = new SplashScreenPresenter();
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
    public void startRunnableBlinkOfEyes() {
        runnableImageViewLogo = new Runnable() {

            int i = 0;
            boolean interval = false;
            int count = 0;
            int delay = 250;

            @Override
            public void run() {
                if(!interval){
                    if(i++ % 2 == 0) {
                        imageViewLogo.setImageResource(R.drawable.logo);
                        if(count < 3){
                            count++;
                            if(count == 3){
                                interval = true;
                            }
                        }
                    }else {
                        imageViewLogo.setImageResource(R.drawable.logo_closed_eye);
                    }

                    delay = 250;

                }else{
                    count = 0;
                    delay = 2000;
                    interval = false;
                }
                imageViewLogo.postDelayed(this, delay);
            }
        };

        imageViewLogo.postDelayed(runnableImageViewLogo, 1000);
    }

    @Override
    public void startRunnableLoadingDots() {
        handlerTextViewLoading = new Handler(Looper.getMainLooper());
        runnableTextView = new Runnable() {
            int index = 0;
            @Override
            public void run() {
                switch(index % 5) {
                    case 0:
                        nofityDataCharged(getString(R.string.splash_screen_text_view_loading).concat(".    "));
                        break;
                    case 1:
                        nofityDataCharged(getString(R.string.splash_screen_text_view_loading).concat("..   "));
                        break;
                    case 2:
                        nofityDataCharged(getString(R.string.splash_screen_text_view_loading).concat("...  "));
                        break;
                }
                index++;

                handlerTextViewLoading.postDelayed(this, 1000);
            }
        };
        handlerTextViewLoading.post(runnableTextView);
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
    public void verifySession() {
        if(Session.get(this) == null)
            openActivity(new LogInActivity());
        else
            openActivity(new HomeActivity());
    }

    private void openActivity(Object activity) {
        Intent intent = new Intent(SplashScreenActivity.this, activity.getClass());
        startActivity(intent);
        finish();
    }


}
