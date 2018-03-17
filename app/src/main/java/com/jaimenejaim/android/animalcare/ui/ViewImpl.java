package com.jaimenejaim.android.animalcare.ui;

import android.content.Context;
import android.view.View;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public interface ViewImpl {
    void initComponents(View view);
    void setListeners();
    void intiPresenter();
    Context getContext();
    void finish();

    interface Activity {
        void setConfigToolbar();
    }
}
