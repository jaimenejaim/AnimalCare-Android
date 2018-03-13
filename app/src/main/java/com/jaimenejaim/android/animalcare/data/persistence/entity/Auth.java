package com.jaimenejaim.android.animalcare.data.persistence.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

public class Auth {

    @SerializedName("id")
    private long id;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("access_token")
    private String access_token;

    @SerializedName("refresh_token")
    private String refresh_token;

    @SerializedName("token_type")
    private String token_type;

    @SerializedName("expired_at")
    private String expired_at;

    @SerializedName("refresh_expired_at")
    private String refresh_expired_at;


    /*
    * Constructor
    * */
    public Auth(){}


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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess_token() {
        return access_token;
    }
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken_type() {
        return token_type;
    }
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpired_at() {
        return expired_at;
    }
    public void setExpired_at(String expired_at) {
        this.expired_at = expired_at;
    }

    public String getRefresh_expired_at() {
        return refresh_expired_at;
    }
    public void setRefresh_expired_at(String refresh_expired_at) {
        this.refresh_expired_at = refresh_expired_at;
    }


    /*
    * this method @return String token Formatted, for example Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiKJ0
    * */
    public String getFormattedToken(){
        return this.token_type.concat(" ").concat(access_token);
    }
}
