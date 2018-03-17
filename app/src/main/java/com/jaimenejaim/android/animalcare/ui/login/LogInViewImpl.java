package com.jaimenejaim.android.animalcare.ui.login;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface LogInViewImpl extends ViewImpl {

    void setEmailError(String msg);
    void setPasswordError(String msg);

}
