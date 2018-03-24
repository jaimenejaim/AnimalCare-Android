package com.jaimenejaim.android.animalcare.data.network.api;

import com.google.gson.JsonObject;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.jaimenejaim.android.animalcare.data.persistence.entity.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

public interface Service {

    /*
    * Method to log in to the API
    * return @params: access_token,token_type, bearer, expired_at and refresh_expired_at when status code is 200
    * */
    @FormUrlEncoded
    @POST("/auth/login")
    Observable<Auth> logIn(@Field("username") String username, @Field("password") String password);


    @POST("/auth/logout")
    Observable<Auth> logOut(@Header("Authorization") String formmatedAccessToken);

    @POST("/auth/refresh")
    Observable<Auth> refreshToken(@Header("Authorization") String formmatedAccessToken);

    @POST("/auth/user")
    Observable<User> getUser(@Header("Authorization") String formmatedAccessToken, @Field("username") String username);

    @GET("/client/animals")
    Observable<JsonObject> getUserAnimals(@Header("Authorization") String formmatedAccessToken);

}
