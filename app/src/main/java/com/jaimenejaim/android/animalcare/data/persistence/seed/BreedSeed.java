package com.jaimenejaim.android.animalcare.data.persistence.seed;

import android.content.Context;

import com.jaimenejaim.android.animalcare.data.persistence.AppDatabase;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Breed;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
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
        new Thread(() ->
                db.breedDao().findAll()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(breeds -> {
                            if(breeds.size() == 0){

                                List<Breed> breedList = new ArrayList<>();
                                breedList.add(new Breed("Cão"));
                                breedList.add(new Breed("Gato"));
                                breedList.add(new Breed("Coelho"));
                                breedList.add(new Breed("Cavalo"));
                                breedList.add(new Breed("Arara"));
                                breedList.add(new Breed("Papagaio"));
                                breedList.add(new Breed("Elefante"));
                                breedList.add(new Breed("Girafa"));
                                breedList.add(new Breed("Leão"));
                                breedList.add(new Breed("Tigre"));
                                breedList.add(new Breed("Onça"));

                                db.breedDao().insert(breedList);

                            }
                        })
        );

    }

}
