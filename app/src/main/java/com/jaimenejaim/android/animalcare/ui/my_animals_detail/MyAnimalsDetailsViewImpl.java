package com.jaimenejaim.android.animalcare.ui.my_animals_detail;

import android.content.Intent;

import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by jaimenejaim on 13/03/2018.
 */

public interface MyAnimalsDetailsViewImpl extends ViewImpl, ViewImpl.Activity {

    Animal getAnimalFromExtra(Intent intent);
    void openActivity(Object object);

}
