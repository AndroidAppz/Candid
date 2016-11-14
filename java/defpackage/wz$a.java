package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class wz$a {
    private Account a;
    private final Set<Scope> b = new HashSet();
    private final Set<Scope> c = new HashSet();
    private int d;
    private View e;
    private String f;
    private String g;
    private final Map<wx<?>, yd$a> h = new dh();
    private final Context i;
    private final Map<wx<?>, wx$a> j = new dh();
    private int k = -1;
    private Looper l;
    private wv m = wv.a();
    private wx$b<? extends abu, abv> n = abt.c;
    private final ArrayList<wz$b> o = new ArrayList();
    private final ArrayList<wz$c> p = new ArrayList();

    public wz$a(Context context) {
        this.i = context;
        this.l = context.getMainLooper();
        this.f = context.getPackageName();
        this.g = context.getClass().getName();
    }

    public yd a() {
        abv abv = abv.a;
        if (this.j.containsKey(abt.g)) {
            abv = (abv) this.j.get(abt.g);
        }
        return new yd(this.a, this.b, this.h, this.d, this.e, this.f, this.g, abv);
    }
}
