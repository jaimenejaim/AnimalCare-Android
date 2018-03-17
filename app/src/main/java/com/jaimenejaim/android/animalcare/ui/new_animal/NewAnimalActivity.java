package com.jaimenejaim.android.animalcare.ui.new_animal;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;

public class NewAnimalActivity extends BaseActivity implements NewAnimalView, NewAnimalView.Activity {

    EditText editTextName, editTextBreed, editTextBirthDay;
    Spinner spinnerBreed;
    Button buttonSave;
    Toolbar toolbar;

    NewAnimalPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_animal);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setConfigToolbar();
        setListeners();


    }

    @Override
    public void initComponents(View view) {
        toolbar = findViewById(R.id.toolbar);
        editTextName = view.findViewById(R.id.editTextName);
        editTextBreed = view.findViewById(R.id.editTextBreed);
        editTextBirthDay = view.findViewById(R.id.editTextBirthDay);
        buttonSave = view.findViewById(R.id.buttonSave);
        spinnerBreed = view.findViewById(R.id.spinnerBreed);

    }


    @Override
    public void setConfigToolbar(){
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
    }

    @Override
    public void setListeners() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewAnimalActivity.super.onBackPressed();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.save(editTextName.getText().toString(), 1, editTextBirthDay.getText().toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void intiPresenter() {
        presenter = new NewAnimalPresenterImpl(this);
    }

    @Override
    public Context getContext() {
        return this;
    }


    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setNameError(String msg) {
        editTextName.setError(msg);
    }

    @Override
    public void setBreedError(String msg) {
        editTextBreed.setError(msg);
    }

    @Override
    public void finish() {
        super.finish();
    }

}
