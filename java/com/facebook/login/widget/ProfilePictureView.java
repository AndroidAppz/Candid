package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import defpackage.ev;
import defpackage.um$b;
import defpackage.um$c;
import defpackage.um$h;
import defpackage.vj;
import defpackage.vk;
import defpackage.vk$a;
import defpackage.vk$b;
import defpackage.vl;
import defpackage.vp;
import defpackage.vw;

public class ProfilePictureView extends FrameLayout {
    public static final String a = ProfilePictureView.class.getSimpleName();
    private String b;
    private int c = 0;
    private int d = 0;
    private boolean e = true;
    private Bitmap f;
    private ImageView g;
    private int h = -1;
    private vk i;
    private a j;
    private Bitmap k = null;

    public interface a {
        void a(FacebookException facebookException);
    }

    public ProfilePictureView(Context context) {
        super(context);
        a(context);
    }

    public ProfilePictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
        a(attrs);
    }

    public ProfilePictureView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a(context);
        a(attrs);
    }

    public final int getPresetSize() {
        return this.h;
    }

    public final void setPresetSize(int sizeType) {
        switch (sizeType) {
            case -4:
            case -3:
            case ev.POSITION_NONE /*-2*/:
            case ev.POSITION_UNCHANGED /*-1*/:
                this.h = sizeType;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Must use a predefined preset size");
        }
    }

    public final boolean a() {
        return this.e;
    }

    public final void setCropped(boolean showCroppedVersion) {
        this.e = showCroppedVersion;
        a(false);
    }

    public final String getProfileId() {
        return this.b;
    }

    public final void setProfileId(String profileId) {
        boolean force = false;
        if (vw.a(this.b) || !this.b.equalsIgnoreCase(profileId)) {
            b();
            force = true;
        }
        this.b = profileId;
        a(force);
    }

    public final a getOnErrorListener() {
        return this.j;
    }

    public final void setOnErrorListener(a onErrorListener) {
        this.j = onErrorListener;
    }

    public final void setDefaultProfilePicture(Bitmap inputBitmap) {
        this.k = inputBitmap;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        LayoutParams params = getLayoutParams();
        boolean customMeasure = false;
        int newHeight = MeasureSpec.getSize(heightMeasureSpec);
        int newWidth = MeasureSpec.getSize(widthMeasureSpec);
        if (MeasureSpec.getMode(heightMeasureSpec) != 1073741824 && params.height == -2) {
            newHeight = c(true);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(newHeight, 1073741824);
            customMeasure = true;
        }
        if (MeasureSpec.getMode(widthMeasureSpec) != 1073741824 && params.width == -2) {
            newWidth = c(true);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(newWidth, 1073741824);
            customMeasure = true;
        }
        if (customMeasure) {
            setMeasuredDimension(newWidth, newHeight);
            measureChildren(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        a(false);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        Bundle instanceState = new Bundle();
        instanceState.putParcelable("ProfilePictureView_superState", superState);
        instanceState.putString("ProfilePictureView_profileId", this.b);
        instanceState.putInt("ProfilePictureView_presetSize", this.h);
        instanceState.putBoolean("ProfilePictureView_isCropped", this.e);
        instanceState.putParcelable("ProfilePictureView_bitmap", this.f);
        instanceState.putInt("ProfilePictureView_width", this.d);
        instanceState.putInt("ProfilePictureView_height", this.c);
        instanceState.putBoolean("ProfilePictureView_refresh", this.i != null);
        return instanceState;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        if (state.getClass() != Bundle.class) {
            super.onRestoreInstanceState(state);
            return;
        }
        Bundle instanceState = (Bundle) state;
        super.onRestoreInstanceState(instanceState.getParcelable("ProfilePictureView_superState"));
        this.b = instanceState.getString("ProfilePictureView_profileId");
        this.h = instanceState.getInt("ProfilePictureView_presetSize");
        this.e = instanceState.getBoolean("ProfilePictureView_isCropped");
        this.d = instanceState.getInt("ProfilePictureView_width");
        this.c = instanceState.getInt("ProfilePictureView_height");
        setImageBitmap((Bitmap) instanceState.getParcelable("ProfilePictureView_bitmap"));
        if (instanceState.getBoolean("ProfilePictureView_refresh")) {
            a(true);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = null;
    }

    private void a(Context context) {
        removeAllViews();
        this.g = new ImageView(context);
        this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.g.setScaleType(ScaleType.CENTER_INSIDE);
        addView(this.g);
    }

    private void a(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, um$h.com_facebook_profile_picture_view);
        setPresetSize(a.getInt(um$h.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
        this.e = a.getBoolean(um$h.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
        a.recycle();
    }

    private void a(boolean force) {
        boolean changed = c();
        if (this.b == null || this.b.length() == 0 || (this.d == 0 && this.c == 0)) {
            b();
        } else if (changed || force) {
            b(true);
        }
    }

    private void b() {
        if (this.i != null) {
            vj.b(this.i);
        }
        if (this.k == null) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), a() ? um$c.com_facebook_profile_picture_blank_square : um$c.com_facebook_profile_picture_blank_portrait));
            return;
        }
        c();
        setImageBitmap(Bitmap.createScaledBitmap(this.k, this.d, this.c, false));
    }

    private void setImageBitmap(Bitmap imageBitmap) {
        if (this.g != null && imageBitmap != null) {
            this.f = imageBitmap;
            this.g.setImageBitmap(imageBitmap);
        }
    }

    private void b(boolean allowCachedResponse) {
        vk request = new vk$a(getContext(), vk.a(this.b, this.d, this.c)).a(allowCachedResponse).a((Object) this).a(new vk$b(this) {
            final /* synthetic */ ProfilePictureView a;

            {
                this.a = this$0;
            }

            public void a(vl response) {
                this.a.a(response);
            }
        }).a();
        if (this.i != null) {
            vj.b(this.i);
        }
        this.i = request;
        vj.a(request);
    }

    private void a(vl response) {
        if (response.a() == this.i) {
            this.i = null;
            Bitmap responseImage = response.c();
            Throwable error = response.b();
            if (error != null) {
                a listener = this.j;
                if (listener != null) {
                    listener.a(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), error));
                } else {
                    vp.a(LoggingBehavior.REQUESTS, 6, a, error.toString());
                }
            } else if (responseImage != null) {
                setImageBitmap(responseImage);
                if (response.d()) {
                    b(false);
                }
            }
        }
    }

    private boolean c() {
        boolean changed = true;
        int newHeightPx = getHeight();
        int newWidthPx = getWidth();
        if (newWidthPx < 1 || newHeightPx < 1) {
            return false;
        }
        int presetSize = c(false);
        if (presetSize != 0) {
            newWidthPx = presetSize;
            newHeightPx = presetSize;
        }
        if (newWidthPx > newHeightPx) {
            newWidthPx = a() ? newHeightPx : 0;
        } else if (a()) {
            newHeightPx = newWidthPx;
        } else {
            newHeightPx = 0;
        }
        if (newWidthPx == this.d && newHeightPx == this.c) {
            changed = false;
        }
        this.d = newWidthPx;
        this.c = newHeightPx;
        return changed;
    }

    private int c(boolean forcePreset) {
        int dimensionId;
        switch (this.h) {
            case -4:
                dimensionId = um$b.com_facebook_profilepictureview_preset_size_large;
                break;
            case -3:
                dimensionId = um$b.com_facebook_profilepictureview_preset_size_normal;
                break;
            case ev.POSITION_NONE /*-2*/:
                dimensionId = um$b.com_facebook_profilepictureview_preset_size_small;
                break;
            case ev.POSITION_UNCHANGED /*-1*/:
                if (forcePreset) {
                    dimensionId = um$b.com_facebook_profilepictureview_preset_size_normal;
                    break;
                }
                return 0;
            default:
                return 0;
        }
        return getResources().getDimensionPixelSize(dimensionId);
    }
}
