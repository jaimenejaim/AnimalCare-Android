package com.jaimenejaim.android.animalcare.utils;

import retrofit2.HttpException;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

public class NetworkUtil {
    /**
     * Returns true if the Throwable is an instance of RetrofitError with an
     * http status code equals to the given one.
     */
    public static boolean isHttpStatusCode(Throwable throwable, int statusCode) {
        return throwable instanceof HttpException
                && ((HttpException) throwable).code() == statusCode;
    }
}
