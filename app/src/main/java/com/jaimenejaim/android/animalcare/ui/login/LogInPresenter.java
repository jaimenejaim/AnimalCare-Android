package com.jaimenejaim.android.animalcare.ui.login;

import android.content.Context;
import android.content.Intent;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.network.api.Network;
import com.jaimenejaim.android.animalcare.data.network.api.Service;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.jaimenejaim.android.animalcare.data.persistence.seed.BreedSeed;
import com.jaimenejaim.android.animalcare.data.pref.Session;
import com.jaimenejaim.android.animalcare.ui.home.HomeActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class LogInPresenter implements LogInPresenterImpl {


    private LogInViewImpl view;
    private Service networkService;

    public LogInPresenter(LogInViewImpl view){
        this.view = view;
        networkService = Network.getAPIService();

        //create breed if not exists
        new BreedSeed(getContext()).create();
    }



    @Override
    public void logIn(String email, String password){


        if(validadeLogIn(email,password))
            return;


        networkService.logIn(email,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<Auth>() {
                @Override
                public void onSubscribe(Disposable d) {}

                @Override
                public void onNext(Auth auth) {

                    //Saving current logged user;
                    Session.make(getContext(), auth);

                }

                @Override
                public void onError(Throwable e) {
                    if (e instanceof HttpException) {
                        Response<?> response = ((HttpException) e).response();

                        switch (response.code()){

                            case 401:
                                view.setPasswordError(getContext().getString(R.string.log_in_error_message_invalid_credentials));
                                break;

                            case 500:

                                break;
                        }
                    }
                }

                @Override
                public void onComplete() {

                    Intent intent = new Intent(getContext(), HomeActivity.class);
                    getContext().startActivity(intent);
                    view.finish();
                }
            });
    }

    @Override
    public boolean validadeLogIn(String username, String password) {

        if(username.isEmpty()){
            view.setEmailError(getContext().getString(R.string.log_in_error_message_is_empty_email));
            return true;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            view.setEmailError(getContext().getString(R.string.log_in_error_message_invalid_email));
            return true;
        }

        if(password.isEmpty()){
            view.setPasswordError(getContext().getString(R.string.log_in_error_message_is_empty_password));
            return true;
        }
        return false;
    }


    @Override
    public void onDestroy() {
        view = null;
        networkService = null;
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }
}
