package com.jaimenejaim.android.animalcare.ui.instructions;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.FullScreenBaseWithAnimationActivity;

public class InstructionsActivity extends FullScreenBaseWithAnimationActivity implements InstructionsViewImpl {

    private InstructionsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

    }

    @Override
    public void initComponents(View view) {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void intiPresenter() {
        presenter = new InstructionsPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
