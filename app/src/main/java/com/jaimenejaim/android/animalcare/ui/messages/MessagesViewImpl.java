package com.jaimenejaim.android.animalcare.ui.messages;

import com.jaimenejaim.android.animalcare.ui.ViewImpl;
import com.jaimenejaim.android.animalcare.ui.messages.adapters.MessagesPagerAdapter;
import com.jaimenejaim.android.animalcare.ui.messages.others.ViewPagerWithOutScroll;

/**
 * Created by jaimenejaim on 09/03/2018.
 */

public interface MessagesViewImpl extends ViewImpl {
    void configAdapter();
    void configViewPager(MessagesPagerAdapter adapter);
    void configTabLayout(ViewPagerWithOutScroll viewPager);
}
