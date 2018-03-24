package com.jaimenejaim.android.animalcare.ui.my_animals;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.ui.BaseFragment;
import com.jaimenejaim.android.animalcare.ui.my_animals.adapters.MyAnimalsRecyclerAdapter;
import com.jaimenejaim.android.animalcare.ui.my_animals.others.DividerItemDecotation;
import com.jaimenejaim.android.animalcare.ui.my_animals_detail.MyAnimalsDetailActivity;
import com.jaimenejaim.android.animalcare.ui.new_animal.NewAnimalActivity;

import java.util.ArrayList;
import java.util.List;


public class MyAnimalsFragment extends BaseFragment implements MyAnimalsViewImpl {


    private MyAnimalsPresenter presenter;
    private RecyclerView mRecyclerView;
    private MyAnimalsRecyclerAdapter mAdapter;
    private FloatingActionButton buttonAdd;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mTextViewNotFoundData;


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

        fetchDataOnRecyclerListView(new ArrayList<>());
        presenter.defaultData();
        presenter.getMyAnimals(0);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initComponents(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView);
        buttonAdd = view.findViewById(R.id.buttonAdd);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        mTextViewNotFoundData = view.findViewById(R.id.textViewNotFoundData);
    }

    @Override
    public void setListeners() {

        buttonAdd.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), NewAnimalActivity.class);
            startActivityForResult(intent, REQUEST_CODE_NEW_ANIMAL_ACTIVITY);
        });

        mAdapter.setOnItemClickListener(item -> {
            Intent intent = new Intent(getActivity(), MyAnimalsDetailActivity.class);
            intent.putExtra("animal",item);
            startActivityForResult(intent, REQUEST_CODE_DETAIL_ANIMAL_ACTIVITY);
        });

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            presenter.onRefresh();
        });

    }


    @Override
    public void intiPresenter() {
        presenter = new MyAnimalsPresenter(this);
    }

    @Override
    public void finish() {
        getActivity().finish();
    }

    @Override
    public void loadMyAnimals(int page) {
        presenter.getMyAnimals(page);
    }

    @Override
    public void fetchDataOnRecyclerListView(List<Animal> animals){
        mAdapter = new MyAnimalsRecyclerAdapter(animals);
        mRecyclerView.addItemDecoration(new DividerItemDecotation(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onSwipe(){

    }

    @Override
    public void setVisibilityLoadIndicator(boolean enabled){
        mSwipeRefreshLayout.setRefreshing(enabled);
    }

    @Override
    public void setOnLoadNotFoundData(){
        setTextViewNotFoundDataVisibility(View.VISIBLE);
    }

    @Override
    public void setTextViewNotFoundDataVisibility(int visibility){
        mTextViewNotFoundData.setVisibility(visibility);
    }

//    public void onLoadMore(){
////        presenter.onLoadMore();
//    }

}
