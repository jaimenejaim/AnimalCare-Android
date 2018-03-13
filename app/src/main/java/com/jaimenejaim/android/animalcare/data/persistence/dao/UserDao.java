package com.jaimenejaim.android.animalcare.data.persistence.dao;

import android.arch.persistence.room.Query;

import com.jaimenejaim.android.animalcare.data.persistence.entity.User;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

public interface UserDao extends BaseDao<User> {

    @Query("SELECT * FROM user")
    Maybe<List<User>> findAll();

    @Query("SELECT * FROM user WHERE id = :id")
    Maybe<User> findById(long id);


}