package com.jaimenejaim.android.animalcare.ui.splash;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class SplashScreenPresenterImpl implements SplashScreenPresenter, SplashScreenInteractor {

    private SplashScreenView view;
    private SplashScreenInteractor interactor;

    public SplashScreenPresenterImpl(SplashScreenView view, SplashScreenInteractor interactor){
        this.view = view;
        this.interactor = interactor;
    }



    @Override
    public void startRunnableBlinkOfEyes(ImageView imageView) {
        interactor.startRunnableBlinkOfEyes(imageView);
    }

    @Override
    public void startRunnableLoadingDots(TextView textView) {
        interactor.startRunnableLoadingDots(textView);
    }

    @Override
    public void removeCallbacksFromLoading(TextView textView, Runnable runnable) {
        interactor.removeCallbacksFromLoading(textView, runnable);
    }

    @Override
    public void removeCallbacksFromImageView(ImageView imageView, Runnable runnable) {
        interactor.removeCallbacksFromImageView(imageView, runnable);
    }


    @Override
    public void verifySession() {
        interactor.verifySession();
    }

    @Override
    public void openActivity(Object activity) {
        view.openActivity(activity);
    }



    @Override
    public void nofityDataCharged(TextView textView, String msg) {
        view.nofityDataCharged(msg);
    }

    @Override
    public void setImageResource(ImageView imageResource, int resource) {
        view.setImageResource(resource);
    }

    @Override
    public void postDelayed(ImageView imageView, Runnable runnable, int delay) {

    }

    @Override
    public void onDestroy() {
//        view.onDestoy();
    }

}
