package com.jaimenejaim.android.animalcare.ui.my_account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;

public class MyAccountActivity extends BaseActivity implements MyAccountViewImpl {

    private MyAccountPresenter presenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setConfigToolbar();
        setListeners();

    }

    public void intiPresenter() {
        presenter = new MyAccountPresenter(this);
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
        toolbar.setNavigationOnClickListener(v -> MyAccountActivity.super.onBackPressed());
    }

}
