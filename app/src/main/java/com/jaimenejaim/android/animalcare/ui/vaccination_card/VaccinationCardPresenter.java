package com.jaimenejaim.android.animalcare.ui.vaccination_card;

import android.content.Context;

/**
 * Created by jaimenejaim on 22/03/2018.
 */

public class VaccinationCardPresenter implements VaccinationCardPresenterImpl {

    VaccinationCardView view;

    public VaccinationCardPresenter(VaccinationCardView view){
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
