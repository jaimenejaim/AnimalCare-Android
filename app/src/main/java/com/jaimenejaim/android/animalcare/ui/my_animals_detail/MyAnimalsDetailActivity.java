package com.jaimenejaim.android.animalcare.ui.my_animals_detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;

public class MyAnimalsDetailActivity extends BaseActivity implements MyAnimalsDetailsViewImpl {


    Toolbar toolbar;
    Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_animals_detail);

        animal = getAnimalFromExtra(getIntent());

        initComponents(findViewById(android.R.id.content));
        setConfigToolbar();
        setListeners();



    }

    @Override
    public void initComponents(View view) {
        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public void setListeners() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAnimalsDetailActivity.super.onBackPressed();
            }
        });
    }

    @Override
    public void intiPresenter() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Animal getAnimalFromExtra(Intent intent) {
        return intent.getParcelableExtra("animal");
    }

    @Override
    public void setConfigToolbar() {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setTitle(animal.getName());
        setSupportActionBar(toolbar);
    }
}
