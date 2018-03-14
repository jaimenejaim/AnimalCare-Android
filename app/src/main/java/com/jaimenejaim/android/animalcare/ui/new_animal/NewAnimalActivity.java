package com.jaimenejaim.android.animalcare.ui.new_animal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;
import com.jaimenejaim.android.animalcare.utils.ActivityUtil;

public class NewAnimalActivity extends BaseActivity implements NewAnimalView {

    EditText editTextName, editTextBreed, editTextBirthDay;
    Spinner spinnerBreed;
    Button buttonSave;
    Toolbar toolbar;

    NewAnimalPresenter presenter;

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
                presenter.validate(editTextName.getText().toString(), 1, editTextBirthDay.getText().toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void intiPresenter() {
        presenter = new NewAnimalPresenterImpl(this, new NewAnimalInteractorImpl(this));
    }


    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setNameError() {
        editTextName.setError(getString(R.string.new_animal_edit_text_name_error));
    }

    @Override
    public void setBreedError() {
        editTextBreed.setError(getString(R.string.new_animal_breed_text_name_error));
    }

    @Override
    public void onSuccess() {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
    }

}
