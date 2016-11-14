/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class anb
implements ana {
    private final SharedPreferences a;
    private final String b;
    private final Context c;

    @Deprecated
    public anb(aku aku2) {
        super(aku2.E(), aku2.getClass().getName());
    }

    public anb(Context context, String string2) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.c = context;
        this.b = string2;
        this.a = this.c.getSharedPreferences(this.b, 0);
    }

    @Override
    public SharedPreferences a() {
        return this.a;
    }

    @TargetApi(value=9)
    @Override
    public boolean a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
            return true;
        }
        return editor.commit();
    }

    @Override
    public SharedPreferences.Editor b() {
        return this.a.edit();
    }
}

