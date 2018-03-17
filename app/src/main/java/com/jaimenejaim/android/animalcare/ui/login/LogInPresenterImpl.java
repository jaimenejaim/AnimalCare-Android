package com.jaimenejaim.android.animalcare.ui.login;

import com.jaimenejaim.android.animalcare.ui.PresenterImpl;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface LogInPresenterImpl extends PresenterImpl {

    void logIn(String username, String password);
    boolean validadeLogIn(String username, String password);

}
