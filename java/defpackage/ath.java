package defpackage;

import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: ScrollerProxy */
public abstract class ath {
    public abstract void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public abstract void a(boolean z);

    public abstract boolean a();

    public abstract boolean b();

    public abstract int c();

    public abstract int d();

    public static ath a(Context context) {
        if (VERSION.SDK_INT < 9) {
            return new atg(context);
        }
        if (VERSION.SDK_INT < 14) {
            return new ate(context);
        }
        return new atf(context);
    }
}
