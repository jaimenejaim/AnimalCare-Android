package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

@Entity(tableName = "autoSaveEmail")
public class AutoSaveEmail {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "email")
    private String email;



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
