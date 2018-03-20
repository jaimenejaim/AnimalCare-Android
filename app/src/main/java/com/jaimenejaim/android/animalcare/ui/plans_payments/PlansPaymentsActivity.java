package com.jaimenejaim.android.animalcare.ui.plans_payments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;

public class PlansPaymentsActivity extends BaseActivity implements PlansPaymentsViewImpl {

    private Toolbar toolbar;
    private PlansPaymentsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_payments);


        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setConfigToolbar();
        setListeners();

    }

    public void intiPresenter() {
        presenter = new PlansPaymentsPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }


    public void initComponents(View view) {
        toolbar = findViewById(R.id.toolbar);
    }

    public void setConfigToolbar(){
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
    }

    public void setListeners() {
        toolbar.setNavigationOnClickListener(v -> PlansPaymentsActivity.super.onBackPressed());
    }
}


