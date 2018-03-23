package com.jaimenejaim.android.animalcare.ui.friend_care;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;

public class FriendCareActivity extends BaseActivity implements FriendCareViewImpl, FriendCareViewImpl.Activity {

    private Toolbar toolbar;
    private FriendCarePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_care);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setConfigToolbar();
        setListeners();

    }

    @Override
    public void intiPresenter() {
        presenter = new FriendCarePresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initComponents(View view) {
        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public void setConfigToolbar(){
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setTitle(getString(R.string.settings_menu_care));
        setSupportActionBar(toolbar);
    }

    @Override
    public void setListeners() {
        toolbar.setNavigationOnClickListener(v -> FriendCareActivity.super.onBackPressed());
    }

}
