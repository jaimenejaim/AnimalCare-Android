package com.jaimenejaim.android.animalcare.data.persistence.dao;

import android.arch.persistence.room.Query;

import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

public interface AnimalDao extends BaseDao<Animal> {

    @Query("SELECT * FROM animal")
    Maybe<List<Animal>> findAll();

    @Query("SELECT * FROM animal WHERE id = :id")
    Maybe<Animal> findById(long id);

    @Query("SELECT * FROM animal WHERE userId = :userId")
    Maybe<List<Animal>> findAllByUserId(long userId);


}
