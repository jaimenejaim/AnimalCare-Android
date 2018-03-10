package com.jaimenejaim.android.animalcare.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jaimenejaim.android.animalcare.R;

public class LogInActivity extends AppCompatActivity implements LogInViewImpl {

    LogInPresenter presenter;

    EditText editTextEmail,editTextPassword;
    Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        buttonLogin = findViewById(R.id.buttonLogin);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        presenter = new LogInPresenter(this);



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
}
