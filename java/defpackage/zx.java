package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.LinkedList;

public abstract class zx<T extends zw> {
    private T a;
    private Bundle b;
    private LinkedList<zx$a> c;
    private final aaa<T> d = new zx$1(this);

    private void a(int i) {
        while (!this.c.isEmpty() && ((zx$a) this.c.getLast()).a() >= i) {
            this.c.removeLast();
        }
    }

    private void a(Bundle bundle, zx$a zx_a) {
        if (this.a != null) {
            zx_a.a(this.a);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(zx_a);
        if (bundle != null) {
            if (this.b == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                this.b.putAll(bundle);
            }
        }
        a(this.d);
    }

    public static void b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence a = ye.a(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzam(context));
        CharSequence c = ye.c(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(a);
        linearLayout.addView(textView);
        if (c != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(c);
            linearLayout.addView(button);
            button.setOnClickListener(new zx$5(context, isGooglePlayServicesAvailable));
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, new zx$4(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.a == null) {
            a(frameLayout);
        }
        return frameLayout;
    }

    public void a() {
        a(null, new zx$6(this));
    }

    public abstract void a(aaa<T> aaa_T);

    public void a(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, new zx$2(this, activity, bundle, bundle2));
    }

    public void a(Bundle bundle) {
        a(bundle, new zx$3(this, bundle));
    }

    protected void a(FrameLayout frameLayout) {
        zx.b(frameLayout);
    }

    public void b() {
        if (this.a != null) {
            this.a.b();
        } else {
            a(5);
        }
    }

    public void b(Bundle bundle) {
        if (this.a != null) {
            this.a.b(bundle);
        } else if (this.b != null) {
            bundle.putAll(this.b);
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.c();
        } else {
            a(2);
        }
    }

    public void d() {
        if (this.a != null) {
            this.a.d();
        } else {
            a(1);
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.e();
        }
    }
}
