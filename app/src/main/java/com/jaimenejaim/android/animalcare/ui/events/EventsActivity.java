package com.jaimenejaim.android.animalcare.ui.events;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;

public class EventsActivity extends BaseActivity implements EventsViewImpl, EventsViewImpl.Activity {

    private Toolbar toolbar;
    private EventsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setConfigToolbar();
        setListeners();

    }

    @Override
    public void initComponents(View view) {
        toolbar = view.findViewById(R.id.toolbar);
    }

    @Override
    public void setListeners() {
        toolbar.setNavigationOnClickListener(v -> EventsActivity.super.onBackPressed());
    }

    @Override
    public void intiPresenter() {
        presenter = new EventsPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setConfigToolbar() {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setTitle(getString(R.string.my_naimal_details_settings_menu_events));
        setSupportActionBar(toolbar);
    }
}
