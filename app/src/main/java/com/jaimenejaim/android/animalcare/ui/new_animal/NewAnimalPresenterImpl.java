package com.jaimenejaim.android.animalcare.ui.new_animal;

import android.content.Context;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.AppDatabase;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public class NewAnimalPresenterImpl implements NewAnimalPresenter {

    private NewAnimalView view;
    private AppDatabase db;

    public NewAnimalPresenterImpl(NewAnimalView view){
        this.view = view;
        db = AppDatabase.getInstance(getContext());
    }


    @Override
    public void save(final String name, final long breedId, final String birthday) {

        if(validate(name,breedId,birthday)) return;


        new Thread(new Runnable() {
            @Override
            public void run() {

                db.animalDao().insert(new Animal(name,birthday,breedId));
                view.finish();
                try {

                    this.finalize();

                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public boolean validate(String name, long breedId, String birthday) {

        if(name.isEmpty()){
            if (view != null) view.setNameError(getContext().getString(R.string.new_animal_edit_text_name_error));
            return true;
        }

        if(breedId == 0){
            if (view != null)  view.setBreedError(getContext().getString(R.string.new_animal_breed_text_name_error));
            return true;
        }

        return false;
    }


    @Override
    public void onDestroy() {
        this.view = null;
        db.clear();
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }


}
