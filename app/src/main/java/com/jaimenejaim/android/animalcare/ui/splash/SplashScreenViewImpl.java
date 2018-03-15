package com.jaimenejaim.android.animalcare.ui.splash;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface SplashScreenViewImpl extends ViewImpl {

    void nofityDataCharged(String msg);
    void startRunnableBlinkOfEyes();
    void startRunnableLoadingDots();
    void removeCallbacksFromLoading();
    void removeCallbacksFromImageView();
    void verifySession();
}
