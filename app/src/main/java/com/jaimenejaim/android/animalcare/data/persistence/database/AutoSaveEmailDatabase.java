package com.jaimenejaim.android.animalcare.data.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jaimenejaim.android.animalcare.data.persistence.dao.AutoSaveEmailDao;
import com.jaimenejaim.android.animalcare.data.persistence.entity.AutoSaveEmail;

import static com.jaimenejaim.android.animalcare.data.persistence.Config.DB_NAME;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

@Database(entities = {AutoSaveEmail.class}, version = 1)
public abstract class AutoSaveEmailDatabase extends RoomDatabase {

    public abstract AutoSaveEmailDao dao();
    private static AutoSaveEmailDatabase db;

    public static AutoSaveEmailDatabase getInstance(Context context) {
        return ( db == null ? db = buildDatabaseInstance(context) : db);
    }

    private static AutoSaveEmailDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, AutoSaveEmailDatabase.class, DB_NAME)
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        db = null;
    }

}
