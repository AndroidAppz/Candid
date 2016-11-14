package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class yd {
    private final Account a;
    private final Set<Scope> b;
    private final Set<Scope> c;
    private final Map<wx<?>, yd$a> d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final abv i;
    private Integer j;

    public yd(Account account, Set<Scope> set, Map<wx<?>, yd$a> map, int i, View view, String str, String str2, abv abv) {
        Map map2;
        this.a = account;
        this.b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.d = map2;
        this.f = view;
        this.e = i;
        this.g = str;
        this.h = str2;
        this.i = abv;
        Set hashSet = new HashSet(this.b);
        for (yd$a yd_a : this.d.values()) {
            hashSet.addAll(yd_a.a);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public static yd a(Context context) {
        return new wz$a(context).a();
    }

    public Account a() {
        return this.a;
    }

    public Set<Scope> b() {
        return this.c;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public abv e() {
        return this.i;
    }

    public Integer f() {
        return this.j;
    }
}
