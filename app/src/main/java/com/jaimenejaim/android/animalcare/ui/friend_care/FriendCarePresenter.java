package com.jaimenejaim.android.animalcare.ui.friend_care;

import android.content.Context;

/**
 * Created by jaimenejaim on 19/03/2018.
 */

public class FriendCarePresenter implements FriendCarePresenterImpl {

    private FriendCareViewImpl view;

    public FriendCarePresenter(FriendCareViewImpl view){
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
