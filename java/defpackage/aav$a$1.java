package defpackage;

import android.app.Dialog;
import com.google.android.gms.internal.zzol.a;

class aav$a$1 extends a {
    final /* synthetic */ Dialog a;
    final /* synthetic */ aav$a b;

    aav$a$1(aav$a aav_a, Dialog dialog) {
        this.b = aav_a;
        this.a = dialog;
    }

    public void a() {
        this.b.a.d();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
