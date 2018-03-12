package com.jaimenejaim.android.animalcare.data.network.api;

import com.jaimenejaim.android.animalcare.BuildConfig;


/**
 * Created by jaimenejaim on 10/03/2018.
 */

public class Network {

    public static Service getAPIService() {
        return Client.getClient(BuildConfig.URL).create(Service.class);
    }
}
