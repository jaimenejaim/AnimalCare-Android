package com.jaimenejaim.android.animalcare.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.seed.BreedSeed;

public class LogInActivity extends AppCompatActivity implements LogInViewImpl {


    LogInPresenter presenter;

    EditText editTextEmail,editTextPassword;
    Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        setContentView(R.layout.activity_log_in);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setListeners();

        //create breed if not exists
        new BreedSeed(this).create();


    }

    @Override
    public void initComponents(View view) {
        buttonLogin = view.findViewById(R.id.buttonLogin);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);

    }

    @Override
    public void setListeners() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn(editTextEmail.getText().toString(),editTextPassword.getText().toString());
            }
        });
    }

    @Override
    public void logIn(String email, String password) {
        presenter.logIn(email,password);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void intiPresenter() {
        presenter = new LogInPresenter(this);
    }
}
