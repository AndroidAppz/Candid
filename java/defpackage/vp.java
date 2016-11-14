package defpackage;

import android.util.Log;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: Logger */
public class vp {
    private static final HashMap<String, String> a = new HashMap();
    private final LoggingBehavior b;
    private final String c;
    private StringBuilder d;
    private int e = 3;

    public static synchronized void a(String original, String replace) {
        synchronized (vp.class) {
            a.put(original, replace);
        }
    }

    public static synchronized void a(String accessToken) {
        synchronized (vp.class) {
            if (!ud.a(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                vp.a(accessToken, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    public static void a(LoggingBehavior behavior, String tag, String string) {
        vp.a(behavior, 3, tag, string);
    }

    public static void a(LoggingBehavior behavior, String tag, String format, Object... args) {
        if (ud.a(behavior)) {
            vp.a(behavior, 3, tag, String.format(format, args));
        }
    }

    public static void a(LoggingBehavior behavior, int priority, String tag, String format, Object... args) {
        if (ud.a(behavior)) {
            vp.a(behavior, priority, tag, String.format(format, args));
        }
    }

    public static void a(LoggingBehavior behavior, int priority, String tag, String string) {
        if (ud.a(behavior)) {
            string = vp.d(string);
            if (!tag.startsWith("FacebookSDK.")) {
                tag = "FacebookSDK." + tag;
            }
            Log.println(priority, tag, string);
            if (behavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    private static synchronized String d(String string) {
        synchronized (vp.class) {
            for (Entry<String, String> entry : a.entrySet()) {
                string = string.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return string;
    }

    public vp(LoggingBehavior behavior, String tag) {
        vx.a(tag, "tag");
        this.b = behavior;
        this.c = "FacebookSDK." + tag;
        this.d = new StringBuilder();
    }

    public void a() {
        b(this.d.toString());
        this.d = new StringBuilder();
    }

    public void b(String string) {
        vp.a(this.b, this.e, this.c, string);
    }

    public void c(String string) {
        if (b()) {
            this.d.append(string);
        }
    }

    public void a(String format, Object... args) {
        if (b()) {
            this.d.append(String.format(format, args));
        }
    }

    public void a(String key, Object value) {
        a("  %s:\t%s\n", key, value);
    }

    private boolean b() {
        return ud.a(this.b);
    }
}
