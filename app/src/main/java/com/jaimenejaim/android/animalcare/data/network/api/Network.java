package com.jaimenejaim.android.animalcare.data.network.api;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.google.gson.JsonObject;
import com.jaimenejaim.android.animalcare.BuildConfig;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

/**
 * Created by jaimenejaim on 26/03/2018.
 */

public class Network {

    private static final String TAG = Network.class.getSimpleName();

    private static final String BASE_URL = BuildConfig.URL;
    private static final String LOGIN = BASE_URL.concat("/auth/login");
    private static final String LOGOUT = BASE_URL.concat("/auth/logout");
    private static final String MY_ANIMALS = BASE_URL.concat("/client/animals");
    private static final String PROFILE = BASE_URL.concat("/auth/user");

    public Network(Context context){

        OkHttpClient okHttpClient = new OkHttpClient() .newBuilder()
//                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(context, okHttpClient);
    }


    public void logIn(String email, String password, Observer<Auth> observable){
        Rx2AndroidNetworking.post(LOGIN)
                .addBodyParameter("username", email)
                .addBodyParameter("password", password)
                .setPriority(Priority.MEDIUM)
                .build()
                .getObjectObservable(Auth.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);

    }

    public void logOut(String token,  Observer<String> observable){
        Rx2AndroidNetworking.post(LOGOUT)
                .addHeaders("Authorization", token)
                .setPriority(Priority.MEDIUM)
                .build()
                .getObjectObservable(String.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);
    }


    public void getMyAnimals(String token,  Observer<JsonObject> observable){
        Log.i("Network", token);
        Rx2AndroidNetworking.get(MY_ANIMALS)
                .addHeaders("Authorization", token)
                .setPriority(Priority.MEDIUM)
                .build()
                .getObjectObservable(JsonObject.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);
    }

    public void getProfile(String token,  Observer<JsonObject> observable){
        Rx2AndroidNetworking.post(PROFILE)
                .addHeaders("Authorization", token)
                .setPriority(Priority.MEDIUM)
                .build()
                .getObjectObservable(JsonObject.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);
    }

}
