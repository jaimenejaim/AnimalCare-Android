package com.jaimenejaim.android.animalcare.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by jaimenejaim on 13/03/2018.
 */

public class DialogUtil {

    public static void showAlert(Activity activity, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialogInterface, n) -> {

        });
        builder.show();
    }

}
