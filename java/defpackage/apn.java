package defpackage;

import android.os.Handler;
import android.os.Looper;

/* compiled from: AndroidSchedulers */
public final class apn {
    private static final apg a = new apo(new Handler(Looper.getMainLooper()));

    public static apg a() {
        apg scheduler = apl.a().b().b();
        return scheduler != null ? scheduler : a;
    }
}
