package com.jaimenejaim.android.animalcare.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.BaseActivity;
import com.jaimenejaim.android.animalcare.ui.home.adapters.HomeViewPagerAdapter;
import com.jaimenejaim.android.animalcare.ui.messages.MessagesFragment;
import com.jaimenejaim.android.animalcare.ui.my_animals.MyAnimalsFragment;
import com.jaimenejaim.android.animalcare.ui.settings.SettingsFragment;

public class HomeActivity extends BaseActivity implements HomeViewImpl {

    private HomePresenter presenter;

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intiPresenter();
        initComponents(findViewById(android.R.id.content));
        setListeners();

        setupViewPager(viewPager);

    }

    @Override
    public void initComponents(View view) {
        viewPager = view.findViewById(R.id.viewpager);
        bottomNavigationView = view.findViewById(R.id.bottom_nav);
    }

    @Override
    public void setListeners() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {


            switch (item.getItemId()) {
                case R.id.bottombaritem_settings:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.bottombaritem_animals:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.bottombaritem_message:
                    viewPager.setCurrentItem(2);
                    return true;

            }
            return false;
        });

        viewPager.postDelayed(() -> viewPager.setCurrentItem(1, false), 2000);
    }




    private void setupViewPager(ViewPager viewPager) {
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SettingsFragment(), "settings");
        adapter.addFrag(new MyAnimalsFragment(), "my_animals");
        adapter.addFrag(new MessagesFragment(), "messages");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void intiPresenter() {
        presenter = new HomePresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
