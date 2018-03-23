package com.jaimenejaim.android.animalcare.ui.queries;

import android.content.Context;

/**
 * Created by jaimenejaim on 22/03/2018.
 */

public class QueriesPresenter implements QueriesPresenterImpl {

    private QueriesView view;

    public QueriesPresenter(QueriesView view){
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
