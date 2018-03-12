package com.jaimenejaim.android.animalcare.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public abstract class Helper extends SQLiteOpenHelper {

    public Helper(Context appContext) {

        super(appContext, Config.DATABASE_TEST.name(), Config.dbDefaultCursorFactory, Config.dbDefaultVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String sqlCmdStart = "CREATE TABLE ";
        final String primaryKeyCmd = " (ID INTEGER PRIMARY KEY AUTOINCREMENT, ";
        final String sqlCmdEnd = ");";
        final String createQuery = sqlCmdStart + defineTableNameToCreate() + primaryKeyCmd + defineTableColumnsToCreate() + sqlCmdEnd;
        db.execSQL(createQuery);
    }

    public abstract String defineTableColumnsToCreate();

    public abstract String defineTableNameToCreate();

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // NOP
    }
}