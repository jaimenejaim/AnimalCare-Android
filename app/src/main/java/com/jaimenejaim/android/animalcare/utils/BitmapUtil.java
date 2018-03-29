package com.jaimenejaim.android.animalcare.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;

/**
 * Created by jaimenejaim on 28/03/2018.
 */

public class BitmapUtil {

    public static Bitmap decodeBitmap(byte[] b) throws FileNotFoundException {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        BitmapFactory.decodeStream(bis, null, o);

        final int REQUIRED_SIZE = 100;

        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(bis, null, o2);
    }

}
