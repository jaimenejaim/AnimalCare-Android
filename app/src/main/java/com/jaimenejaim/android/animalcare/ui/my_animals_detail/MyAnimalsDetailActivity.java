package com.jaimenejaim.android.animalcare.ui.my_animals_detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;

public class MyAnimalsDetailActivity extends BaseActivity implements MyAnimalsDetailsViewImpl {


    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_animals_detail);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
