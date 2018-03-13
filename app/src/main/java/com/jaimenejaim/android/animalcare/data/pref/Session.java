package com.jaimenejaim.android.animalcare.data.pref;

import android.content.Context;

import com.jaimenejaim.android.animalcare.data.persistence.entity.Auth;
import com.orhanobut.hawk.Hawk;

/**
 * Created by jaimenejaim on 10/03/2018.
 */

public class Session {

    private static final String KEY = "session";

    /*
    * Save object from @Param Auth in disk referenced by KEY
    * */
    public static void make(Context context, Auth object){
        Hawk.init(context).build();
        Hawk.put(KEY, object);

    }

    /*
    * Return current saved Auth in KEY.
    * */
    public static Auth get(Context context){
        Hawk.init(context).build();
        return Hawk.get(KEY);
    }

    /*
    * Destroy from disk current Auth saved in KEY.
    * */
    public static void destroy(Context context){
        Hawk.init(context).build();
        if(Hawk.contains(KEY)) {
            Hawk.delete(KEY);
        }
    }

}
