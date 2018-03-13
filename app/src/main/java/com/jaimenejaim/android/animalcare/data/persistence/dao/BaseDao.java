package com.jaimenejaim.android.animalcare.data.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

@Dao
public interface BaseDao<T> {


    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     */
    @Insert
    void insert(T obj);


    /**
     * Insert an array of objects in the database.
     *
     * @param objs the objects to be inserted.
     */
    @Insert
    void insert(T... objs);


    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */

    @Delete
    void delete(T obj);


    /**
     * Update an array of objects in the database.
     *
     * @param objs the objects to be updated.
     */
    @Update
    public void update(T... objs);


    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    public void update(T obj);

}
