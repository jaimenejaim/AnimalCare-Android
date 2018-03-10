package com.jaimenejaim.android.animalcare.ui.login;

import android.content.Context;
import android.content.Intent;

import com.jaimenejaim.android.animalcare.ui.home.HomeActivity;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class LogInPresenter implements LogInPresenterImpl {

    Context mContext;

    public LogInPresenter(Context mContext){
        this.mContext = mContext;
    }

    public void logIn(String email, String password){
        Intent intent = new Intent(mContext, HomeActivity.class);
        mContext.startActivity(intent);
    }

}
