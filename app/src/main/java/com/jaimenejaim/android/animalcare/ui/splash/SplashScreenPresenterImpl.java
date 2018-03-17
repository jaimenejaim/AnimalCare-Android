package com.jaimenejaim.android.animalcare.ui.splash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.pref.Session;
import com.jaimenejaim.android.animalcare.ui.home.HomeActivity;
import com.jaimenejaim.android.animalcare.ui.login.LogInActivity;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private SplashScreenView view;
    private Runnable runnableImageViewLogo;
    private Handler handlerTextViewLoading;
    private Runnable runnableTextView;


    public SplashScreenPresenterImpl(SplashScreenView view){
        this.view = view;

        startRunnableBlinkOfEyes();
        startRunnableLoadingDots();

        new Handler().postDelayed(() ->
                verifySession(), 2000);
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
                        setImageResource(R.drawable.logo);
                        if(count < 3){
                            count++;
                            if(count == 3){
                                interval = true;
                            }
                        }
                    }else {
                        setImageResource(R.drawable.logo_closed_eye);
                    }

                    delay = 250;

                }else{
                    count = 0;
                    delay = 2000;
                    interval = false;
                }
                postDelayed(this, delay);
            }
        };

        postDelayed(runnableImageViewLogo, 1000);

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
                        nofityDataCharged(getContext().getString(R.string.splash_screen_text_view_loading).concat(".    "));
                        break;
                    case 1:
                        nofityDataCharged(getContext().getString(R.string.splash_screen_text_view_loading).concat("..   "));
                        break;
                    case 2:
                        nofityDataCharged(getContext().getString(R.string.splash_screen_text_view_loading).concat("...  "));
                        break;
                }
                index++;

                handlerTextViewLoading.postDelayed(this, 1000);
            }
        };
        handlerTextViewLoading.post(runnableTextView);
    }

    @Override
    public void removeCallbacksFromLoading(Runnable runnable) {
        view.getTextViewLoading().removeCallbacks(runnable);
    }

    @Override
    public void removeCallbacksFromImageView(Runnable runnable) {
        view.getImageViewLoading().removeCallbacks(runnable);
    }


    @Override
    public void verifySession() {
        if(Session.get(getContext()) == null)
            openActivity(new LogInActivity());
        else
            openActivity(new HomeActivity());
    }

    @Override
    public void openActivity(Object activity) {
        view.openActivity(activity);
    }



    @Override
    public void nofityDataCharged(String msg) {
        view.nofityDataCharged(msg);
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }

    @Override
    public void setImageResource(int resource) {
        view.setImageResource(resource);
    }

    @Override
    public void postDelayed(Runnable runnable, int delay) {
        view.getImageViewLoading().postDelayed(runnable,delay);
    }

    @Override
    public void onDestroy() {
        removeCallbacksFromImageView(runnableImageViewLogo);
        removeCallbacksFromLoading(runnableTextView);
    }

}
