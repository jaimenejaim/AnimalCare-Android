package com.jaimenejaim.android.animalcare.ui.signup;

import android.content.Context;
import android.util.Patterns;

import com.jaimenejaim.android.animalcare.R;

/**
 * Created by jaimenejaim on 17/03/2018.
 */

public class SignUpPresenter implements SignUpPresenterImpl {

    private SignUpVewImpl view;

    public SignUpPresenter(SignUpVewImpl view){
        this.view = view;
    }

    @Override
    public void signUp() {

        if(validate()) return;
        view.finish();
    }

    @Override
    public boolean validate() {

        if(view.getEditTextName().getText().toString().isEmpty()){
            view.getEditTextName().setError(
                    getContext().getString(R.string.sign_up_error_message_is_empty_name));
            return true;
        }

        if(view.getEditTextEmail().getText().toString().isEmpty()){
            view.getEditTextEmail().setError(
                    getContext().getString(R.string.sign_up_error_message_is_empty_email));
            return true;
        }


        if(!Patterns.EMAIL_ADDRESS.matcher(view.getEditTextEmail().getText().toString()).matches()){
            view.getEditTextEmail().setError(
                    getContext().getString(R.string.sign_up_error_message_invalid_email)
            );
            return true;
        }

        if(view.getEditTextPassword().getText().toString().isEmpty()){
            view.getEditTextPassword().setError(
                    getContext().getString(R.string.sign_up_error_message_is_empty_password)
            );
            return true;
        }

        if(view.getEditTextConfirmPassword().getText().toString().isEmpty()){
            view.getEditTextConfirmPassword().setError(
                    getContext().getString(R.string.sign_up_error_message_is_empty_confirm_password)
            );
            return true;
        }

        if(!view.getEditTextConfirmPassword().getText().toString()
                .equals(view.getEditTextPassword().getText().toString())){

            view.getEditTextPassword().setError(
                    getContext().getString(R.string.sign_up_error_message_does_not_match_password)
            );
            view.getEditTextConfirmPassword().setError(
                    getContext().getString(R.string.sign_up_error_message_does_not_match_password)
            );
            return true;
        }

        return false;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }
}
