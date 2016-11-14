/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.util.Log;

public class ako
implements akx {
    private int a;

    public ako() {
        this.a = 4;
    }

    public ako(int n2) {
        this.a = n2;
    }

    @Override
    public void a(int n2, String string2, String string3) {
        this.a(n2, string2, string3, false);
    }

    public void a(int n2, String string2, String string3, boolean bl2) {
        if (bl2 || this.a(string2, n2)) {
            Log.println((int)n2, (String)string2, (String)string3);
        }
    }

    @Override
    public void a(String string2, String string3) {
        this.a(string2, string3, null);
    }

    @Override
    public void a(String string2, String string3, Throwable throwable) {
        if (this.a(string2, 3)) {
            Log.d((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    @Override
    public boolean a(String string2, int n2) {
        if (this.a <= n2) {
            return true;
        }
        return false;
    }

    @Override
    public void b(String string2, String string3) {
        this.b(string2, string3, null);
    }

    public void b(String string2, String string3, Throwable throwable) {
        if (this.a(string2, 2)) {
            Log.v((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    @Override
    public void c(String string2, String string3) {
        this.c(string2, string3, null);
    }

    public void c(String string2, String string3, Throwable throwable) {
        if (this.a(string2, 4)) {
            Log.i((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    @Override
    public void d(String string2, String string3) {
        this.d(string2, string3, null);
    }

    @Override
    public void d(String string2, String string3, Throwable throwable) {
        if (this.a(string2, 5)) {
            Log.w((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    @Override
    public void e(String string2, String string3) {
        this.e(string2, string3, null);
    }

    @Override
    public void e(String string2, String string3, Throwable throwable) {
        if (this.a(string2, 6)) {
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }
}

