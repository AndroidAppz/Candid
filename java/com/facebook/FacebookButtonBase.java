package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.appevents.AppEventsLogger;
import defpackage.bb;
import defpackage.um$a;
import defpackage.um$g;
import defpackage.vi;

public abstract class FacebookButtonBase extends Button {
    private String a;
    private String b;
    private OnClickListener c;
    private OnClickListener d;
    private boolean e;
    private int f;
    private int g;
    private vi h;

    public abstract int getDefaultRequestCode();

    public FacebookButtonBase(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, String analyticsButtonCreatedEventName, String analyticsButtonTappedEventName) {
        super(context, attrs, 0);
        if (defStyleRes == 0) {
            defStyleRes = getDefaultStyleResource();
        }
        if (defStyleRes == 0) {
            defStyleRes = um$g.com_facebook_button;
        }
        a(context, attrs, defStyleAttr, defStyleRes);
        this.a = analyticsButtonCreatedEventName;
        this.b = analyticsButtonTappedEventName;
        setClickable(true);
        setFocusable(true);
    }

    public void setFragment(Fragment fragment) {
        this.h = new vi(fragment);
    }

    public void setFragment(android.app.Fragment fragment) {
        this.h = new vi(fragment);
    }

    public Fragment getFragment() {
        return this.h != null ? this.h.b() : null;
    }

    public android.app.Fragment getNativeFragment() {
        return this.h != null ? this.h.a() : null;
    }

    public void setOnClickListener(OnClickListener l) {
        this.c = l;
    }

    public int getRequestCode() {
        return getDefaultRequestCode();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            a(getContext());
        }
    }

    public void onDraw(Canvas canvas) {
        boolean centered;
        if ((getGravity() & 1) != 0) {
            centered = true;
        } else {
            centered = false;
        }
        if (centered) {
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int compoundPaddingRight = getCompoundPaddingRight();
            int inset = Math.min((((getWidth() - (compoundPaddingLeft + getCompoundDrawablePadding())) - compoundPaddingRight) - a(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
            this.f = compoundPaddingLeft - inset;
            this.g = compoundPaddingRight + inset;
            this.e = true;
        }
        super.onDraw(canvas);
        this.e = false;
    }

    public int getCompoundPaddingLeft() {
        if (this.e) {
            return this.f;
        }
        return super.getCompoundPaddingLeft();
    }

    public int getCompoundPaddingRight() {
        if (this.e) {
            return this.g;
        }
        return super.getCompoundPaddingRight();
    }

    public Activity getActivity() {
        Context context = getContext();
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    public int getDefaultStyleResource() {
        return 0;
    }

    public int a(String text) {
        return (int) Math.ceil((double) getPaint().measureText(text));
    }

    public void a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        b(context, attrs, defStyleAttr, defStyleRes);
        c(context, attrs, defStyleAttr, defStyleRes);
        d(context, attrs, defStyleAttr, defStyleRes);
        e(context, attrs, defStyleAttr, defStyleRes);
        a();
    }

    public void a(View v) {
        if (this.c != null) {
            this.c.onClick(v);
        }
    }

    public void setInternalOnClickListener(OnClickListener l) {
        this.d = l;
    }

    private void a(Context context) {
        AppEventsLogger.a(context).a(this.a, null, null);
    }

    private void b(Context context) {
        AppEventsLogger.a(context).a(this.b, null, null);
    }

    private void b(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if (!isInEditMode()) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, new int[]{16842964}, defStyleAttr, defStyleRes);
            try {
                if (a.hasValue(0)) {
                    int backgroundResource = a.getResourceId(0, 0);
                    if (backgroundResource != 0) {
                        setBackgroundResource(backgroundResource);
                    } else {
                        setBackgroundColor(a.getColor(0, 0));
                    }
                } else {
                    setBackgroundColor(bb.getColor(context, um$a.com_facebook_blue));
                }
                a.recycle();
            } catch (Throwable th) {
                a.recycle();
            }
        }
    }

    @SuppressLint({"ResourceType"})
    private void c(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, defStyleAttr, defStyleRes);
        try {
            setCompoundDrawablesWithIntrinsicBounds(a.getResourceId(0, 0), a.getResourceId(1, 0), a.getResourceId(2, 0), a.getResourceId(3, 0));
            setCompoundDrawablePadding(a.getDimensionPixelSize(4, 0));
        } finally {
            a.recycle();
        }
    }

    private void d(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, new int[]{16842966, 16842967, 16842968, 16842969}, defStyleAttr, defStyleRes);
        try {
            setPadding(a.getDimensionPixelSize(0, 0), a.getDimensionPixelSize(1, 0), a.getDimensionPixelSize(2, 0), a.getDimensionPixelSize(3, 0));
        } finally {
            a.recycle();
        }
    }

    private void e(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray colorAttrs = context.getTheme().obtainStyledAttributes(attrs, new int[]{16842904}, defStyleAttr, defStyleRes);
        try {
            setTextColor(colorAttrs.getColorStateList(0));
            TypedArray gravityAttrs = context.getTheme().obtainStyledAttributes(attrs, new int[]{16842927}, defStyleAttr, defStyleRes);
            try {
                setGravity(gravityAttrs.getInt(0, 17));
                TypedArray a = context.getTheme().obtainStyledAttributes(attrs, new int[]{16842901, 16842903, 16843087}, defStyleAttr, defStyleRes);
                try {
                    setTextSize(0, (float) a.getDimensionPixelSize(0, 0));
                    setTypeface(Typeface.defaultFromStyle(a.getInt(1, 1)));
                    setText(a.getString(2));
                } finally {
                    a.recycle();
                }
            } finally {
                gravityAttrs.recycle();
            }
        } finally {
            colorAttrs.recycle();
        }
    }

    private void a() {
        super.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FacebookButtonBase a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.b(this.a.getContext());
                if (this.a.d != null) {
                    this.a.d.onClick(v);
                } else if (this.a.c != null) {
                    this.a.c.onClick(v);
                }
            }
        });
    }
}
