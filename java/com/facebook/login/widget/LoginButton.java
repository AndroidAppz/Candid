package com.facebook.login.widget;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AccessToken;
import com.facebook.FacebookButtonBase;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.widget.ToolTipPopup.Style;
import defpackage.ua;
import defpackage.ud;
import defpackage.um$a;
import defpackage.um$f;
import defpackage.um$g;
import defpackage.um$h;
import defpackage.vw;
import defpackage.vw$b;
import defpackage.we;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LoginButton extends FacebookButtonBase {
    private static final String a = LoginButton.class.getName();
    private boolean b;
    private String c;
    private String d;
    private a e = new a();
    private String f = "fb_login_view_usage";
    private boolean g;
    private Style h = Style.BLUE;
    private ToolTipMode i;
    private long j = 6000;
    private ToolTipPopup k;
    private ua l;
    private we m;

    public class b implements OnClickListener {
        final /* synthetic */ LoginButton b;

        protected b(LoginButton this$0) {
            this.b = this$0;
        }

        public void onClick(View v) {
            this.b.a(v);
            AccessToken accessToken = AccessToken.a();
            if (accessToken != null) {
                a(this.b.getContext());
            } else {
                b();
            }
            AppEventsLogger logger = AppEventsLogger.a(this.b.getContext());
            Bundle parameters = new Bundle();
            parameters.putInt("logging_in", accessToken != null ? 0 : 1);
            logger.a(this.b.f, null, parameters);
        }

        protected void b() {
            we loginManager = a();
            if (LoginAuthorizationType.PUBLISH.equals(this.b.e.c)) {
                if (this.b.getFragment() != null) {
                    loginManager.b(this.b.getFragment(), this.b.e.b);
                } else if (this.b.getNativeFragment() != null) {
                    loginManager.b(this.b.getNativeFragment(), this.b.e.b);
                } else {
                    loginManager.b(this.b.getActivity(), this.b.e.b);
                }
            } else if (this.b.getFragment() != null) {
                loginManager.a(this.b.getFragment(), this.b.e.b);
            } else if (this.b.getNativeFragment() != null) {
                loginManager.a(this.b.getNativeFragment(), this.b.e.b);
            } else {
                loginManager.a(this.b.getActivity(), this.b.e.b);
            }
        }

        protected void a(Context context) {
            final we loginManager = a();
            if (this.b.b) {
                String message;
                String logout = this.b.getResources().getString(um$f.com_facebook_loginview_log_out_action);
                String cancel = this.b.getResources().getString(um$f.com_facebook_loginview_cancel_action);
                Profile profile = Profile.a();
                if (profile == null || profile.c() == null) {
                    message = this.b.getResources().getString(um$f.com_facebook_loginview_logged_in_using_facebook);
                } else {
                    message = String.format(this.b.getResources().getString(um$f.com_facebook_loginview_logged_in_as), new Object[]{profile.c()});
                }
                Builder builder = new Builder(context);
                builder.setMessage(message).setCancelable(true).setPositiveButton(logout, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ b b;

                    public void onClick(DialogInterface dialog, int which) {
                        loginManager.d();
                    }
                }).setNegativeButton(cancel, null);
                builder.create().show();
                return;
            }
            loginManager.d();
        }

        protected we a() {
            we manager = we.c();
            manager.a(this.b.getDefaultAudience());
            manager.a(this.b.getLoginBehavior());
            return manager;
        }
    }

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a = new int[ToolTipMode.values().length];

        static {
            try {
                a[ToolTipMode.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ToolTipMode.DISPLAY_ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ToolTipMode.NEVER_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum ToolTipMode {
        AUTOMATIC("automatic", 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        public static ToolTipMode d;
        private String e;
        private int f;

        static {
            d = AUTOMATIC;
        }

        public static ToolTipMode a(int enumValue) {
            for (ToolTipMode mode : values()) {
                if (mode.a() == enumValue) {
                    return mode;
                }
            }
            return null;
        }

        private ToolTipMode(String stringValue, int value) {
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

    static class a {
        private DefaultAudience a = DefaultAudience.FRIENDS;
        private List<String> b = Collections.emptyList();
        private LoginAuthorizationType c = null;
        private LoginBehavior d = LoginBehavior.NATIVE_WITH_FALLBACK;

        a() {
        }

        public void a(DefaultAudience defaultAudience) {
            this.a = defaultAudience;
        }

        public DefaultAudience a() {
            return this.a;
        }

        public void a(List<String> permissions) {
            if (LoginAuthorizationType.PUBLISH.equals(this.c)) {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            this.b = permissions;
            this.c = LoginAuthorizationType.READ;
        }

        public void b(List<String> permissions) {
            if (LoginAuthorizationType.READ.equals(this.c)) {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            } else if (vw.a((Collection) permissions)) {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            } else {
                this.b = permissions;
                this.c = LoginAuthorizationType.PUBLISH;
            }
        }

        List<String> b() {
            return this.b;
        }

        public void a(LoginBehavior loginBehavior) {
            this.d = loginBehavior;
        }

        public LoginBehavior c() {
            return this.d;
        }
    }

    public LoginButton(Context context) {
        super(context, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.e.a(defaultAudience);
    }

    public DefaultAudience getDefaultAudience() {
        return this.e.a();
    }

    public void setReadPermissions(List<String> permissions) {
        this.e.a((List) permissions);
    }

    public void setReadPermissions(String... permissions) {
        this.e.a(Arrays.asList(permissions));
    }

    public void setPublishPermissions(List<String> permissions) {
        this.e.b((List) permissions);
    }

    public void setPublishPermissions(String... permissions) {
        this.e.b(Arrays.asList(permissions));
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.e.a(loginBehavior);
    }

    public LoginBehavior getLoginBehavior() {
        return this.e.c();
    }

    public void setToolTipStyle(Style toolTipStyle) {
        this.h = toolTipStyle;
    }

    public void setToolTipMode(ToolTipMode toolTipMode) {
        this.i = toolTipMode;
    }

    public ToolTipMode getToolTipMode() {
        return this.i;
    }

    public void setToolTipDisplayTime(long displayTime) {
        this.j = displayTime;
    }

    public long getToolTipDisplayTime() {
        return this.j;
    }

    public void a() {
        if (this.k != null) {
            this.k.b();
            this.k = null;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l != null && !this.l.c()) {
            this.l.a();
            c();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.g && !isInEditMode()) {
            this.g = true;
            b();
        }
    }

    private void a(vw$b settings) {
        if (settings != null && settings.c() && getVisibility() == 0) {
            b(settings.b());
        }
    }

    private void b(String toolTipString) {
        this.k = new ToolTipPopup(toolTipString, this);
        this.k.a(this.h);
        this.k.a(this.j);
        this.k.a();
    }

    private void b() {
        switch (AnonymousClass3.a[this.i.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                final String appId = vw.a(getContext());
                ud.d().execute(new Runnable(this) {
                    final /* synthetic */ LoginButton b;

                    public void run() {
                        final vw$b settings = vw.a(appId, false);
                        this.b.getActivity().runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 b;

                            public void run() {
                                this.b.b.a(settings);
                            }
                        });
                    }
                });
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                b(getResources().getString(um$f.com_facebook_tooltip_default));
                return;
            default:
                return;
        }
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.l != null) {
            this.l.b();
        }
        a();
    }

    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0) {
            a();
        }
    }

    List<String> getPermissions() {
        return this.e.b();
    }

    void setProperties(a properties) {
        this.e = properties;
    }

    protected void a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super.a(context, attrs, defStyleAttr, defStyleRes);
        setInternalOnClickListener(getNewLoginClickListener());
        b(context, attrs, defStyleAttr, defStyleRes);
        if (isInEditMode()) {
            setBackgroundColor(getResources().getColor(um$a.com_facebook_blue));
            this.c = "Log in with Facebook";
        } else {
            this.l = new ua(this) {
                final /* synthetic */ LoginButton a;

                {
                    this.a = this$0;
                }

                protected void a(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                    this.a.c();
                }
            };
        }
        c();
    }

    protected b getNewLoginClickListener() {
        return new b(this);
    }

    protected int getDefaultStyleResource() {
        return um$g.com_facebook_loginview_default_style;
    }

    private void b(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.i = ToolTipMode.d;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, um$h.com_facebook_login_view, defStyleAttr, defStyleRes);
        try {
            this.b = a.getBoolean(um$h.com_facebook_login_view_com_facebook_confirm_logout, true);
            this.c = a.getString(um$h.com_facebook_login_view_com_facebook_login_text);
            this.d = a.getString(um$h.com_facebook_login_view_com_facebook_logout_text);
            this.i = ToolTipMode.a(a.getInt(um$h.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.d.a()));
        } finally {
            a.recycle();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int logInWidth;
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        int height = (getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom))))) + getCompoundPaddingBottom();
        Resources resources = getResources();
        String text = this.c;
        if (text == null) {
            text = resources.getString(um$f.com_facebook_loginview_log_in_button_long);
            logInWidth = c(text);
            if (resolveSize(logInWidth, widthMeasureSpec) < logInWidth) {
                text = resources.getString(um$f.com_facebook_loginview_log_in_button);
            }
        }
        logInWidth = c(text);
        text = this.d;
        if (text == null) {
            text = resources.getString(um$f.com_facebook_loginview_log_out_button);
        }
        setMeasuredDimension(resolveSize(Math.max(logInWidth, c(text)), widthMeasureSpec), height);
    }

    private int c(String text) {
        return ((getCompoundPaddingLeft() + getCompoundDrawablePadding()) + a(text)) + getCompoundPaddingRight();
    }

    private void c() {
        Resources resources = getResources();
        if (!isInEditMode() && AccessToken.a() != null) {
            CharSequence charSequence;
            if (this.d != null) {
                charSequence = this.d;
            } else {
                charSequence = resources.getString(um$f.com_facebook_loginview_log_out_button);
            }
            setText(charSequence);
        } else if (this.c != null) {
            setText(this.c);
        } else {
            String text = resources.getString(um$f.com_facebook_loginview_log_in_button_long);
            int width = getWidth();
            if (width != 0 && c(text) > width) {
                text = resources.getString(um$f.com_facebook_loginview_log_in_button);
            }
            setText(text);
        }
    }

    protected int getDefaultRequestCode() {
        return RequestCodeOffset.Login.a();
    }

    we getLoginManager() {
        if (this.m == null) {
            this.m = we.c();
        }
        return this.m;
    }

    void setLoginManager(we loginManager) {
        this.m = loginManager;
    }
}
