package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.jaimenejaim.android.animalcare.data.persistence.converter.DateConverter;

import java.util.Date;

/**
 * Created by jaimenejaim on 13/03/2018.
 */

@Entity(tableName = "breed")
@TypeConverters(DateConverter.class)
public class Breed {

    @PrimaryKey
    @SerializedName("id")
    private long id;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    private Date createdAt;

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    private Date updatedAt;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
