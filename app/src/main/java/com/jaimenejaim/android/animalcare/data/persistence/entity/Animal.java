package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.reactivex.annotations.NonNull;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

@Entity(tableName = "animal")
public class Animal {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private long id;


    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    private Date created_at;


    @ColumnInfo(name = "photo")
    @SerializedName("photo")
    private String photo;


    @SerializedName("user")
    private User user;

    /*
    * Constructor
    * */
//    public Animal(){
//        this.user = new User();
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

    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

//    public User getUser() {
//        return user;
//    }
//    public void setUser(User user) {
//        this.user = user;
//    }
}
