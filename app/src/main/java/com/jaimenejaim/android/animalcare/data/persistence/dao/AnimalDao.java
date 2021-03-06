package com.jaimenejaim.android.animalcare.data.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

@Dao
public interface AnimalDao extends BaseDao<Animal> {

    @Query("SELECT * FROM animal")
    Maybe<List<Animal>> findAll();

    @Query("SELECT * FROM animal WHERE id = :id")
    Maybe<Animal> findById(long id);

    @Query("SELECT * FROM animal WHERE user_id = :user_id")
    Maybe<List<Animal>> findAllByUserId(long user_id);


}
