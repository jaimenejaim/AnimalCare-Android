package com.jaimenejaim.android.animalcare.ui.evaluation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;

public class EvaluationActivity extends BaseActivity implements EvaluationViewImpl, EvaluationViewImpl.Activity {

    private Toolbar toolbar;
    private EvaluationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setConfigToolbar();
        setListeners();

    }

    public void intiPresenter() {
        presenter = new EvaluationPresenter(this);
    }

    @Override
    public Context getContext() {
        return null;
    }


    @Override
    public void initComponents(View view) {
        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public void setConfigToolbar(){
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
    }

    @Override
    public void setListeners() {
        toolbar.setNavigationOnClickListener(v -> EvaluationActivity.super.onBackPressed());
    }

}
