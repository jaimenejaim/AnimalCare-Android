package com.jaimenejaim.android.animalcare.ui.messages.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.chat.ChatFragment;
import com.jaimenejaim.android.animalcare.ui.notification.NotificationFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaimenejaim on 18/03/2018.
 */

public class MessagesPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<Fragment> fragments;

    public MessagesPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        initFragmentList();
        loadFragments();

    }

    private void initFragmentList(){
        fragments = new ArrayList<>();
    }

    private void loadFragments(){
        fragments.add(new NotificationFragment());
        fragments.add(new ChatFragment());
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return fragments.size();
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position


        if(getItem(position).getClass().getSimpleName().equals(NotificationFragment.class.getSimpleName()))
            return mContext.getString(R.string.messages_pager_adapter_notifications);
        if(getItem(position).getClass().getSimpleName().equals(ChatFragment.class.getSimpleName()))
            return mContext.getString(R.string.messages_pager_adapter_chat);
        else
            return null;
    }

}