package com.jaimenejaim.android.animalcare.ui;

import android.view.View;

import com.jaimenejaim.android.animalcare.R;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public interface ViewImpl {
    void initComponents(View view);
    void setListeners();
    void onBackPressed();
    void intiPresenter();

    interface Activity {
        void setConfigToolbar();
    }
}
