/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  com.google.android.gms.common.api.Scope
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;

public final class abt {
    public static final wx.g<ahk> a = new wx.g();
    public static final wx.g<ahk> b = new wx.g();
    public static final wx.b<ahk, abv> c = new wx.b<ahk, abv>(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public ahk a(Context context, Looper looper, yd yd2, abv abv2, wz.b b2, wz.c c2) {
            abv abv3;
            if (abv2 == null) {
                abv3 = abv.a;
                do {
                    return new ahk(context, looper, true, yd2, abv3, b2, c2);
                    break;
                } while (true);
            }
            abv3 = abv2;
            return new ahk(context, looper, true, yd2, abv3, b2, c2);
        }
    };
    static final wx.b<ahk, a> d = new wx.b<ahk, a>(){

        @Override
        public ahk a(Context context, Looper looper, yd yd2, a a2, wz.b b2, wz.c c2) {
            return new ahk(context, looper, false, yd2, a2.a(), b2, c2);
        }
    };
    public static final Scope e = new Scope("profile");
    public static final Scope f = new Scope("email");
    public static final wx<abv> g = new wx<abv>("SignIn.API", c, a);
    public static final wx<a> h = new wx<a>("SignIn.INTERNAL_API", d, b);

    public static class a
    implements wx.a.a {
        public Bundle a() {
            return null;
        }
    }

}

