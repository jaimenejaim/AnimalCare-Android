package com.jaimenejaim.android.animalcare.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.jaimenejaim.android.animalcare.data.network.api.Network;
import com.jaimenejaim.android.animalcare.data.network.api.Service;
import com.jaimenejaim.android.animalcare.ui.home.HomeActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Response;
import com.jaimenejaim.android.animalcare.data.persistence.seed.BreedSeed;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class LogInPresenter implements LogInPresenterImpl {

    private static final String TAG = LogInPresenter.class.getSimpleName();

    private Context activity;
    private Service networkService;

    public LogInPresenter(Activity activity){
        networkService = Network.getAPIService();
        this.activity = activity;

    }



    @Override
    public void logIn(String email, String password){

        networkService.logIn(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Auth>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Auth auth) {
                        Log.i(TAG,"onNext = ".concat(auth.getFormattedToken()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            Response<?> response = ((HttpException) e).response();

                            switch (response.code()){
                                case 422:
                                    Log.i(TAG,"Unprocessable Entity");
                                    Log.i(TAG,"message = ".concat(response.message()));

                                    break;

                                case 401:
                                    Log.i(TAG,"Unauthorized");
                                    Log.i(TAG,"message = ".concat(response.message()));
                                    break;

                                case 500:

                                    break;
                            }
                        }

                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG,"onComplete");

                        Intent intent = new Intent(activity, HomeActivity.class);
                        activity.startActivity(intent);
                    }
                });
    }


}
