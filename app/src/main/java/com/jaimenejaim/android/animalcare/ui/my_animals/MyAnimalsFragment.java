package com.jaimenejaim.android.animalcare.ui.my_animals;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.my_animals.adapters.MyAnimalsRecyclerAdapter;
import com.jaimenejaim.android.animalcare.ui.my_animals.others.DividerItemDecotation;


public class MyAnimalsFragment extends Fragment implements MyAnimalsViewImpl {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_animals, container, false);


        mRecyclerView = view.findViewById(R.id.recyclerView);

        String[] title = {

                "Nick",
                "Ralph",
                "Zeus",
                "Vlademir",
                "Rarus",
                "tick",
                "bob",
                "theo",
                "Luck",
                "mito"

        };

        mAdapter = new MyAnimalsRecyclerAdapter(getContext(), title);
        mRecyclerView.addItemDecoration(new DividerItemDecotation(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }





}
