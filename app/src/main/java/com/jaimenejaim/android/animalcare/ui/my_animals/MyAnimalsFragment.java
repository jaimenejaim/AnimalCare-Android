package com.jaimenejaim.android.animalcare.ui.my_animals;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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
import com.jaimenejaim.android.animalcare.ui.new_animal.NewAnimalActivity;


public class MyAnimalsFragment extends Fragment implements MyAnimalsViewImpl {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private FloatingActionButton buttonAdd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_animals, container, false);

        initComponents(view);
        setListeners();

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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initComponents(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView);
        buttonAdd = view.findViewById(R.id.buttonAdd);
    }

    @Override
    public void setListeners() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewAnimalActivity.class);
                startActivityForResult(intent, REQUEST_CODE_NEW_ANIMAL_ACTIVITY);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
