package defpackage;

import android.os.Build.VERSION;

/* compiled from: ViewUtils */
class ah$1 implements ab$d {
    ah$1() {
    }

    public ab a() {
        return new ab(VERSION.SDK_INT >= 12 ? new ad() : new ac());
    }
}
