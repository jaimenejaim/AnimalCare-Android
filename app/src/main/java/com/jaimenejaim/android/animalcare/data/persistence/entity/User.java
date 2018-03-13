package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.NonNull;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

@Entity(tableName = "user")
public class User {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private long id;

    @SerializedName("username")
    @ColumnInfo(name = "username")
    private String username;

    @SerializedName("active")
    @ColumnInfo(name = "active")
    private boolean active;

//    @SerializedName("animals")
//    @Relation(parentColumn = "id", entityColumn = "id", entity = Animal.class)
//    private List<Animal> animals;


    /*
     * Constructor
     * */
//    public User(){
//        this.animals = new ArrayList<>();
//    }


    /*
    * Gets and Sets
    * */
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

//    public List<Animal> getAnimals() {
//        return animals;
//    }
//    public void setAnimals(List<Animal> animals) {
//        this.animals = animals;
//    }

}
