package com.jaimenejaim.android.animalcare.data.persistence.callback;

import java.util.List;

/**
 * Created by jaimenejaim on 12/03/2018.
 */

public interface DatabaseCallback<T> {

    void onComplete();
    void onComplete(T t);
    void onComplete(List<T> t);
    void onError(Throwable e);

}
