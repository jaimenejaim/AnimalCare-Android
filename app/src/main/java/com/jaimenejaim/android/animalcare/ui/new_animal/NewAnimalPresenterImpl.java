package com.jaimenejaim.android.animalcare.ui.new_animal;

/**
 * Created by Jaime Nascimento Nejaim on 3/12/2018.
 */

public class NewAnimalPresenterImpl implements NewAnimalPresenter, NewAnimalInteractor.OnLoginFinishedListener {

    private NewAnimalView newAnimalView;
    private NewAnimalInteractor interactor;

    public NewAnimalPresenterImpl(NewAnimalView newAnimalView, NewAnimalInteractor interactor){
        this.newAnimalView = newAnimalView;
        this.interactor = interactor;
    }


    @Override
    public void onDestroy() {
        this.newAnimalView = null;
        this.interactor = null;
    }

    @Override
    public void validate(String name, long breedId, String birthday) {

        if(name.isEmpty()){
            setNameError();
            return;
        }

        if(breedId == 0){
            setBreedError();
            return;
        }


        interactor.save(name, breedId, birthday, this);
    }

    @Override
    public void setNameError() {
        if (newAnimalView != null) newAnimalView.setNameError();
    }
    @Override
    public void setBreedError() {
        if (newAnimalView != null)  newAnimalView.setBreedError();
    }
    @Override
    public void onSuccess() {
        if (newAnimalView != null) newAnimalView.onSuccess();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }


}
