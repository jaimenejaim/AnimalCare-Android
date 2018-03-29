package com.jaimenejaim.android.animalcare.ui.settings;

import android.content.Context;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.User;
import com.jaimenejaim.android.animalcare.data.pref.Session;
import com.jaimenejaim.android.animalcare.ui.evaluation.EvaluationActivity;
import com.jaimenejaim.android.animalcare.ui.friend_care.FriendCareActivity;
import com.jaimenejaim.android.animalcare.ui.instructions.InstructionsActivity;
import com.jaimenejaim.android.animalcare.ui.my_account.MyAccountActivity;
import com.jaimenejaim.android.animalcare.ui.plans_payments.PlansPaymentsActivity;
import com.jaimenejaim.android.animalcare.ui.settings.others.Settings;
import com.jaimenejaim.android.animalcare.ui.settings.others.SettingsEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public class SettingsPresenter implements SettingsPresenterImpl {

    private SettingsViewImpl view;


    public SettingsPresenter(SettingsViewImpl view) {
        this.view = view;
        getProfileData();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }

    public void getProfileData(){
        User user = Session.get(getContext()).getUser();
        if(user != null){
            view.getTextViewProfileName().setText(user.getName());
        }
    }

    @Override
    public void logOut() {

        Session.destroy(getContext());
        view.finish();

    }

    @Override
    public List<Settings> loadSettings() {
        List<Settings> settings = new ArrayList<>();
        settings.add(new Settings(
                getContext().getString(R.string.settings_menu_account), SettingsEnum.ACCOUNT
        ));
        settings.add(new Settings(
                getContext().getString(R.string.settings_menu_care), SettingsEnum.ADOPT
        ));
        settings.add(new Settings(
                getContext().getString(R.string.settings_menu_payments), SettingsEnum.PAYMENTS
        ));
        settings.add(new Settings(
                getContext().getString(R.string.settings_menu_rating), SettingsEnum.EVALUATION
        ));
        settings.add(new Settings(
                getContext().getString(R.string.settings_menu_instructions), SettingsEnum.INSTRUCTIONS
        ));

        return settings;

    }

    @Override
    public void onItemClick(Settings settings) {
        switch (settings.getSettingsEnum()){
            case ACCOUNT:
                view.openActivity(new MyAccountActivity());
                break;

            case ADOPT:
                view.openActivity(new FriendCareActivity());
                break;

            case PAYMENTS:
                view.openActivity(new PlansPaymentsActivity());
                break;

            case EVALUATION:
                view.openActivity(new EvaluationActivity());
                break;

            case INSTRUCTIONS:
                view.openActivity(new InstructionsActivity());
                break;
        }
    }
}
