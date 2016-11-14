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

public final class ata {
    /*
     * Enabled aggressive block sorting
     */
    public static asy a(Context context, asz asz2) {
        int n2 = Build.VERSION.SDK_INT;
        asv asv2 = n2 < 5 ? new asv(context) : (n2 < 8 ? new asw(context) : new asx(context));
        asv2.a(asz2);
        return asv2;
    }
}

