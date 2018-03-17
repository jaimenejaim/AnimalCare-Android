package com.jaimenejaim.android.animalcare.ui.signup;

import android.widget.EditText;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by jaimenejaim on 17/03/2018.
 */

public interface SignUpVewImpl extends ViewImpl {

    EditText getEditTextName();
    EditText getEditTextEmail();
    EditText getEditTextPassword();
    EditText getEditTextConfirmPassword();
    void finish();

}
