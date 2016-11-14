package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

/* compiled from: PreferenceStoreImpl */
public class anb implements ana {
    private final SharedPreferences a;
    private final String b;
    private final Context c;

    public anb(Context context, String name) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.c = context;
        this.b = name;
        this.a = this.c.getSharedPreferences(this.b, 0);
    }

    @Deprecated
    public anb(aku kit) {
        this(kit.E(), kit.getClass().getName());
    }

    public SharedPreferences a() {
        return this.a;
    }

    public Editor b() {
        return this.a.edit();
    }

    @TargetApi(9)
    public boolean a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
