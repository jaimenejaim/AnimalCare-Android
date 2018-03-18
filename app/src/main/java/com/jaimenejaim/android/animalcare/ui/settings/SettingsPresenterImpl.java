package com.jaimenejaim.android.animalcare.ui.settings;

import com.jaimenejaim.android.animalcare.data.persistence.entity.Settings;
import com.jaimenejaim.android.animalcare.ui.PresenterImpl;

import java.util.List;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface SettingsPresenterImpl extends PresenterImpl {
    void logOut();
    List<Settings> loadSettings();
    void onItemClick(Settings settings);
}
