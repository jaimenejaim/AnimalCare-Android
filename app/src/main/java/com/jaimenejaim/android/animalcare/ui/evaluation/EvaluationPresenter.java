package com.jaimenejaim.android.animalcare.ui.evaluation;

import android.content.Context;

/**
 * Created by jaimenejaim on 19/03/2018.
 */

public class EvaluationPresenter implements EvaluationPresenterImpl {

    private EvaluationViewImpl view;


    public EvaluationPresenter(EvaluationViewImpl view){
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
