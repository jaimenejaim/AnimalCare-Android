package com.jaimenejaim.android.animalcare.ui.my_animals;

import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.ui.PresenterImpl;

import java.util.List;
import java.util.Observable;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface MyAnimalsPresenterImpl extends PresenterImpl {
    void getMyAnimals(int page);
    void onRefresh();
    void onLoadMore(int page);
    void defaultData();
}
