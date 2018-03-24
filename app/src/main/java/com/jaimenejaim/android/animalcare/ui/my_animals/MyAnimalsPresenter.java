package com.jaimenejaim.android.animalcare.ui.my_animals;

import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.network.api.Network;
import com.jaimenejaim.android.animalcare.data.network.api.Service;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.jaimenejaim.android.animalcare.data.pref.Session;
import com.jaimenejaim.android.animalcare.ui.home.HomeActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class MyAnimalsPresenter implements MyAnimalsPresenterImpl {

    private MyAnimalsViewImpl view;
    private Service networkService;

    public MyAnimalsPresenter(MyAnimalsViewImpl view){
        this.view = view;
        networkService = Network.getAPIService();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public Context getContext() {
        return view.getContext();
    }


    @Override
    public void getMyAnimals(int page) {
        networkService.getUserAnimals(Session.get(getContext()).getFormattedToken())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<JsonObject>() {


                @Override
                public void onSubscribe(Disposable d) {}

                @Override
                public void onNext(JsonObject animal) {

                    //Saving current logged user;

                    Log.i("MyAnimalPresenter", animal.toString());

                    JsonArray data = animal.getAsJsonArray("data");
                    List<Animal> animals = new ArrayList<>();

                    for(int i = 0; i < data.size(); i++){

                        Animal _animal = new Animal();

                        JsonObject jsonObject = data.get(i).getAsJsonObject();


                        _animal.setId(jsonObject.get("id").getAsLong());
                        _animal.setName(jsonObject.get("name").getAsString());

                        animals.add(_animal);
                    }

                    view.fetchDataOnRecyclerListView(animals);

                }

                @Override
                public void onError(Throwable e) {
                    if (e instanceof HttpException) {
                        Response<?> response = ((HttpException) e).response();

                        Log.i("aaa", ((HttpException) e).message());


                        switch (response.code()){

                            case 401:

                                break;

                            case 404:
                                view.setTextViewNotFoundDataVisibility(View.GONE);
                                break;

                            case 500:

                                break;
                        }
                    }
                }

                @Override
                public void onComplete() {
                    view.setVisibilityLoadIndicator(false);
                }
            });
    }

    @Override
    public void onRefresh() {
        getMyAnimals(1);
    }

    @Override
    public void onLoadMore(int page){
        getMyAnimals(page);
    }


    @Override
    public void defaultData(){
        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("","",0));
        animals.add(new Animal("","",0));
        animals.add(new Animal("","",0));
        animals.add(new Animal("","",0));
        animals.add(new Animal("","",0));
        animals.add(new Animal("","",0));
        animals.add(new Animal("","",0));


        view.fetchDataOnRecyclerListView(animals);
    }


}
