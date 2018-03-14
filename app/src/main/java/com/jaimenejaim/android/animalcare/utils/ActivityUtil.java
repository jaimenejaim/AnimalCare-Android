package com.jaimenejaim.android.animalcare.utils;

import android.app.Activity;

import com.jaimenejaim.android.animalcare.R;

/**
 * Created by Jaime Nascimento Nejaim on 3/14/2018.
 */

public class ActivityUtil {

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    public static void overridePendingTransitionEnter(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    public static void overridePendingTransitionExit(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

}
