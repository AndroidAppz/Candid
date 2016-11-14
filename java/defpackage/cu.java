package defpackage;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

/* compiled from: ParcelableCompat */
public final class cu {
    public static <T> Creator<T> a(cv<T> callbacks) {
        if (VERSION.SDK_INT >= 13) {
            return cx.a(callbacks);
        }
        return new cu$a(callbacks);
    }
}
