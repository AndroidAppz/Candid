package defpackage;

import android.content.Intent;
import android.support.v4.app.Fragment;

class yf$2 extends yf {
    final /* synthetic */ Fragment a;
    final /* synthetic */ Intent b;
    final /* synthetic */ int c;

    yf$2(Fragment fragment, Intent intent, int i) {
        this.a = fragment;
        this.b = intent;
        this.c = i;
    }

    public void a() {
        this.a.startActivityForResult(this.b, this.c);
    }
}
