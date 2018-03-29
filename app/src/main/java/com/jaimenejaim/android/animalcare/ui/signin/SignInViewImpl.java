package com.jaimenejaim.android.animalcare.ui.signin;

import android.widget.EditText;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface SignInViewImpl extends ViewImpl {

    EditText getEditTextEmail();
    EditText getEditTextPassword();
    void openActivity(Object activity);

}
