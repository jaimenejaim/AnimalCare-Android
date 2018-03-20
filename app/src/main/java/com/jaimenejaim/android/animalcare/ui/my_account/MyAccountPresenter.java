package com.jaimenejaim.android.animalcare.ui.my_account;

import android.content.Context;

/**
 * Created by jaimenejaim on 19/03/2018.
 */

public class MyAccountPresenter implements MyAccountPresneterImpl {

    private MyAccountViewImpl view;

    public MyAccountPresenter(MyAccountViewImpl view){
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
