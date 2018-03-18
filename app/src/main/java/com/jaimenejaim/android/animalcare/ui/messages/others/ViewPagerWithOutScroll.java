package com.jaimenejaim.android.animalcare.ui.messages.others;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by jaimenejaim on 18/03/2018.
 */

public class ViewPagerWithOutScroll extends ViewPager {

    private boolean isPagingEnabled = false;

    public ViewPagerWithOutScroll(Context context) {
        super(context);
    }

    public ViewPagerWithOutScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean isPagingEnabled) {
        this.isPagingEnabled = isPagingEnabled;
    }
}
