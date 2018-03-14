package com.jaimenejaim.android.animalcare.ui.my_animals;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Breed;
import com.jaimenejaim.android.animalcare.ui.BaseFragment;
import com.jaimenejaim.android.animalcare.ui.my_animals.adapters.MyAnimalsRecyclerAdapter;
import com.jaimenejaim.android.animalcare.ui.my_animals.others.DividerItemDecotation;
import com.jaimenejaim.android.animalcare.ui.my_animals_detail.MyAnimalsDetailActivity;
import com.jaimenejaim.android.animalcare.ui.new_animal.NewAnimalActivity;
import com.jaimenejaim.android.animalcare.utils.ActivityUtil;

import java.util.ArrayList;
import java.util.List;


public class MyAnimalsFragment extends BaseFragment implements MyAnimalsViewImpl {


    private static final String TAG = MyAnimalsFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private MyAnimalsRecyclerAdapter mAdapter;
    private FloatingActionButton buttonAdd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_animals, container, false);

        intiPresenter();
        initComponents(view);
        configRecyclerView();
        setListeners();



        return view;
    }

    public void configRecyclerView(){

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Nick","",0));
        animals.add(new Animal("Ralph","",0));
        animals.add(new Animal("Zeus","",0));
        animals.add(new Animal("Vlademir","",0));
        animals.add(new Animal("Rarus","",0));
        animals.add(new Animal("Tick","",0));
        animals.add(new Animal("Bob","",0));
        animals.add(new Animal("Theo","",0));
        animals.add(new Animal("Luck","",0));
        animals.add(new Animal("Mito","",0));


        mAdapter = new MyAnimalsRecyclerAdapter(animals);
        mRecyclerView.addItemDecoration(new DividerItemDecotation(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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

        mAdapter.setOnItemClickListener(new MyAnimalsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Animal item) {
                Log.i(TAG, "name = ".concat(item.getName()));
                Intent intent = new Intent(getActivity(), MyAnimalsDetailActivity.class);
                intent.putExtra("animal",item);
                startActivityForResult(intent, REQUEST_CODE_DETAIL_ANIMAL_ACTIVITY);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void intiPresenter() {

    }
}
