package com.jaimenejaim.android.animalcare.ui.new_animal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.callback.DatabaseCallback;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;

import java.util.List;

public class NewAnimalActivity extends AppCompatActivity implements NewAnimalViewImpl {

    EditText editTextName, editTextBreed, editTextBirthDay;
    Spinner spinnerBreed;
    Button buttonSave;

    NewAnimalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setListeners();


    }

    @Override
    public void initComponents(View view) {

        editTextName = view.findViewById(R.id.editTextName);
        editTextBreed = view.findViewById(R.id.editTextBreed);
        editTextBirthDay = view.findViewById(R.id.editTextBirthDay);
        buttonSave = view.findViewById(R.id.buttonSave);
        spinnerBreed = view.findViewById(R.id.spinnerBreed);

    }

    @Override
    public void setListeners() {

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Animal animal = new Animal();
                animal.setName(editTextName.getText().toString());


                presenter.save(animal, new DatabaseCallback() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onComplete(Object o) {

                    }

                    @Override
                    public void onComplete(List t) {

                        List<Animal> animals = ((List<Animal>) t);

                        Log.i("NewAnimalActivity"," name = ".concat(animals.get(0).getName()));
                        Log.i("NewAnimalActivity"," id = ".concat(String.valueOf(animals.get(0).getId())));

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void intiPresenter() {
        presenter = new NewAnimalPresenter(this);
    }
}
