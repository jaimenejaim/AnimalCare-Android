package com.jaimenejaim.android.animalcare.data.persistence.entity;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by jaimenejaim on 18/03/2018.
 */

public class Settings {

    private Drawable drawableLeftIcon;
    private String title;
    private ImageView imageViewButton;
    private SettingsEnum settingsEnum;


    public Settings(){}


    public Settings(String title, SettingsEnum settingsEnum) {
        this.drawableLeftIcon = drawableLeftIcon;
        this.title = title;
        this.imageViewButton = imageViewButton;
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

    public SettingsEnum getSettingsEnum() {
        return settingsEnum;
    }
    public void setSettingsEnum(SettingsEnum settingsEnum) {
        this.settingsEnum = settingsEnum;
    }
}
