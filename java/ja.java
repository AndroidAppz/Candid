/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.GradientDrawable
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ja
extends iv {
    public TextView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public ImageView g;
    public TextView h;
    public ImageView i;
    public GradientDrawable j;
    public RelativeLayout k;
    public TextView l;
    public FrameLayout m;

    public ja(View view) {
        super(view);
        this.a = (TextView)view.findViewById(2131624546);
        this.b = (TextView)view.findViewById(2131624548);
        this.c = (ImageView)view.findViewById(2131624551);
        this.d = (TextView)view.findViewById(2131624552);
        this.g = (ImageView)view.findViewById(2131624545);
        this.h = (TextView)view.findViewById(2131624544);
        this.i = (ImageView)view.findViewById(2131624550);
        this.j = new GradientDrawable();
        this.k = (RelativeLayout)view.findViewById(2131624541);
        this.l = (TextView)view.findViewById(2131624553);
        this.m = (FrameLayout)view.findViewById(2131624549);
    }
}

