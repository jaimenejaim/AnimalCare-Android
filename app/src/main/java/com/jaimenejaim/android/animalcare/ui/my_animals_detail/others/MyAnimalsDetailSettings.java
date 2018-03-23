package com.jaimenejaim.android.animalcare.ui.my_animals_detail.others;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.jaimenejaim.android.animalcare.ui.my_animals_detail.MyAnimalSettingsEnum;

/**
 * Created by jaimenejaim on 20/03/2018.
 */

public class MyAnimalsDetailSettings {

    private Drawable drawableLeftIcon;
    private String title;
    private ImageView imageViewButton;
    private MyAnimalSettingsEnum settingsEnum;

    public MyAnimalsDetailSettings(String title, MyAnimalSettingsEnum settingsEnum) {
        this.title = title;
        this.settingsEnum = settingsEnum;
    }

    public Drawable getDrawableLeftIcon() {
        return drawableLeftIcon;
    }
    public void setDrawableLeftIcon(Drawable drawableLeftIcon) {
        this.drawableLeftIcon = drawableLeftIcon;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public ImageView getImageViewButton() {
        return imageViewButton;
    }
    public void setImageViewButton(ImageView imageViewButton) {
        this.imageViewButton = imageViewButton;
    }

    public MyAnimalSettingsEnum getSettingsEnum() {
        return settingsEnum;
    }
    public void setSettingsEnum(MyAnimalSettingsEnum settingsEnum) {
        this.settingsEnum = settingsEnum;
    }

}
