package com.jaimenejaim.android.animalcare.ui.signup;

import com.jaimenejaim.android.animalcare.ui.PresenterImpl;

/**
 * Created by jaimenejaim on 17/03/2018.
 */

public interface SignUpPresenterImpl extends PresenterImpl {
    void signUp();
    boolean validate();
}
