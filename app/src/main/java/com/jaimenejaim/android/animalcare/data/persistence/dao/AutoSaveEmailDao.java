package com.jaimenejaim.android.animalcare.data.persistence.dao;

import android.arch.persistence.room.Query;

import com.jaimenejaim.android.animalcare.data.persistence.entity.AutoSaveEmail;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

public interface AutoSaveEmailDao extends BaseDao<AutoSaveEmail> {

    @Query("SELECT * FROM autoSaveEmail")
    Maybe<List<AutoSaveEmail>> findAll();

    @Query("SELECT * FROM autoSaveEmail WHERE email = :email")
    Maybe<AutoSaveEmail> findByEmail(String email);

}
