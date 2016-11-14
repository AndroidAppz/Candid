/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.Looper
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Scope
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.Set
 */
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

public abstract class yh<T extends IInterface>
extends ya<T>
implements wx.f {
    private final yd d;
    private final Set<Scope> e;
    private final Account f;

    protected yh(Context context, Looper looper, int n2, yd yd2, wz.b b2, wz.c c2) {
        this(context, looper, yi.a(context), wv.a(), n2, yd2, xr.a(b2), xr.a(c2));
    }

    protected yh(Context context, Looper looper, yi yi2, wv wv2, int n2, yd yd2, wz.b b2, wz.c c2) {
        super(context, looper, yi2, wv2, n2, yh.a(b2), yh.a(c2), yd2.d());
        this.d = yd2;
        this.f = yd2.a();
        this.e = super.b(yd2.b());
    }

    private static ya.b a(wz.b b2) {
        if (b2 == null) {
            return null;
        }
        return new ya.b(){

            @Override
            public void a(int n2) {
                b.this.a(n2);
            }

            @Override
            public void a(Bundle bundle) {
                b.this.a(bundle);
            }
        };
    }

    private static ya.c a(wz.c c2) {
        if (c2 == null) {
            return null;
        }
        return new ya.c(){

            @Override
            public void a(ConnectionResult connectionResult) {
                c.this.a(connectionResult);
            }
        };
    }

    private Set<Scope> b(Set<Scope> set) {
        Set<Scope> set2 = this.a(set);
        Iterator iterator = set2.iterator();
        while (iterator.hasNext()) {
            if (set.contains((Object)((Scope)iterator.next()))) continue;
            throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
        }
        return set2;
    }

    protected Set<Scope> a(Set<Scope> set) {
        return set;
    }

    @Override
    public final Account m() {
        return this.f;
    }

    @Override
    protected final Set<Scope> u() {
        return this.e;
    }

}

