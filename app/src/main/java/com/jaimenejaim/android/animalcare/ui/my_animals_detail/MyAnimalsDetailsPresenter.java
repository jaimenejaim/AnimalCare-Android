package com.jaimenejaim.android.animalcare.ui.my_animals_detail;

import android.content.Context;

import com.jaimenejaim.android.animalcare.ui.PresenterImpl;

/**
 * Created by jaimenejaim on 13/03/2018.
 */

public class MyAnimalsDetailsPresenter implements PresenterImpl {

    private MyAnimalsDetailsViewImpl view;

    public MyAnimalsDetailsPresenter(MyAnimalsDetailsViewImpl view){
        this.view = view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
