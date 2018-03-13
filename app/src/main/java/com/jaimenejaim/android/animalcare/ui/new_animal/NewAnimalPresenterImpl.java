package com.jaimenejaim.android.animalcare.ui.new_animal;

import com.jaimenejaim.android.animalcare.data.persistence.callback.DatabaseCallback;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;

import java.util.Observable;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public interface NewAnimalPresenterImpl {

    void save(Animal animal, DatabaseCallback callback);

}
