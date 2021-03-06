package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.jaimenejaim.android.animalcare.data.persistence.converter.DateConverter;

import java.util.Date;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

@Entity
//        (tableName = "animal",foreignKeys = @ForeignKey(
//        entity = User.class,
//        childColumns = "user_id",
//        parentColumns = "id",
//        onDelete = ForeignKey.CASCADE)
//)
@TypeConverters(DateConverter.class)
public class Animal implements Parcelable {

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

    @ColumnInfo(name = "birth_day")
    private String birthDay;


    @Ignore //ignore this attribute when load Room ORM
    @SerializedName("user")
    private User user;

    @Ignore
    @SerializedName("breed")
    private Breed breed;

    /*
    * This attribute was created to use the Room's Many to One relationship
    * */
    @ColumnInfo(name = "user_id")
    private long userId;

    /*
     * This attribute was created to use the Room's Many to One relationship
     * */
    @ColumnInfo(name = "breed_id")
    private long breedId;

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    private Date createdAt;

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    private Date updatedAt;


    /*
    * Constructor
    * */
    @Ignore
    public Animal(){
        this.user = new User();
        this.breed = new Breed();
    }

    @Ignore
    public Animal(String name, String birthDay, long breedId) {
        this.name = name;
        this.birthDay = birthDay;
        this.breedId = breedId;
        this.user = new User();
        this.breed = new Breed();
    }

    public Animal(long id, String name, Date createdAt, Date updatedAt, String photo, long userId) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.photo = photo;
        this.userId = userId;
        this.user = new User();
        this.breed = new Breed();
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

    public Breed getBreed() {
        return breed;
    }
    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public long getBreedId() {
        return breedId;
    }
    public void setBreedId(long breedId) {
        this.breedId = breedId;
    }

    public String getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.birthDay);
        dest.writeParcelable(this.user, flags);
        dest.writeParcelable(this.breed, flags);
        dest.writeLong(this.userId);
        dest.writeLong(this.breedId);
        dest.writeLong(this.createdAt != null ? this.createdAt.getTime() : -1);
        dest.writeLong(this.updatedAt != null ? this.updatedAt.getTime() : -1);
    }

    protected Animal(Parcel in) {
        this.id = in.readLong();
        this.photo = in.readString();
        this.name = in.readString();
        this.birthDay = in.readString();
        this.user = in.readParcelable(User.class.getClassLoader());
        this.breed = in.readParcelable(Breed.class.getClassLoader());
        this.userId = in.readLong();
        this.breedId = in.readLong();
        long tmpCreatedAt = in.readLong();
        this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
        long tmpUpdatedAt = in.readLong();
        this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel source) {
            return new Animal(source);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };
}
