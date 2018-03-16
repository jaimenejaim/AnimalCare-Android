package com.jaimenejaim.android.animalcare.ui.splash;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jaime Nascimento Nejaim on 3/15/2018.
 */

public interface SplashScreenInteractor {
    void startRunnableBlinkOfEyes(ImageView imageView);
    void startRunnableLoadingDots(TextView textView);
    void removeCallbacksFromLoading(TextView textView, Runnable runnable);
    void removeCallbacksFromImageView(ImageView imageView, Runnable runnable);
    void verifySession();
    void openActivity(Object activity);
    void setImageResource(ImageView imageView, int resource);
    void postDelayed(ImageView imageView, Runnable runnable, int delay);
    void nofityDataCharged(TextView textView, String msg);
}
