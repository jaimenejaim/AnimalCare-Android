package com.jaimenejaim.android.animalcare.ui.events;

import android.content.Context;

/**
 * Created by jaimenejaim on 22/03/2018.
 */

public class EventsPresenter implements EventsPresenterImpl {


    private EventsViewImpl view;

    public EventsPresenter(EventsViewImpl view){
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
