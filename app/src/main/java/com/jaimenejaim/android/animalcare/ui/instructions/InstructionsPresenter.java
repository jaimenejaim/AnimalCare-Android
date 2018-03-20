package com.jaimenejaim.android.animalcare.ui.instructions;

import android.content.Context;

/**
 * Created by jaimenejaim on 19/03/2018.
 */

public class InstructionsPresenter implements InstructionsPresenterImpl {

    private InstructionsViewImpl view;


    public InstructionsPresenter(InstructionsViewImpl view){
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
