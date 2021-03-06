package com.jaimenejaim.android.animalcare.ui.new_animal;

import com.jaimenejaim.android.animalcare.ui.PresenterImpl;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public interface NewAnimalPresenter extends PresenterImpl {

    void save(String name, long breedId, String birthday);
    boolean validate(String name, long breedId, String birthday);

}
