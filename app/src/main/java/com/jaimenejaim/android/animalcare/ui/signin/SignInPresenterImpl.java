package com.jaimenejaim.android.animalcare.ui.signin;

import com.jaimenejaim.android.animalcare.ui.PresenterImpl;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface SignInPresenterImpl extends PresenterImpl {

    void logIn(String username, String password);
    boolean validadeLogIn(String username, String password);

}
