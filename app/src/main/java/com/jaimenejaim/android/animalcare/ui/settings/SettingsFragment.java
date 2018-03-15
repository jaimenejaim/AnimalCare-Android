package com.jaimenejaim.android.animalcare.ui.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimenejaim.android.animalcare.R;


public class SettingsFragment extends Fragment implements SettingsViewImpl {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        intiPresenter();
        initComponents(view);
        setListeners();

        return view;
    }


    @Override
    public void initComponents(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void intiPresenter() {

    }
}
