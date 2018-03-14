package com.jaimenejaim.android.animalcare.ui.new_animal;

import com.jaimenejaim.android.animalcare.data.persistence.callback.DatabaseCallback;

/**
 * Created by Jaime Nascimento Nejaim on 3/14/2018.
 */

public interface NewAnimalInteractor {

    interface OnLoginFinishedListener {
        void setNameError();
        void setBreedError();
        void onSuccess();
        void onError(Throwable e);
    }

    void save(String name, long breed, String birthDay, OnLoginFinishedListener listener);

}
