package com.jaimenejaim.android.animalcare.ui.splash;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by Jaime Nascimento Nejaim on 3/15/2018.
 */

public interface SplashScreenView extends ViewImpl {
    void nofityDataCharged(String msg);
    void openActivity(Object activity);
    void setImageResource(int resource);

}
