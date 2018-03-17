package com.jaimenejaim.android.animalcare.ui.my_animals;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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

        Breed breed = new Breed();
        breed.setDescription("Golden Retriever");

        Animal nick = new Animal();
        nick.setName("Nick");
        nick.setBreedId(0);
        nick.setBreed(breed);

        Animal ralph = new Animal();
        ralph.setName("Ralph");
        ralph.setBreedId(0);
        ralph.setBreed(breed);

        Animal zeus = new Animal();
        zeus.setName("Zeus");
        zeus.setBreedId(0);
        zeus.setBreed(breed);


        Animal vlademir = new Animal();
        vlademir.setName("Vlademir");
        vlademir.setBreedId(0);
        vlademir.setBreed(breed);

        Animal rarus = new Animal();
        rarus.setName("Rarus");
        rarus.setBreedId(0);
        rarus.setBreed(breed);

        Animal tick = new Animal();
        tick.setName("Tick");
        tick.setBreedId(0);
        tick.setBreed(breed);

        Animal bob = new Animal();
        bob.setName("Bob");
        bob.setBreedId(0);
        bob.setBreed(breed);

        Animal theo = new Animal();
        theo.setName("Theo");
        theo.setBreedId(0);
        theo.setBreed(breed);

        Animal luck = new Animal();
        luck.setName("Luck");
        luck.setBreedId(0);
        luck.setBreed(breed);

        Animal barney = new Animal();
        barney.setName("Barney");
        barney.setBreedId(0);
        barney.setBreed(breed);

        List<Animal> animals = new ArrayList<>();
        animals.add(nick);
        animals.add(ralph);
        animals.add(zeus);
        animals.add(vlademir);
        animals.add(rarus);
        animals.add(tick);
        animals.add(bob);
        animals.add(theo);
        animals.add(luck);
        animals.add(barney);


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
    public void intiPresenter() {

    }
}
