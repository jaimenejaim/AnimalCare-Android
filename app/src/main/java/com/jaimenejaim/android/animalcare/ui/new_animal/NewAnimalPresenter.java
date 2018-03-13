package com.jaimenejaim.android.animalcare.ui.new_animal;

import android.content.Context;

import com.jaimenejaim.android.animalcare.data.persistence.AppDatabase;
import com.jaimenejaim.android.animalcare.data.persistence.callback.DatabaseCallback;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public class NewAnimalPresenter implements NewAnimalPresenterImpl {

    private Context mContext;
    private AppDatabase appDatabase;

    public NewAnimalPresenter(Context mContext){
        this.mContext = mContext;
        appDatabase = AppDatabase.getInstance(mContext);
    }


    @Override
    public void save(Animal animal, final DatabaseCallback callback) {




        appDatabase.animalDao().insert(animal);


        appDatabase.animalDao().findAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Animal>>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull List<Animal> animals) throws Exception {
                callback.onComplete(animals);
            }
        });
    }



}
