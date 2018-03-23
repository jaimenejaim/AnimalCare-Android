package com.jaimenejaim.android.animalcare.ui.animals_data_details;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;

public class AnimalsDataDetailsActivity extends AppCompatActivity implements AnimalsDataDetailsViewImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_data_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public void initComponents(View view) {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void intiPresenter() {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
