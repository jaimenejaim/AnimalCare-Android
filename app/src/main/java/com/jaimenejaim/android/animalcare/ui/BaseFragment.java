package com.jaimenejaim.android.animalcare.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.jaimenejaim.android.animalcare.utils.ActivityUtil;

/**
 * Created by Jaime Nascimento Nejaim on 3/14/2018.
 */

@SuppressLint("Registered")
public class BaseFragment extends Fragment {


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        ActivityUtil.overridePendingTransitionEnter(getActivity());
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        ActivityUtil.overridePendingTransitionEnter(getActivity());
    }

}
