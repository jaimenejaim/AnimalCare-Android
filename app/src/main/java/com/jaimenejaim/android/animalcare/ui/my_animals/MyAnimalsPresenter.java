package com.jaimenejaim.android.animalcare.ui.my_animals;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jaimenejaim.android.animalcare.data.network.api.Network;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.data.pref.Session;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class MyAnimalsPresenter implements MyAnimalsPresenterImpl {

    private MyAnimalsViewImpl view;
    private Network network;

    public MyAnimalsPresenter(MyAnimalsViewImpl view){
        this.view = view;
        network = new Network(getContext());
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public Context getContext() {
        return view.getContext();
    }

//    @Override
    public void loadData(){

        //showing listview with skeleton loading...
        view.setRefreshingOnStartLoadingData();
        view.onFoundData();

        network.getMyAnimals(Session.get(getContext()).getFormattedToken(), new Observer<JsonObject>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonObject jsonObject) {

                Log.i("MyAnimalsPresenter", jsonObject.toString());

                JsonArray data = jsonObject.getAsJsonArray("data");
                List<Animal> animals = new ArrayList<>();


                if(data.size() > 0){
                    for(int i = 0; i < data.size(); i++){
                        Animal animal = new Animal();
                        animal.setBreedId(data.get(i).getAsJsonObject().get("id").getAsLong());
                        animal.setName(data.get(i).getAsJsonObject().get("name").getAsString());

                        animals.add(animal);
                    }

                    view.configRecyclerView(animals);
                    view.setRefreshingOnFinishLoadingData();

                } else {
                    view.onNotFoundData();
                    view.setRefreshingOnFinishLoadingData();
                }



            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                view.onNotFoundData();
                view.setRefreshingOnFinishLoadingData();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
