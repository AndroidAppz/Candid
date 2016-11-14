package defpackage;

import android.app.Activity;
import android.content.Intent;

/* compiled from: LoginManager */
class we$a implements wg {
    private final Activity a;

    we$a(Activity activity) {
        vx.a((Object) activity, "activity");
        this.a = activity;
    }

    public void a(Intent intent, int requestCode) {
        this.a.startActivityForResult(intent, requestCode);
    }

    public Activity a() {
        return this.a;
    }
}
