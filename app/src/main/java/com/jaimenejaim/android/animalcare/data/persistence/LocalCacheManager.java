package com.jaimenejaim.android.animalcare.data.persistence;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.jaimenejaim.android.animalcare.data.persistence.callback.DatabaseCallback;
import com.jaimenejaim.android.animalcare.data.persistence.entity.AutoSaveEmail;
import com.jaimenejaim.android.animalcare.data.persistence.database.AutoSaveEmailDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

public class LocalCacheManager {

    public static final String DB_NAME = "database-animalcare";
    private Context context;
    private static LocalCacheManager _instance;
    private AutoSaveEmailDatabase db;

    public static LocalCacheManager getInstance(Context context) {
        return (_instance == null ? _instance = new LocalCacheManager(context) : _instance);
    }

    public LocalCacheManager(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context, AutoSaveEmailDatabase.class, DB_NAME).build();
    }

    public void findAll(final DatabaseCallback<AutoSaveEmail> databaseCallback) {
        db.dao().findAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<AutoSaveEmail>>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull List<AutoSaveEmail> users) throws Exception {
                databaseCallback.onComplete(users);

            }
        });
    }

    public void add(final DatabaseCallback<AutoSaveEmail> databaseCallback, final String firstName, final String lastName) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {

                AutoSaveEmail autoSaveEmail = new AutoSaveEmail(firstName, lastName);
                db.dao().insert(autoSaveEmail);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
                databaseCallback.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                databaseCallback.onError(e);
            }
        });
    }

    public void delete(final DatabaseCallback databaseCallback, final AutoSaveEmail user) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.dao().delete(user);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                databaseCallback.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                databaseCallback.onError(e);
            }
        });
    }


    public void update(final DatabaseCallback databaseCallback, final AutoSaveEmail user) {
        user.setFirstName("first name first name");
        user.setLastName("last name last name");
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.dao().update(user);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                databaseCallback.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                databaseCallback.onError(e);
            }
        });
    }

}
