package defpackage;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import java.util.Locale;

/* compiled from: WebDialog */
public class vy extends Dialog {
    private String a;
    private String b;
    private vy$c c;
    private WebView d;
    private ProgressDialog e;
    private ImageView f;
    private FrameLayout g;
    private boolean h;
    private boolean i;
    private boolean j;

    public vy(Context context, String url) {
        this(context, url, ud.l());
    }

    public vy(Context context, String url, int theme) {
        if (theme == 0) {
            theme = ud.l();
        }
        super(context, theme);
        this.b = "fbconnect://success";
        this.h = false;
        this.i = false;
        this.j = false;
        this.a = url;
    }

    public vy(Context context, String action, Bundle parameters, int theme, vy$c listener) {
        if (theme == 0) {
            theme = ud.l();
        }
        super(context, theme);
        this.b = "fbconnect://success";
        this.h = false;
        this.i = false;
        this.j = false;
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("redirect_uri", "fbconnect://success");
        parameters.putString("display", "touch");
        parameters.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[]{ud.g()}));
        this.a = vw.a(vu.a(), vu.d() + "/" + "dialog/" + action, parameters).toString();
        this.c = listener;
    }

    public void a(vy$c listener) {
        this.c = listener;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            cancel();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void dismiss() {
        if (this.d != null) {
            this.d.stopLoading();
        }
        if (!(this.i || this.e == null || !this.e.isShowing())) {
            this.e.dismiss();
        }
        super.dismiss();
    }

    protected void onStart() {
        super.onStart();
        d();
    }

    public void onDetachedFromWindow() {
        this.i = true;
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        this.i = false;
        super.onAttachedToWindow();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.e = new ProgressDialog(getContext());
        this.e.requestWindowFeature(1);
        this.e.setMessage(getContext().getString(um$f.com_facebook_loading));
        this.e.setCanceledOnTouchOutside(false);
        this.e.setOnCancelListener(new vy$1(this));
        requestWindowFeature(1);
        this.g = new FrameLayout(getContext());
        d();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        e();
        a((this.f.getDrawable().getIntrinsicWidth() / 2) + 1);
        this.g.addView(this.f, new LayoutParams(-2, -2));
        setContentView(this.g);
    }

    protected void b(String expectedRedirectUrl) {
        this.b = expectedRedirectUrl;
    }

    protected Bundle a(String urlString) {
        Uri u = Uri.parse(urlString);
        Bundle b = vw.c(u.getQuery());
        b.putAll(vw.c(u.getFragment()));
        return b;
    }

    protected boolean a() {
        return this.h;
    }

    protected boolean b() {
        return this.j;
    }

    protected WebView c() {
        return this.d;
    }

    public void d() {
        Display display = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        getWindow().setLayout(Math.min(a(metrics.widthPixels < metrics.heightPixels ? metrics.widthPixels : metrics.heightPixels, metrics.density, 480, 800), metrics.widthPixels), Math.min(a(metrics.widthPixels < metrics.heightPixels ? metrics.heightPixels : metrics.widthPixels, metrics.density, 800, 1280), metrics.heightPixels));
    }

    private int a(int screenSize, float density, int noPaddingSize, int maxPaddingSize) {
        double scaleFactor;
        int scaledSize = (int) (((float) screenSize) / density);
        if (scaledSize <= noPaddingSize) {
            scaleFactor = 1.0d;
        } else if (scaledSize >= maxPaddingSize) {
            scaleFactor = 0.5d;
        } else {
            scaleFactor = 0.5d + ((((double) (maxPaddingSize - scaledSize)) / ((double) (maxPaddingSize - noPaddingSize))) * 0.5d);
        }
        return (int) (((double) screenSize) * scaleFactor);
    }

    protected void a(Bundle values) {
        if (this.c != null && !this.h) {
            this.h = true;
            this.c.a(values, null);
            dismiss();
        }
    }

    protected void a(Throwable error) {
        if (this.c != null && !this.h) {
            FacebookException facebookException;
            this.h = true;
            if (error instanceof FacebookException) {
                facebookException = (FacebookException) error;
            } else {
                facebookException = new FacebookException(error);
            }
            this.c.a(null, facebookException);
            dismiss();
        }
    }

    public void cancel() {
        if (this.c != null && !this.h) {
            a(new FacebookOperationCanceledException());
        }
    }

    private void e() {
        this.f = new ImageView(getContext());
        this.f.setOnClickListener(new vy$2(this));
        this.f.setImageDrawable(getContext().getResources().getDrawable(um$c.com_facebook_close));
        this.f.setVisibility(4);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a(int margin) {
        LinearLayout webViewContainer = new LinearLayout(getContext());
        this.d = new vy$3(this, getContext().getApplicationContext());
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setWebViewClient(new vy$b(this, null));
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.loadUrl(this.a);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.setVisibility(4);
        this.d.getSettings().setSavePassword(false);
        this.d.getSettings().setSaveFormData(false);
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.setOnTouchListener(new vy$4(this));
        webViewContainer.setPadding(margin, margin, margin, margin);
        webViewContainer.addView(this.d);
        webViewContainer.setBackgroundColor(-872415232);
        this.g.addView(webViewContainer);
    }
}
