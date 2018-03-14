package com.jaimenejaim.android.animalcare.ui.new_animal;

import com.jaimenejaim.android.animalcare.ui.Callback;

/**
 * Created by jaimenejaim on 13/03/2018.
 */

public interface NewAnimalValidatorImpl {
    void after(Callback callback);
    void before(String name, long breedId, String birthday, Callback callback);
}
