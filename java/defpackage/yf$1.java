package defpackage;

import android.app.Activity;
import android.content.Intent;

class yf$1 extends yf {
    final /* synthetic */ Activity a;
    final /* synthetic */ Intent b;
    final /* synthetic */ int c;

    yf$1(Activity activity, Intent intent, int i) {
        this.a = activity;
        this.b = intent;
        this.c = i;
    }

    public void a() {
        this.a.startActivityForResult(this.b, this.c);
    }
}
