package com.jaimenejaim.android.animalcare.ui.settings;

import android.content.Context;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class SettingsPresenter implements SettingsPresenterImpl {

    SettingsViewImpl view;

    public SettingsPresenter(SettingsViewImpl view) {
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
