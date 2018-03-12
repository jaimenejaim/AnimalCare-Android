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

        initComponents(findViewById(android.R.id.content));
        setListeners();

        presenter = new LogInPresenter(this);

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
}
