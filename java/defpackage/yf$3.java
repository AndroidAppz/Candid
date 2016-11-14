package defpackage;

import android.annotation.TargetApi;
import android.content.Intent;

class yf$3 extends yf {
    final /* synthetic */ abb a;
    final /* synthetic */ Intent b;
    final /* synthetic */ int c;

    yf$3(abb abb, Intent intent, int i) {
        this.a = abb;
        this.b = intent;
        this.c = i;
    }

    @TargetApi(11)
    public void a() {
        this.a.startActivityForResult(this.b, this.c);
    }
}
