package com.jaimenejaim.android.animalcare.ui.settings;

import android.content.Context;

import com.jaimenejaim.android.animalcare.data.network.api.Network;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.jaimenejaim.android.animalcare.data.pref.Session;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class SettingsPresenter implements SettingsPresenterImpl {

    SettingsViewImpl view;


    public SettingsPresenter(SettingsViewImpl view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }

    @Override
    public void logOut() {
        //logout async

        new Thread(() -> {
            Network.getAPIService().logOut(Session.get(view.getContext()).getFormattedToken()).subscribe(new Observer<Auth>() {
                @Override
                public void onSubscribe(Disposable d) {}

                @Override
                public void onNext(Auth auth) {}

                @Override
                public void onError(Throwable e) {
                    try {
                        //kill this current thread

                        Session.destroy(view.getContext());
                        view.finish();

                        this.finalize();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }

                @Override
                public void onComplete() {
                    try {
                        //kill this current thread

                        Session.destroy(view.getContext());
                        view.finish();

                        this.finalize();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            });

        }).start();


    }
}
