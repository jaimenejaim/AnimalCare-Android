package com.jaimenejaim.android.animalcare.ui.messages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimenejaim.android.animalcare.R;


public class MessagesFragment extends Fragment implements MessagesViewImpl {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void initComponents(View view) {

    }

    @Override
    public void setListeners() {

    }
}