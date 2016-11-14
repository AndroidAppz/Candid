package defpackage;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

/* compiled from: SharedPreferencesCompat */
public final class br$a {
    private static br$a a;
    private final br$a$c b;

    private br$a() {
        if (VERSION.SDK_INT >= 9) {
            this.b = new br$a$a(null);
        } else {
            this.b = new br$a$b(null);
        }
    }

    public static br$a a() {
        if (a == null) {
            a = new br$a();
        }
        return a;
    }

    public void a(Editor editor) {
        this.b.a(editor);
    }
}
