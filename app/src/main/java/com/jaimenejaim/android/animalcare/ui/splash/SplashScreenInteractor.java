package com.jaimenejaim.android.animalcare.ui.splash;

/**
 * Created by Jaime Nascimento Nejaim on 3/15/2018.
 */

public interface SplashScreenInteractor {
    void startRunnableBlinkOfEyes();
    void startRunnableLoadingDots();
    void removeCallbacksFromLoading();
    void removeCallbacksFromImageView();
    void verifySession();
}
