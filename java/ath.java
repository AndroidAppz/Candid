/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
import android.content.Context;
import android.os.Build;

public abstract class ath {
    public static ath a(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return new atg(context);
        }
        if (Build.VERSION.SDK_INT < 14) {
            return new ate(context);
        }
        return new atf(context);
    }

    public abstract void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

    public abstract void a(boolean var1);

    public abstract boolean a();

    public abstract boolean b();

    public abstract int c();

    public abstract int d();
}

