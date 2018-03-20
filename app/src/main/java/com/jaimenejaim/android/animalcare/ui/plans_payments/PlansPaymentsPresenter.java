package com.jaimenejaim.android.animalcare.ui.plans_payments;

import android.content.Context;

/**
 * Created by jaimenejaim on 19/03/2018.
 */

public class PlansPaymentsPresenter implements PlansPaymentsPresenterImpl {

    private PlansPaymentsViewImpl view;

    public PlansPaymentsPresenter(PlansPaymentsViewImpl view){
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
