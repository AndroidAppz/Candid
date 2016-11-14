package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public abstract class yh<T extends IInterface> extends ya<T> implements wx$f {
    private final yd d;
    private final Set<Scope> e;
    private final Account f;

    protected yh(Context context, Looper looper, int i, yd ydVar, wz$b wz_b, wz$c wz_c) {
        this(context, looper, yi.a(context), wv.a(), i, ydVar, (wz$b) xr.a((Object) wz_b), (wz$c) xr.a((Object) wz_c));
    }

    protected yh(Context context, Looper looper, yi yiVar, wv wvVar, int i, yd ydVar, wz$b wz_b, wz$c wz_c) {
        super(context, looper, yiVar, wvVar, i, yh.a(wz_b), yh.a(wz_c), ydVar.d());
        this.d = ydVar;
        this.f = ydVar.a();
        this.e = b(ydVar.b());
    }

    private static ya$b a(wz$b wz_b) {
        return wz_b == null ? null : new yh$1(wz_b);
    }

    private static ya$c a(wz$c wz_c) {
        return wz_c == null ? null : new yh$2(wz_c);
    }

    private Set<Scope> b(Set<Scope> set) {
        Set<Scope> a = a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    protected Set<Scope> a(Set<Scope> set) {
        return set;
    }

    public final Account m() {
        return this.f;
    }

    protected final Set<Scope> u() {
        return this.e;
    }
}
