package com.jaimenejaim.android.animalcare.data.db.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

public class Animal {

    @SerializedName("id")
    private long id;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("photo")
    private String photo;

    @SerializedName("user")
    private User user;

    /*
    * Constructor
    * */
    public Animal(){
        this.user = new User();
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

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
