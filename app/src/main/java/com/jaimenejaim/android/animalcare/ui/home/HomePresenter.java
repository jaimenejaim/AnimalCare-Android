package com.jaimenejaim.android.animalcare.ui.home;

import android.content.Context;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class HomePresenter implements HomePresenterImpl {

    private HomeViewImpl view;


    public HomePresenter(HomeViewImpl view){
        this.view = view;
    }


    @Override
    public void onDestroy() {

    }

    @Override
    public Context getContext() {
        return view.getContext();
    }
}
