package com.jaimenejaim.android.animalcare.ui.signin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.FullScreenBaseWithAnimationActivity;
import com.jaimenejaim.android.animalcare.ui.signup.SignUpActivity;

public class SignInActivity extends FullScreenBaseWithAnimationActivity implements SignInViewImpl {


    SignInPresenter presenter;

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_sign_in);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setListeners();

    }

    @Override
    public void initComponents(View view) {
        buttonLogin = view.findViewById(R.id.buttonLogin);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        textViewSignUp = view.findViewById(R.id.textViewSignUp);
    }

    @Override
    public void setListeners() {
        buttonLogin.setOnClickListener(view ->
                presenter.logIn(editTextEmail.getText().toString(),editTextPassword.getText().toString()));

        editTextPassword.setOnKeyListener((view, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                return buttonLogin.performClick();
            }
            return false;
        });

        textViewSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public EditText getEditTextEmail(){
        return this.editTextEmail;
    }

    @Override
    public EditText getEditTextPassword(){
        return this.editTextPassword;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void intiPresenter() {
        presenter = new SignInPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void openActivity(Object activity) {
        Intent intent = new Intent(getContext(), activity.getClass());
        startActivity(intent);
    }

    @Override
    public void finish(){
        super.finish();
    }
}
