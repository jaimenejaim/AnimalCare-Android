package com.jaimenejaim.android.animalcare.ui.login;

import android.widget.EditText;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface LogInViewImpl extends ViewImpl {

    EditText getEditTextEmail();
    EditText getEditTextPassword();

}
