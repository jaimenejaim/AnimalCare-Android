package com.jaimenejaim.android.animalcare.ui.splash;


import android.content.Context;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface SplashScreenPresenter {
    void onDestroy();
    void startRunnableBlinkOfEyes();
    void startRunnableLoadingDots();
    void removeCallbacksFromLoading(Runnable runnable);
    void removeCallbacksFromImageView(Runnable runnable);
    void verifySession();
    void openActivity(Object activity);
    void setImageResource(int resource);
    void postDelayed(Runnable runnable, int delay);
    void nofityDataCharged(String msg);
    Context getContext();
}
