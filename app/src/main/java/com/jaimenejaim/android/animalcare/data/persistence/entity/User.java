package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.jaimenejaim.android.animalcare.data.persistence.converter.DateConverter;
import com.jaimenejaim.android.animalcare.utils.BitmapUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

@Entity(tableName = "user")
@TypeConverters(DateConverter.class)
public class User implements Parcelable {

    @PrimaryKey()
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;


    @SerializedName("username")
    @ColumnInfo(name = "username")
    private String username;

    @SerializedName("active")
    @ColumnInfo(name = "active")
    private boolean active;


    private byte[] profilePicture;

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

    @Ignore //ignore this attribute when load Room ORM
    public User(long id, String name, String username, boolean active, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.animals = new ArrayList<>();
    }

    public User(long id, String name, String username, boolean active, byte[] profilePicture, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.animals = new ArrayList<>();
        this.profilePicture = profilePicture;
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.username);
        dest.writeByte(this.active ? (byte) 1 : (byte) 0);
        dest.writeByteArray(this.profilePicture);
        dest.writeTypedList(this.animals);
        dest.writeLong(this.createdAt != null ? this.createdAt.getTime() : -1);
        dest.writeLong(this.updatedAt != null ? this.updatedAt.getTime() : -1);
    }

    protected User(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.username = in.readString();
        this.active = in.readByte() != 0;
        this.profilePicture = in.createByteArray();
        this.animals = in.createTypedArrayList(Animal.CREATOR);
        long tmpCreatedAt = in.readLong();
        this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
        long tmpUpdatedAt = in.readLong();
        this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    /* return bitmap from converted byte array saved in local storage. */
    public Bitmap getProfilePictureBitmap(){
        try {
            return BitmapUtil.decodeBitmap(this.profilePicture);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
