package com.jaimenejaim.android.animalcare.ui.search;

import android.content.Context;

/**
 * Created by jaimenejaim on 18/03/2018.
 */

public class SearchPresenter implements SearchPresenterImpl {

    private SearchViewImpl view;


    public SearchPresenter(SearchViewImpl view){
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
