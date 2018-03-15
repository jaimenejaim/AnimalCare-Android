package com.jaimenejaim.android.animalcare.data.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jaimenejaim.android.animalcare.data.persistence.dao.AnimalDao;
import com.jaimenejaim.android.animalcare.data.persistence.dao.AutoSaveEmailDao;
import com.jaimenejaim.android.animalcare.data.persistence.dao.BreedDao;
import com.jaimenejaim.android.animalcare.data.persistence.dao.UserDao;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.data.persistence.entity.AutoSaveEmail;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Breed;
import com.jaimenejaim.android.animalcare.data.persistence.entity.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

@Database(entities = { AutoSaveEmail.class, User.class, Animal.class, Breed.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "database-animalcare";

    public abstract AnimalDao animalDao();
    public abstract UserDao userDao();
    public abstract AutoSaveEmailDao autoSaveEmailDao();
    public abstract BreedDao breedDao();

    private static volatile AppDatabase instance;


    public static synchronized AppDatabase getInstance(Context context) {
        return instance == null ? instance = create(context) : instance;
    }

    private static AppDatabase create(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }

    public void clear(){
        instance = null;
    }


}
