package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import defpackage.um$c;
import defpackage.um$d;
import defpackage.um$e;
import java.lang.ref.WeakReference;

public class ToolTipPopup {
    private final String a;
    private final WeakReference<View> b;
    private final Context c;
    private a d;
    private PopupWindow e;
    private Style f = Style.BLUE;
    private long g = 6000;
    private final OnScrollChangedListener h = new OnScrollChangedListener(this) {
        final /* synthetic */ ToolTipPopup a;

        {
            this.a = this$0;
        }

        public void onScrollChanged() {
            if (this.a.b.get() != null && this.a.e != null && this.a.e.isShowing()) {
                if (this.a.e.isAboveAnchor()) {
                    this.a.d.b();
                } else {
                    this.a.d.a();
                }
            }
        }
    };

    public enum Style {
        BLUE,
        BLACK
    }

    class a extends FrameLayout {
        final /* synthetic */ ToolTipPopup a;
        private ImageView b;
        private ImageView c;
        private View d;
        private ImageView e;

        public a(ToolTipPopup toolTipPopup, Context context) {
            this.a = toolTipPopup;
            super(context);
            c();
        }

        private void c() {
            LayoutInflater.from(getContext()).inflate(um$e.com_facebook_tooltip_bubble, this);
            this.b = (ImageView) findViewById(um$d.com_facebook_tooltip_bubble_view_top_pointer);
            this.c = (ImageView) findViewById(um$d.com_facebook_tooltip_bubble_view_bottom_pointer);
            this.d = findViewById(um$d.com_facebook_body_frame);
            this.e = (ImageView) findViewById(um$d.com_facebook_button_xout);
        }

        public void a() {
            this.b.setVisibility(0);
            this.c.setVisibility(4);
        }

        public void b() {
            this.b.setVisibility(4);
            this.c.setVisibility(0);
        }
    }

    public ToolTipPopup(String text, View anchor) {
        this.a = text;
        this.b = new WeakReference(anchor);
        this.c = anchor.getContext();
    }

    public void a(Style mStyle) {
        this.f = mStyle;
    }

    public void a() {
        if (this.b.get() != null) {
            this.d = new a(this, this.c);
            ((TextView) this.d.findViewById(um$d.com_facebook_tooltip_bubble_view_text_body)).setText(this.a);
            if (this.f == Style.BLUE) {
                this.d.d.setBackgroundResource(um$c.com_facebook_tooltip_blue_background);
                this.d.c.setImageResource(um$c.com_facebook_tooltip_blue_bottomnub);
                this.d.b.setImageResource(um$c.com_facebook_tooltip_blue_topnub);
                this.d.e.setImageResource(um$c.com_facebook_tooltip_blue_xout);
            } else {
                this.d.d.setBackgroundResource(um$c.com_facebook_tooltip_black_background);
                this.d.c.setImageResource(um$c.com_facebook_tooltip_black_bottomnub);
                this.d.b.setImageResource(um$c.com_facebook_tooltip_black_topnub);
                this.d.e.setImageResource(um$c.com_facebook_tooltip_black_xout);
            }
            View decorView = ((Activity) this.c).getWindow().getDecorView();
            int decorWidth = decorView.getWidth();
            int decorHeight = decorView.getHeight();
            d();
            this.d.measure(MeasureSpec.makeMeasureSpec(decorWidth, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(decorHeight, Integer.MIN_VALUE));
            this.e = new PopupWindow(this.d, this.d.getMeasuredWidth(), this.d.getMeasuredHeight());
            this.e.showAsDropDown((View) this.b.get());
            c();
            if (this.g > 0) {
                this.d.postDelayed(new Runnable(this) {
                    final /* synthetic */ ToolTipPopup a;

                    {
                        this.a = this$0;
                    }

                    public void run() {
                        this.a.b();
                    }
                }, this.g);
            }
            this.e.setTouchable(true);
            this.d.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ToolTipPopup a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    this.a.b();
                }
            });
        }
    }

    public void a(long displayTime) {
        this.g = displayTime;
    }

    private void c() {
        if (this.e != null && this.e.isShowing()) {
            if (this.e.isAboveAnchor()) {
                this.d.b();
            } else {
                this.d.a();
            }
        }
    }

    public void b() {
        e();
        if (this.e != null) {
            this.e.dismiss();
        }
    }

    private void d() {
        e();
        if (this.b.get() != null) {
            ((View) this.b.get()).getViewTreeObserver().addOnScrollChangedListener(this.h);
        }
    }

    private void e() {
        if (this.b.get() != null) {
            ((View) this.b.get()).getViewTreeObserver().removeOnScrollChangedListener(this.h);
        }
    }
}
