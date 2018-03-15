package com.jaimenejaim.android.animalcare.data.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Breed;
import java.util.List;
import io.reactivex.Maybe;


/**
 * Created by Jaime Nascimento Nejaim on 3/15/2018.
 */

@Dao
public interface BreedDao extends BaseDao<Breed> {

    @Query("SELECT * FROM breed")
    Maybe<List<Breed>> findAll();

    @Query("SELECT * FROM breed WHERE id = :id")
    Maybe<Breed> findById(long id);


}
