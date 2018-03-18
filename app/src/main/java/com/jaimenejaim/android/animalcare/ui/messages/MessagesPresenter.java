package com.jaimenejaim.android.animalcare.ui.messages;

import android.content.Context;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class MessagesPresenter implements MessagesPresenterImpl {

    private MessagesViewImpl view;

    public MessagesPresenter(MessagesViewImpl view){
        this.view = view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
