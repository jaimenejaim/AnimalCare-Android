package com.jaimenejaim.android.animalcare.ui.my_animals_detail;

import com.jaimenejaim.android.animalcare.ui.PresenterImpl;
import com.jaimenejaim.android.animalcare.ui.my_animals_detail.others.MyAnimalsDetailSettings;

/**
 * Created by jaimenejaim on 13/03/2018.
 */

public interface MyAnimalsDetailsPresenterImpl extends PresenterImpl {
    void onItemClick(MyAnimalsDetailSettings settings);
}
