package com.jaimenejaim.android.animalcare.ui.settings;

import android.widget.TextView;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface SettingsViewImpl extends ViewImpl {

    void finish();
    void openActivity(Object activity);
    TextView getTextViewProfileName();
}
