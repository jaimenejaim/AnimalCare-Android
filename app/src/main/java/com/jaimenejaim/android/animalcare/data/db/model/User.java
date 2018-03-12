package com.jaimenejaim.android.animalcare.data.db.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

public class User {

    @SerializedName("id")
    private long id;

    @SerializedName("username")
    private String username;

    @SerializedName("active")
    private boolean active;

    @SerializedName("animals")
    private List<Animal> animals;


    /*
     * Constructor
     * */
    public User(){
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

}
