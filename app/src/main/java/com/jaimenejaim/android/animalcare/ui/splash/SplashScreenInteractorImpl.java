package com.jaimenejaim.android.animalcare.ui.splash;


import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.AppDatabase;
import com.jaimenejaim.android.animalcare.data.pref.Session;
import com.jaimenejaim.android.animalcare.ui.home.HomeActivity;
import com.jaimenejaim.android.animalcare.ui.login.LogInActivity;

/**
 * Created by Jaime Nascimento Nejaim on 3/15/2018.
 */

public class SplashScreenInteractorImpl implements SplashScreenPresenter, SplashScreenInteractor {

    private Activity activity;
    private Runnable runnableImageViewLogo;
    private Handler handlerTextViewLoading;
    private Runnable runnableTextView;


    public SplashScreenInteractorImpl(Activity activity){
        this.activity = activity;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                verifySession();
            }
        }, 2000);
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
                        nofityDataCharged(activity.getString(R.string.splash_screen_text_view_loading).concat(".    "));
                        break;
                    case 1:
                        nofityDataCharged(activity.getString(R.string.splash_screen_text_view_loading).concat("..   "));
                        break;
                    case 2:
                        nofityDataCharged(activity.getString(R.string.splash_screen_text_view_loading).concat("...  "));
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

    }

    @Override
    public void removeCallbacksFromImageView() {

    }

    @Override
    public void verifySession() {
        if(Session.get(activity) == null)
            openActivity(new LogInActivity());
        else
            openActivity(new HomeActivity());
    }

}
