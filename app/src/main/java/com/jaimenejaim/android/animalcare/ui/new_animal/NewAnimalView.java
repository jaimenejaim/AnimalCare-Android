package com.jaimenejaim.android.animalcare.ui.new_animal;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public interface NewAnimalView extends ViewImpl {
    void setNameError(String msg);
    void setBreedError(String msg);
    void finish();

}
