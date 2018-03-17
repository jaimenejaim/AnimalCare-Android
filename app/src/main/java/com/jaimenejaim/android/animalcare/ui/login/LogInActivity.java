package com.jaimenejaim.android.animalcare.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.FullScreenBaseActivity;

public class LogInActivity extends FullScreenBaseActivity implements LogInViewImpl {


    LogInPresenter presenter;

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_log_in);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setListeners();

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
                presenter.logIn(editTextEmail.getText().toString(),editTextPassword.getText().toString());
            }
        });

        editTextPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    return buttonLogin.performClick();
                }
                return false;
            }
        });
    }

    @Override
    public void setEmailError(String msg) {
        this.editTextEmail.setError(msg);
    }

    @Override
    public void setPasswordError(String msg) {
        this.editTextPassword.setError(msg);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void intiPresenter() {
        presenter = new LogInPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
