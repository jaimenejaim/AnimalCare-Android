package com.jaimenejaim.android.animalcare.data.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jaimenejaim.android.animalcare.data.persistence.dao.AnimalDao;
import com.jaimenejaim.android.animalcare.data.persistence.dao.AutoSaveEmailDao;
import com.jaimenejaim.android.animalcare.data.persistence.dao.UserDao;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.data.persistence.entity.AutoSaveEmail;
import com.jaimenejaim.android.animalcare.data.persistence.entity.User;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

@Database(entities = { AutoSaveEmail.class, User.class, Animal.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "database-animalcare";

    public abstract AnimalDao animalDao();
    public abstract UserDao userDao();
    public abstract AutoSaveEmailDao autoSaveEmailDao();

    private static volatile AppDatabase instance;


    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null)
            instance = create(context);
        return instance;
    }

    private static AppDatabase create(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }


}
