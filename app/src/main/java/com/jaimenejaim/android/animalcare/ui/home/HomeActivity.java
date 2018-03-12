package com.jaimenejaim.android.animalcare.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.messages.MessagesFragment;
import com.jaimenejaim.android.animalcare.ui.my_animals.MyAnimalsFragment;
import com.jaimenejaim.android.animalcare.ui.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeViewImpl {


    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
                    }
                });

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
    }




    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SettingsFragment(), "settings");
        adapter.addFrag(new MyAnimalsFragment(), "my_animals");
        adapter.addFrag(new MessagesFragment(), "messages");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            // return null to display only the icon
            return null;
        }
    }

}
