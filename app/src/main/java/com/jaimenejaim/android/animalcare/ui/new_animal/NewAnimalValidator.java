package com.jaimenejaim.android.animalcare.ui.new_animal;

import com.jaimenejaim.android.animalcare.ui.Callback;

/**
 * Created by jaimenejaim on 13/03/2018.
 */

public class NewAnimalValidator implements NewAnimalValidatorImpl {


    @Override
    public void after(Callback callback) {

        callback.onSuccess();

    }

    @Override
    public void before(String name, long breedId, String birthday, Callback callback) {

        if(name.isEmpty()) {
            callback.onFailure(new Exception("Informe um nome"));
            return;
        }

        if(breedId == 0) {
            callback.onFailure(new Exception("Selecione a raça"));
            return;
        }

        if(birthday.isEmpty()) {
            callback.onFailure(new Exception("Informe a data de nascimento"));
        }

    }
}
