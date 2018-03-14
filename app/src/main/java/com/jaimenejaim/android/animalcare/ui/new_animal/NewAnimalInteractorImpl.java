package com.jaimenejaim.android.animalcare.ui.new_animal;

import android.app.Activity;
import android.util.Log;

import com.jaimenejaim.android.animalcare.data.persistence.AppDatabase;
import com.jaimenejaim.android.animalcare.data.persistence.callback.DatabaseCallback;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.annotations.NonNull;

/**
 * Created by Jaime Nascimento Nejaim on 3/14/2018.
 */

public class NewAnimalInteractorImpl implements NewAnimalInteractor {

    private AppDatabase db;
    private Activity activity;

    public NewAnimalInteractorImpl(Activity activity){
        this.activity = activity;
        db = AppDatabase.getInstance(activity.getApplicationContext());
    }


    @Override
    public void save(final String name, final long breed, final String birthDay, final OnLoginFinishedListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                db.animalDao().insert(new Animal(name,birthDay,breed));

                final DatabaseCallback<Animal> callback = new DatabaseCallback<Animal>(){

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onComplete(Animal animal) {}

                    @Override
                    public void onComplete(List<Animal> t) {

                        for (int i = 0; i < t.size(); i++) {
                            Log.i("NewAnimalPresenterImpl"," name = ".concat(t.get(i).getName()));
                            Log.i("NewAnimalPresenterImpl"," id = ".concat(String.valueOf(t.get(i).getId())));
                        }


                        try {

                            listener.onSuccess();
                            finalize();

                        } catch (Throwable throwable) {
                            listener.onError(throwable);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        listener.onError(throwable);
                    }
                };

                db.animalDao().findAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Animal>>() {
                    @Override
                    public void accept(@NonNull List<Animal> animals) throws Exception {
                        callback.onComplete(animals);
                    }
                });
            }
        }).start();
    }
}
