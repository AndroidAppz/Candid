package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;
import com.facebook.share.internal.LikeButton;
import defpackage.bn;
import defpackage.um$a;
import defpackage.um$b;
import defpackage.um$h;
import defpackage.vi;
import defpackage.vr;
import defpackage.vw;
import defpackage.wk;
import defpackage.wk$c;

public class LikeView extends FrameLayout {
    private String a;
    private ObjectType b;
    private LinearLayout c;
    private LikeButton d;
    private LikeBoxCountView e;
    private TextView f;
    private wk g;
    private c h;
    private BroadcastReceiver i;
    private a j;
    private Style k = Style.d;
    private HorizontalAlignment l = HorizontalAlignment.d;
    private AuxiliaryViewPosition m = AuxiliaryViewPosition.d;
    private int n = -1;
    private int o;
    private int p;
    private vi q;
    private boolean r;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[AuxiliaryViewPosition.values().length];

        static {
            try {
                a[AuxiliaryViewPosition.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[AuxiliaryViewPosition.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[AuxiliaryViewPosition.INLINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum AuxiliaryViewPosition {
        BOTTOM("bottom", 0),
        INLINE("inline", 1),
        TOP("top", 2);
        
        static AuxiliaryViewPosition d;
        private String e;
        private int f;

        static {
            d = BOTTOM;
        }

        static AuxiliaryViewPosition a(int enumValue) {
            for (AuxiliaryViewPosition auxViewPosition : values()) {
                if (auxViewPosition.a() == enumValue) {
                    return auxViewPosition;
                }
            }
            return null;
        }

        private AuxiliaryViewPosition(String stringValue, int value) {
            this.e = stringValue;
            this.f = value;
        }

        public String toString() {
            return this.e;
        }

        private int a() {
            return this.f;
        }
    }

    public enum HorizontalAlignment {
        CENTER("center", 0),
        LEFT("left", 1),
        RIGHT("right", 2);
        
        static HorizontalAlignment d;
        private String e;
        private int f;

        static {
            d = CENTER;
        }

        static HorizontalAlignment a(int enumValue) {
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.a() == enumValue) {
                    return horizontalAlignment;
                }
            }
            return null;
        }

        private HorizontalAlignment(String stringValue, int value) {
            this.e = stringValue;
            this.f = value;
        }

        public String toString() {
            return this.e;
        }

        private int a() {
            return this.f;
        }
    }

    public enum ObjectType {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE("page", 2);
        
        public static ObjectType d;
        private String e;
        private int f;

        static {
            d = UNKNOWN;
        }

        public static ObjectType a(int enumValue) {
            for (ObjectType objectType : values()) {
                if (objectType.a() == enumValue) {
                    return objectType;
                }
            }
            return null;
        }

        private ObjectType(String stringValue, int value) {
            this.e = stringValue;
            this.f = value;
        }

        public String toString() {
            return this.e;
        }

        public int a() {
            return this.f;
        }
    }

    public enum Style {
        STANDARD("standard", 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        
        static Style d;
        private String e;
        private int f;

        static {
            d = STANDARD;
        }

        static Style a(int enumValue) {
            for (Style style : values()) {
                if (style.a() == enumValue) {
                    return style;
                }
            }
            return null;
        }

        private Style(String stringValue, int value) {
            this.e = stringValue;
            this.f = value;
        }

        public String toString() {
            return this.e;
        }

        private int a() {
            return this.f;
        }
    }

    class a implements wk$c {
        final /* synthetic */ LikeView a;
        private boolean b;

        private a(LikeView likeView) {
            this.a = likeView;
        }

        public void a() {
            this.b = true;
        }

        public void a(wk likeActionController, FacebookException error) {
            if (!this.b) {
                if (likeActionController != null) {
                    if (!likeActionController.e()) {
                        error = new FacebookException("Cannot use LikeView. The device may not be supported.");
                    }
                    this.a.a(likeActionController);
                    this.a.c();
                }
                if (!(error == null || this.a.h == null)) {
                    this.a.h.a(error);
                }
                this.a.j = null;
            }
        }
    }

    class b extends BroadcastReceiver {
        final /* synthetic */ LikeView a;

        private b(LikeView likeView) {
            this.a = likeView;
        }

        public void onReceive(Context context, Intent intent) {
            String intentAction = intent.getAction();
            Bundle extras = intent.getExtras();
            boolean shouldRespond = true;
            if (extras != null) {
                Object broadcastObjectId = extras.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
                shouldRespond = vw.a((String) broadcastObjectId) || vw.a(this.a.a, broadcastObjectId);
            }
            if (!shouldRespond) {
                return;
            }
            if ("com.facebook.sdk.LikeActionController.UPDATED".equals(intentAction)) {
                this.a.c();
            } else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(intentAction)) {
                if (this.a.h != null) {
                    this.a.h.a(vr.a(extras));
                }
            } else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(intentAction)) {
                this.a.a(this.a.a, this.a.b);
                this.a.c();
            }
        }
    }

    public interface c {
        void a(FacebookException facebookException);
    }

    public LikeView(Context context) {
        super(context);
        a(context);
    }

    public LikeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(attrs);
        a(context);
    }

    public void setObjectIdAndType(String objectId, ObjectType objectType) {
        objectId = vw.a(objectId, null);
        if (objectType == null) {
            objectType = ObjectType.d;
        }
        if (!vw.a((Object) objectId, this.a) || objectType != this.b) {
            a(objectId, objectType);
            c();
        }
    }

    public void setLikeViewStyle(Style likeViewStyle) {
        if (likeViewStyle == null) {
            likeViewStyle = Style.d;
        }
        if (this.k != likeViewStyle) {
            this.k = likeViewStyle;
            d();
        }
    }

    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition) {
        if (auxiliaryViewPosition == null) {
            auxiliaryViewPosition = AuxiliaryViewPosition.d;
        }
        if (this.m != auxiliaryViewPosition) {
            this.m = auxiliaryViewPosition;
            d();
        }
    }

    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            horizontalAlignment = HorizontalAlignment.d;
        }
        if (this.l != horizontalAlignment) {
            this.l = horizontalAlignment;
            d();
        }
    }

    public void setForegroundColor(int foregroundColor) {
        if (this.n != foregroundColor) {
            this.f.setTextColor(foregroundColor);
        }
    }

    public void setOnErrorListener(c onErrorListener) {
        this.h = onErrorListener;
    }

    public c getOnErrorListener() {
        return this.h;
    }

    public void setFragment(Fragment fragment) {
        this.q = new vi(fragment);
    }

    public void setFragment(android.app.Fragment fragment) {
        this.q = new vi(fragment);
    }

    public void setEnabled(boolean enabled) {
        this.r = !enabled;
        c();
    }

    protected void onDetachedFromWindow() {
        setObjectIdAndType(null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
    }

    private void a(AttributeSet attrs) {
        if (attrs != null && getContext() != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, um$h.com_facebook_like_view);
            if (a != null) {
                this.a = vw.a(a.getString(um$h.com_facebook_like_view_com_facebook_object_id), null);
                this.b = ObjectType.a(a.getInt(um$h.com_facebook_like_view_com_facebook_object_type, ObjectType.d.a()));
                this.k = Style.a(a.getInt(um$h.com_facebook_like_view_com_facebook_style, Style.d.a()));
                if (this.k == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
                }
                this.m = AuxiliaryViewPosition.a(a.getInt(um$h.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.d.a()));
                if (this.m == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
                }
                this.l = HorizontalAlignment.a(a.getInt(um$h.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.d.a()));
                if (this.l == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
                }
                this.n = a.getColor(um$h.com_facebook_like_view_com_facebook_foreground_color, -1);
                a.recycle();
            }
        }
    }

    private void a(Context context) {
        this.o = getResources().getDimensionPixelSize(um$b.com_facebook_likeview_edge_padding);
        this.p = getResources().getDimensionPixelSize(um$b.com_facebook_likeview_internal_padding);
        if (this.n == -1) {
            this.n = getResources().getColor(um$a.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.c = new LinearLayout(context);
        this.c.setLayoutParams(new LayoutParams(-2, -2));
        b(context);
        c(context);
        d(context);
        this.c.addView(this.d);
        this.c.addView(this.f);
        this.c.addView(this.e);
        addView(this.c);
        a(this.a, this.b);
        c();
    }

    private void b(Context context) {
        boolean z = this.g != null && this.g.d();
        this.d = new LikeButton(context, z);
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LikeView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a();
            }
        });
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private void c(Context context) {
        this.f = new TextView(context);
        this.f.setTextSize(0, getResources().getDimension(um$b.com_facebook_likeview_text_size));
        this.f.setMaxLines(2);
        this.f.setTextColor(this.n);
        this.f.setGravity(17);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    private void d(Context context) {
        this.e = new LikeBoxCountView(context);
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    private void a() {
        if (this.g != null) {
            Activity activity = null;
            if (this.q == null) {
                activity = getActivity();
            }
            this.g.a(activity, this.q, getAnalyticsParameters());
        }
    }

    private Activity getActivity() {
        Context context = getContext();
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    private Bundle getAnalyticsParameters() {
        Bundle params = new Bundle();
        params.putString("style", this.k.toString());
        params.putString("auxiliary_position", this.m.toString());
        params.putString("horizontal_alignment", this.l.toString());
        params.putString("object_id", vw.a(this.a, ""));
        params.putString("object_type", this.b.toString());
        return params;
    }

    private void a(String newObjectId, ObjectType newObjectType) {
        b();
        this.a = newObjectId;
        this.b = newObjectType;
        if (!vw.a(newObjectId)) {
            this.j = new a();
            if (!isInEditMode()) {
                wk.a(newObjectId, newObjectType, this.j);
            }
        }
    }

    private void a(wk likeActionController) {
        this.g = likeActionController;
        this.i = new b();
        bn localBroadcastManager = bn.a(getContext());
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
        filter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
        filter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
        localBroadcastManager.a(this.i, filter);
    }

    private void b() {
        if (this.i != null) {
            bn.a(getContext()).a(this.i);
            this.i = null;
        }
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        this.g = null;
    }

    private void c() {
        boolean enabled;
        if (this.r) {
            enabled = false;
        } else {
            enabled = true;
        }
        if (this.g == null) {
            this.d.setSelected(false);
            this.f.setText(null);
            this.e.setText(null);
        } else {
            this.d.setSelected(this.g.d());
            this.f.setText(this.g.c());
            this.e.setText(this.g.b());
            enabled &= this.g.e();
        }
        super.setEnabled(enabled);
        this.d.setEnabled(enabled);
        d();
    }

    private void d() {
        View auxView;
        int i = 1;
        LayoutParams containerViewLayoutParams = (LayoutParams) this.c.getLayoutParams();
        LinearLayout.LayoutParams buttonLayoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        int viewGravity = this.l == HorizontalAlignment.LEFT ? 3 : this.l == HorizontalAlignment.CENTER ? 1 : 5;
        containerViewLayoutParams.gravity = viewGravity | 48;
        buttonLayoutParams.gravity = viewGravity;
        this.f.setVisibility(8);
        this.e.setVisibility(8);
        if (this.k == Style.STANDARD && this.g != null && !vw.a(this.g.c())) {
            auxView = this.f;
        } else if (this.k == Style.BOX_COUNT && this.g != null && !vw.a(this.g.b())) {
            e();
            auxView = this.e;
        } else {
            return;
        }
        auxView.setVisibility(0);
        ((LinearLayout.LayoutParams) auxView.getLayoutParams()).gravity = viewGravity;
        LinearLayout linearLayout = this.c;
        if (this.m == AuxiliaryViewPosition.INLINE) {
            i = 0;
        }
        linearLayout.setOrientation(i);
        if (this.m == AuxiliaryViewPosition.TOP || (this.m == AuxiliaryViewPosition.INLINE && this.l == HorizontalAlignment.RIGHT)) {
            this.c.removeView(this.d);
            this.c.addView(this.d);
        } else {
            this.c.removeView(auxView);
            this.c.addView(auxView);
        }
        switch (AnonymousClass2.a[this.m.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                auxView.setPadding(this.o, this.o, this.o, this.p);
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                auxView.setPadding(this.o, this.p, this.o, this.o);
                return;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                if (this.l == HorizontalAlignment.RIGHT) {
                    auxView.setPadding(this.o, this.o, this.p, this.o);
                    return;
                } else {
                    auxView.setPadding(this.p, this.o, this.o, this.o);
                    return;
                }
            default:
                return;
        }
    }

    private void e() {
        switch (AnonymousClass2.a[this.m.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                this.e.setCaretPosition(LikeBoxCountViewCaretPosition.BOTTOM);
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                this.e.setCaretPosition(LikeBoxCountViewCaretPosition.TOP);
                return;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                this.e.setCaretPosition(this.l == HorizontalAlignment.RIGHT ? LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountViewCaretPosition.LEFT);
                return;
            default:
                return;
        }
    }
}
