package com.jaimenejaim.android.animalcare.ui.signup;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.FullScreenBaseWithAnimationActivity;

public class SignUpActivity extends FullScreenBaseWithAnimationActivity implements SignUpVewImpl {

    SignUpPresenter presenter;
    LinearLayout buttonBack;
    EditText editTextName, editTextEmail, editTextPassword, editTextConfirmPassword;
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setListeners();

    }

    @Override
    public void initComponents(View view) {
        buttonBack = view.findViewById(R.id.buttonBack);
        editTextName = view.findViewById(R.id.editTextName);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextConfirmPassword = view.findViewById(R.id.editTextConfirmPassword);
        buttonSignUp = view.findViewById(R.id.buttonSignUp);
    }

    @Override
    public void setListeners() {
        buttonBack.setOnClickListener(view -> {
            onBackPressed();
        });

        buttonSignUp.setOnClickListener(view -> {
            presenter.signUp();
        });

        editTextConfirmPassword.setOnKeyListener((view, keyCode, event) -> {
            if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                return buttonSignUp.performClick();
            }
            return false;
        });
    }

    @Override
    public void intiPresenter() {
        presenter = new SignUpPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public EditText getEditTextName() {
        return this.editTextName;
    }

    @Override
    public EditText getEditTextEmail() {
        return this.editTextEmail;
    }

    @Override
    public EditText getEditTextPassword() {
        return this.editTextPassword;
    }

    @Override
    public EditText getEditTextConfirmPassword() {
        return this.editTextConfirmPassword;
    }

    @Override
    public void finish(){
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
