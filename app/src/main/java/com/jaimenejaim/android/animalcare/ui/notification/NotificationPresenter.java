package com.jaimenejaim.android.animalcare.ui.notification;

import android.content.Context;

/**
 * Created by jaimenejaim on 18/03/2018.
 */

public class NotificationPresenter implements NotificationPresenterImpl {

    private NotificationViewImpl view;

    public NotificationPresenter(NotificationViewImpl view){
        this.view = view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public Context getContext() {
        return view.getContext();
    }
}
