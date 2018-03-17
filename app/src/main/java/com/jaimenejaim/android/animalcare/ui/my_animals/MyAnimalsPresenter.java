package com.jaimenejaim.android.animalcare.ui.my_animals;

import android.content.Context;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class MyAnimalsPresenter implements MyAnimalsPresenterImpl {

    public MyAnimalsViewImpl view;

    public MyAnimalsPresenter(MyAnimalsViewImpl view){
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
