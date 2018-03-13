package com.jaimenejaim.android.animalcare.data.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.jaimenejaim.android.animalcare.data.persistence.dao.UserDao;
import com.jaimenejaim.android.animalcare.data.persistence.entity.User;

/**
 * Created by jaimenejaim on 12/03/2018.
 */



@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao dao();
}
