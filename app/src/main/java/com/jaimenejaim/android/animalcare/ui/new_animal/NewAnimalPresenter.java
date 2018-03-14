package com.jaimenejaim.android.animalcare.ui.new_animal;

import android.app.Activity;
import android.util.Log;

import com.jaimenejaim.android.animalcare.data.persistence.AppDatabase;
import com.jaimenejaim.android.animalcare.data.persistence.callback.DatabaseCallback;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.ui.Callback;
import com.jaimenejaim.android.animalcare.utils.DialogUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public class NewAnimalPresenter implements NewAnimalPresenterImpl {

    private Activity mActivity;
    private AppDatabase db;
    private NewAnimalValidator validator;

    public NewAnimalPresenter(Activity mActivity){
        this.mActivity = mActivity;
        db = AppDatabase.getInstance(mActivity.getApplicationContext());
        validator = new NewAnimalValidator();
    }


    @Override
    public void save(final String name, final long breedId, final String birthday) {

        validator.before(name, breedId, birthday, new Callback() {

            @Override
            public void onSuccess() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        db.animalDao().insert(new Animal(name,birthday,breedId));

                        final DatabaseCallback<Animal> callback = new DatabaseCallback<Animal>(){

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onComplete(Animal animal) {

                            }

                            @Override
                            public void onComplete(List<Animal> t) {

                                for (int i = 0; i < t.size(); i++) {
                                    Log.i("NewAnimalPresenter"," name = ".concat(t.get(i).getName()));
                                    Log.i("NewAnimalPresenter"," id = ".concat(String.valueOf(t.get(i).getId())));
                                }


                                try {

                                    //force close this Activity.
                                    mActivity.finish();

                                    //force close current Thread.
                                    finalize();

                                } catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("NewAnimalPresenter", e.getMessage());
                                e.printStackTrace();
                            }
                        };

                        db.animalDao().findAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Animal>>() {
                            @Override
                            public void accept(@io.reactivex.annotations.NonNull List<Animal> animals) throws Exception {
                                callback.onComplete(animals);
                            }
                        });
                    }
                }).start();
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();

                DialogUtil.showAlert(mActivity,"Ops!",e.getMessage());

            }
        });
    }



}
