package com.jaimenejaim.android.animalcare.ui.splash;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private SplashScreenView view;
    private SplashScreenInteractor interactor;

    public SplashScreenPresenterImpl(SplashScreenView view, SplashScreenInteractor interactor){
        this.view = view;
        this.interactor = interactor;
    }
}
