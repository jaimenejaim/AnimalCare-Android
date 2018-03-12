package com.jaimenejaim.android.animalcare.data.db;

import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public enum Config {

    DATABASE_TEST, DATABASE_PRODUCTION;

    public static final int dbDefaultVersion = 1;
    public static final CursorFactory dbDefaultCursorFactory = null;


}
