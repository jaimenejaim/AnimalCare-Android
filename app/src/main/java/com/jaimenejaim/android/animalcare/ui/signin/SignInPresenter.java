package com.jaimenejaim.android.animalcare.ui.signin;

import android.content.Context;
import android.util.Log;
import android.util.Patterns;

import com.google.gson.JsonObject;
import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.network.api.Network;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.jaimenejaim.android.animalcare.data.persistence.seed.BreedSeed;
import com.jaimenejaim.android.animalcare.data.pref.Session;
import com.jaimenejaim.android.animalcare.ui.home.HomeActivity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class SignInPresenter implements SignInPresenterImpl {


    private SignInViewImpl view;
    private Network network;

    public SignInPresenter(SignInViewImpl view){
        this.view = view;
        network = new Network(getContext());

        //create breed if not exists
        new BreedSeed(getContext()).create();
    }



    @Override
    public void logIn(String email, String password){


        if(validadeLogIn(email,password)) return;


        network.logIn(email, password, new Observer<Auth>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Auth auth) {
                Session.make(getContext(), auth);
            }

            @Override
            public void onError(Throwable e) {


//                if (e instanceof HttpException) {
//                        Response<?> response = ((HttpException) e).response();
//
//                        switch (response.code()){
//
//                            case 401:
//                                view.getEditTextPassword().setError(getContext().getString(R.string.log_in_error_message_invalid_credentials));
//                                break;
//
//                            case 500:
//
//                                break;
//                        }
//                    }
            }

            @Override
            public void onComplete() {

                network.getProfile(Session.get(getContext()).getFormattedToken(), new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject jsonObject) {
                        Log.i("SignInPresenter", jsonObject.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

                view.finish();
                view.openActivity(new HomeActivity());

            }
        });
    }

    @Override
    public boolean validadeLogIn(String username, String password) {

        if(username.isEmpty()){
            view.getEditTextEmail().setError(getContext().getString(R.string.log_in_error_message_is_empty_email));
            return true;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            view.getEditTextEmail().setError(getContext().getString(R.string.log_in_error_message_invalid_email));
            return true;
        }

        if(password.isEmpty()){
            view.getEditTextPassword().setError(getContext().getString(R.string.log_in_error_message_is_empty_password));
            return true;
        }
        return false;
    }


    @Override
    public void onDestroy() {
        view = null;
        network = null;
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }
}
