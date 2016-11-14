package defpackage;

import android.app.Activity;
import android.content.Intent;

/* compiled from: LoginManager */
class we$b implements wg {
    private final vi a;

    we$b(vi fragment) {
        vx.a((Object) fragment, "fragment");
        this.a = fragment;
    }

    public void a(Intent intent, int requestCode) {
        this.a.a(intent, requestCode);
    }

    public Activity a() {
        return this.a.c();
    }
}
