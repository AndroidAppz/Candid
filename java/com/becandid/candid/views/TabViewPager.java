package com.becandid.candid.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.becandid.candid.data.AppState;

public class TabViewPager extends ViewPager {
    private Context a;
    private String b;

    public TabViewPager(Context context) {
        super(context);
        this.a = context;
    }

    public TabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.b != null && this.b.equals("feed") && AppState.config.getInt("feed_swipe_enabled", 0) == 1) {
            return super.onInterceptTouchEvent(ev);
        }
        if (this.b != null && this.b.equals("me") && AppState.config.getInt("me_swipe_enabled", 0) == 1) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (AppState.config.getInt("feed_swipe_enabled", 0) == 0) {
            return super.onTouchEvent(ev);
        }
        if (this.b != null && this.b.equals("me") && AppState.config.getInt("me_swipe_enabled", 0) == 1) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    public void setCurrTab(String currTab) {
        this.b = currTab;
    }
}
