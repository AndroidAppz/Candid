package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class zx$4 implements zx$a {
    final /* synthetic */ FrameLayout a;
    final /* synthetic */ LayoutInflater b;
    final /* synthetic */ ViewGroup c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ zx e;

    zx$4(zx zxVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = zxVar;
        this.a = frameLayout;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.d = bundle;
    }

    public int a() {
        return 2;
    }

    public void a(zw zwVar) {
        this.a.removeAllViews();
        this.a.addView(this.e.a.a(this.b, this.c, this.d));
    }
}
