package com.jaimenejaim.android.animalcare.ui.my_animals_detail;

import android.content.Context;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.events.EventsActivity;
import com.jaimenejaim.android.animalcare.ui.my_animals_detail.others.MyAnimalsDetailSettings;
import com.jaimenejaim.android.animalcare.ui.queries.QueriesActivity;
import com.jaimenejaim.android.animalcare.ui.vaccination_card.VaccinationCardActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaimenejaim on 13/03/2018.
 */

public class MyAnimalsDetailsPresenter implements MyAnimalsDetailsPresenterImpl {

    private MyAnimalsDetailsViewImpl view;

    public MyAnimalsDetailsPresenter(MyAnimalsDetailsViewImpl view){
        this.view = view;
    }

    @Override
    public void onDestroy() {}

    public List<MyAnimalsDetailSettings> loadSettings() {
        List<MyAnimalsDetailSettings> settings = new ArrayList<>();
        settings.add(new MyAnimalsDetailSettings(
                getContext().getString(R.string.my_naimal_details_settings_menu_vaccination_card), MyAnimalSettingsEnum.VACCINATION_CARD
        ));
        settings.add(new MyAnimalsDetailSettings(
                getContext().getString(R.string.my_naimal_details_settings_menu_medicines), MyAnimalSettingsEnum.MEDICINES
        ));
        settings.add(new MyAnimalsDetailSettings(
                getContext().getString(R.string.my_naimal_details_settings_menu_events), MyAnimalSettingsEnum.EVENTS
        ));
        settings.add(new MyAnimalsDetailSettings(
                getContext().getString(R.string.my_naimal_details_settings_menu_query), MyAnimalSettingsEnum.QUERY
        ));

        return settings;

    }


    @Override
    public void onItemClick(MyAnimalsDetailSettings settings) {
        switch (settings.getSettingsEnum()){
            case VACCINATION_CARD:
                view.openActivity(new VaccinationCardActivity());
                break;

//            case MEDICINES:
//                view.openActivity(new Medici());
//                break;

            case EVENTS:
                view.openActivity(new EventsActivity());
                break;

            case QUERY:
                view.openActivity(new QueriesActivity());
                break;

        }
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }
}
