package com.jaimenejaim.android.animalcare.data.persistence.seed;

import android.content.Context;

import com.jaimenejaim.android.animalcare.data.persistence.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jaime Nascimento Nejaim on 3/15/2018.
 */

public class BreedSeed {

    private AppDatabase db;

    public BreedSeed(Context context){
        db = AppDatabase.getInstance(context);
    }

    public void create(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.breedDao().findAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<com.jaimenejaim.android.animalcare.data.persistence.entity.Breed>>() {
                    @Override
                    public void accept(@NonNull List<com.jaimenejaim.android.animalcare.data.persistence.entity.Breed> breeds) throws Exception {
                        if(breeds.size() == 0){

                            List<com.jaimenejaim.android.animalcare.data.persistence.entity.Breed> breedList = new ArrayList<>();
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Cão"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Gato"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Coelho"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Cavalo"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Arara"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Papagaio"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Elefante"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Girafa"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Leão"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Tigre"));
                            breedList.add(new com.jaimenejaim.android.animalcare.data.persistence.entity.Breed("Onça"));

                            db.breedDao().insert(breedList);

                        }
                    }
                });
            }
        });

    }

}
