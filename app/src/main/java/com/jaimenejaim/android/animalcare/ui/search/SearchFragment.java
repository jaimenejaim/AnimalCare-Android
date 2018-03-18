package com.jaimenejaim.android.animalcare.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimenejaim.android.animalcare.R;


public class SearchFragment extends Fragment  implements SearchViewImpl {

    private SearchPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

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
        presenter = new SearchPresenter(this);
    }

    @Override
    public void finish() {

    }

    @Override
    public Context getContext() {
        return super.getContext();
    }
}
