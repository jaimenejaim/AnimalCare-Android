package com.jaimenejaim.android.animalcare.ui.messages;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.messages.adapters.MessagesPagerAdapter;
import com.jaimenejaim.android.animalcare.ui.messages.others.ViewPagerWithOutScroll;


public class MessagesFragment extends Fragment implements MessagesViewImpl {


    private TabLayout tabLayout;
    private ViewPagerWithOutScroll viewPager;
    private MessagesPagerAdapter mAdapter;
    private MessagesPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_messages, container, false);


        intiPresenter();
        initComponents(view);
        setListeners();
        configAdapter();
        configViewPager(mAdapter);
        configTabLayout(viewPager);

        return view;
    }

    @Override
    public void configAdapter() {
        mAdapter = new MessagesPagerAdapter(getContext(), getActivity().getSupportFragmentManager());
    }


    // Set the adapter onto the view pager
    @Override
    public void configViewPager(MessagesPagerAdapter adapter) {
        viewPager.setAdapter(mAdapter);
    }

    @Override
    public void configTabLayout(ViewPagerWithOutScroll viewPager) {
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void initComponents(View view) {
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.sliding_tabs);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void intiPresenter() {
        presenter = new MessagesPresenter(this);
    }

    @Override
    public void finish() {
        getActivity().finish();
    }

    public Context getContext(){
        return super.getContext();
    }


}
