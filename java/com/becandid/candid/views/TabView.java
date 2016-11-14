package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class TabView extends RelativeLayout {
    protected ViewGroup b;
    protected boolean c;
    protected long d;

    public TabView(Context context) {
        super(context);
    }

    protected void setContentView(int resourceId) {
        setContentView(LayoutInflater.from(getContext()).inflate(resourceId, this, false));
    }

    protected void setContentView(View v) {
        this.b = (ViewGroup) v;
        addView(v);
        v.setLayoutParams(new LayoutParams(-1, -1));
    }

    public void a(Activity activity) {
    }

    public void b() {
    }

    public void a() {
        this.d = System.currentTimeMillis();
    }

    public void c() {
        if (!this.c) {
            this.c = true;
        }
    }

    public void a(int requestCode, int resultCode, Intent data) {
    }

    public void e() {
    }

    public void d() {
    }
}
