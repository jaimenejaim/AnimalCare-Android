package com.jaimenejaim.android.animalcare.ui.notification;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimenejaim.android.animalcare.R;


public class NotificationFragment extends Fragment implements NotificationViewImpl {

    private NotificationPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        return view;
    }


    @Override
    public void initComponents(View view) {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void intiPresenter() {
        presenter = new NotificationPresenter(this);
    }

    @Override
    public void finish() {
        getActivity().finish();
    }

}
