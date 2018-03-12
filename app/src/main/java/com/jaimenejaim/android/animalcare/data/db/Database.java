package com.jaimenejaim.android.animalcare.data.db;

import android.content.Context;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public class Database extends DatabaseManager {

    public Database(Context appContext, Helper tableToOpen) {
        super(appContext, tableToOpen);
    }

    @Override
    public String defineDatabaseNameToCreate() {
        return Config.DATABASE_TEST.name();
    }
}