package com.becandid.candid.views;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

public class EndlessScrollView extends NestedScrollView {
    private a a;

    public interface a {
        void a(EndlessScrollView endlessScrollView, int i, int i2, int i3, int i4);
    }

    public EndlessScrollView(Context context) {
        super(context);
    }

    public EndlessScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EndlessScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollViewListener(a endlessScrollListener) {
        this.a = endlessScrollListener;
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (this.a != null) {
            this.a.a(this, l, t, oldl, oldt);
        }
    }
}
