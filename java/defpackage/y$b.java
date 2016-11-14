package defpackage;

import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager */
class y$b {
    private final WeakReference<y$a> a;
    private int b;

    boolean a(y$a callback) {
        return callback != null && this.a.get() == callback;
    }
}
