package com.jaimenejaim.android.animalcare.ui.new_animal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jaimenejaim.android.animalcare.R;

public class NewAnimalActivity extends AppCompatActivity implements NewAnimalViewImpl {

    EditText editTextName, editTextBreed, editTextBirthDay;
    Spinner spinnerBreed;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initComponents(getCurrentFocus());
        setListeners();
    }

    @Override
    public void initComponents(View view) {

        editTextName = findViewById(R.id.editTextName);
        editTextBreed = findViewById(R.id.editTextBreed);
        editTextBirthDay = findViewById(R.id.editTextBirthDay);
        buttonSave = findViewById(R.id.buttonSave);
        spinnerBreed = findViewById(R.id.spinnerBreed);

    }

    @Override
    public void setListeners() {

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}