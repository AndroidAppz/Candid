package defpackage;

import android.util.Log;

/* compiled from: LoggerDefault */
public class atd implements atc {
    public int a(String tag, String msg) {
        return Log.d(tag, msg);
    }

    public int b(String tag, String msg) {
        return Log.i(tag, msg);
    }
}
