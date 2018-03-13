package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.jaimenejaim.android.animalcare.data.persistence.converter.DateConverter;

import java.util.ArrayList;
import java.util.Date;

import io.reactivex.annotations.NonNull;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

@Entity(tableName = "animal",foreignKeys = @ForeignKey(
        entity = User.class,
        childColumns = "userId",
        parentColumns = "id",
        onDelete = ForeignKey.CASCADE)
)
@TypeConverters(DateConverter.class)
public class Animal {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private long id;


    @ColumnInfo(name = "photo")
    @SerializedName("photo")
    private String photo;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;


    @Embedded //ignore this attribute when load Room ORM
    @SerializedName("user")
    private User user;

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    private Date createdAt;

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    private Date updatedAt;

    /*
    * This attribute was created to use the Room's Many to One relationship
    * */
    @ColumnInfo(name = "userId")
    private long userId;

    /*
    * Constructor
    * */
    @Ignore
    public Animal(){
        this.user = new User();
    }
    public Animal(long id, String name, Date createdAt, Date updatedAt, String photo, long userId) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.photo = photo;
        this.userId = userId;
//        this.user = new User();
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

}
