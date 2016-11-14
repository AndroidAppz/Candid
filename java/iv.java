/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.View
 *  butterknife.ButterKnife
 *  java.lang.Object
 */
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;

public class iv
extends RecyclerView.ViewHolder {
    protected View e;
    public Context f;

    public iv(View view) {
        super(view);
        this.e = view;
        ButterKnife.bind((Object)this, (View)view);
        this.f = view.getContext();
    }

    public iv(View view, Activity activity) {
        super(view);
        this.e = view;
        ButterKnife.bind((Object)this, (View)view);
        this.f = activity;
    }
}

