package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.jaimenejaim.android.animalcare.data.persistence.converter.DateConverter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

@Entity(tableName = "user")
@TypeConverters(DateConverter.class)
public class User {

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

    @Ignore //ignore this attribute when load Room ORM
    @SerializedName("animals")
    private List<Animal> animals;

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    private Date createdAt;

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    private Date updatedAt;

    /*
     * Constructors
     * */
    @Ignore //ignore this attribute when load Room ORM
    public User(){
        this.animals = new ArrayList<>();
    }
    public User(long id, String username, boolean active, Date createdAt, Date updatedAt) {
        this.id = id;
        this.username = username;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.animals = new ArrayList<>();
    }

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

    public List<Animal> getAnimals() {
        return animals;
    }
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
