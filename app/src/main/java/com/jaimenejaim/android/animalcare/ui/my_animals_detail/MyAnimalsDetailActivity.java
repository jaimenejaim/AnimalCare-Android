package com.jaimenejaim.android.animalcare.ui.my_animals_detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;
import com.jaimenejaim.android.animalcare.ui.my_animals.others.DividerItemDecotation;
import com.jaimenejaim.android.animalcare.ui.my_animals_detail.adapters.MyAnimalsDetailSettingsAdapter;

public class MyAnimalsDetailActivity extends BaseActivity implements MyAnimalsDetailsViewImpl {

    private MyAnimalsDetailsPresenter presenter;

    private Toolbar toolbar;
    private Animal animal;
    private RecyclerView recyclerViewAnimalDetail;
    private MyAnimalsDetailSettingsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_animals_detail);

        animal = getAnimalFromExtra(getIntent());

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setConfigToolbar();
        configRecyclerView();
        setListeners();


    }

    @Override
    public void initComponents(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        recyclerViewAnimalDetail = view.findViewById(R.id.recyclerViewAnimalDetail);
    }

    @Override
    public void setListeners() {
        toolbar.setNavigationOnClickListener(v -> MyAnimalsDetailActivity.super.onBackPressed());
        mAdapter.setOnItemClickListener(item -> presenter.onItemClick(item));
    }

    @Override
    public void intiPresenter() {
        presenter = new MyAnimalsDetailsPresenter(this);
    }

    public void configRecyclerView(){

        mAdapter = new MyAnimalsDetailSettingsAdapter(presenter.loadSettings());
        recyclerViewAnimalDetail.addItemDecoration(new DividerItemDecotation(getContext()));
        recyclerViewAnimalDetail.setAdapter(mAdapter);
        recyclerViewAnimalDetail.setItemAnimator(new DefaultItemAnimator());
        recyclerViewAnimalDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Animal getAnimalFromExtra(Intent intent) {
        return intent.getParcelableExtra("animal");
    }

    @Override
    public void setConfigToolbar() {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setTitle(animal.getName());
        setSupportActionBar(toolbar);
    }

    @Override
    public void openActivity(Object activity) {
        Intent intent = new Intent(getContext(), activity.getClass());
        startActivity(intent);
    }
}
