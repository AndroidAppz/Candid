package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ya<T extends IInterface> {
    public static final String[] c = new String[]{"service_esmobile", "service_googleme"};
    final Handler a;
    protected AtomicInteger b;
    private int d;
    private long e;
    private long f;
    private int g;
    private long h;
    private final Context i;
    private final Looper j;
    private final yi k;
    private final zs l;
    private final Object m;
    private final Object n;
    private yp o;
    private ya$f p;
    private T q;
    private final ArrayList<ya$e<?>> r;
    private ya$h s;
    private int t;
    private final ya$b u;
    private final ya$c v;
    private final int w;
    private final String x;

    protected ya(Context context, Looper looper, int i, ya$b ya_b, ya$c ya_c, String str) {
        this(context, looper, yi.a(context), zs.b(), i, (ya$b) xr.a((Object) ya_b), (ya$c) xr.a((Object) ya_c), str);
    }

    protected ya(Context context, Looper looper, yi yiVar, zs zsVar, int i, ya$b ya_b, ya$c ya_c, String str) {
        this.m = new Object();
        this.n = new Object();
        this.r = new ArrayList();
        this.t = 1;
        this.b = new AtomicInteger(0);
        this.i = (Context) xr.a((Object) context, (Object) "Context must not be null");
        this.j = (Looper) xr.a((Object) looper, (Object) "Looper must not be null");
        this.k = (yi) xr.a((Object) yiVar, (Object) "Supervisor must not be null");
        this.l = (zs) xr.a((Object) zsVar, (Object) "API availability must not be null");
        this.a = new ya$d(this, looper);
        this.w = i;
        this.u = ya_b;
        this.v = ya_c;
        this.x = str;
    }

    private boolean a(int i, int i2, T t) {
        boolean z;
        synchronized (this.m) {
            if (this.t != i) {
                z = false;
            } else {
                b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void b(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        xr.b(z);
        synchronized (this.m) {
            this.t = i;
            this.q = t;
            a(i, (IInterface) t);
            switch (i) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    v();
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    h();
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    a((IInterface) t);
                    break;
            }
        }
    }

    private void h() {
        if (this.s != null) {
            String valueOf = String.valueOf(f());
            String valueOf2 = String.valueOf(i());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.k.b(f(), i(), this.s, j());
            this.b.incrementAndGet();
        }
        this.s = new ya$h(this, this.b.get());
        if (!this.k.a(f(), i(), this.s, j())) {
            valueOf = String.valueOf(f());
            valueOf2 = String.valueOf(i());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            a(16, null, this.b.get());
        }
    }

    private void v() {
        if (this.s != null) {
            this.k.b(f(), i(), this.s, j());
            this.s = null;
        }
    }

    protected abstract T a(IBinder iBinder);

    public void a() {
        this.b.incrementAndGet();
        synchronized (this.r) {
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                ((ya$e) this.r.get(i)).e();
            }
            this.r.clear();
        }
        synchronized (this.n) {
            this.o = null;
        }
        b(1, null);
    }

    protected void a(int i) {
        this.d = i;
        this.e = System.currentTimeMillis();
    }

    protected void a(int i, Bundle bundle, int i2) {
        this.a.sendMessage(this.a.obtainMessage(5, i2, -1, new ya$k(this, i, bundle)));
    }

    protected void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.a.sendMessage(this.a.obtainMessage(1, i2, -1, new ya$j(this, i, iBinder, bundle)));
    }

    void a(int i, T t) {
    }

    protected void a(T t) {
        this.f = System.currentTimeMillis();
    }

    protected void a(ConnectionResult connectionResult) {
        this.g = connectionResult.c();
        this.h = System.currentTimeMillis();
    }

    public void a(ya$f ya_f) {
        this.p = (ya$f) xr.a((Object) ya_f, (Object) "Connection progress callbacks cannot be null.");
        b(2, null);
    }

    public void a(yl ylVar, Set<Scope> set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.w).a(this.i.getPackageName()).a(o());
            if (set != null) {
                a.a(set);
            }
            if (s()) {
                a.a(n()).a(ylVar);
            } else if (t()) {
                a.a(m());
            }
            synchronized (this.n) {
                if (this.o != null) {
                    this.o.a(new ya$g(this, this.b.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void b(int i) {
        this.a.sendMessage(this.a.obtainMessage(4, this.b.get(), i));
    }

    public boolean b() {
        boolean z;
        synchronized (this.m) {
            z = this.t == 3;
        }
        return z;
    }

    public boolean c() {
        boolean z;
        synchronized (this.m) {
            z = this.t == 2;
        }
        return z;
    }

    public boolean d() {
        return true;
    }

    public IBinder e() {
        IBinder iBinder;
        synchronized (this.n) {
            if (this.o == null) {
                iBinder = null;
            } else {
                iBinder = this.o.asBinder();
            }
        }
        return iBinder;
    }

    protected abstract String f();

    protected abstract String g();

    protected String i() {
        return zu.GOOGLE_PLAY_SERVICES_PACKAGE;
    }

    protected final String j() {
        return this.x == null ? this.i.getClass().getName() : this.x;
    }

    public void k() {
        int a = this.l.a(this.i);
        if (a != 0) {
            b(1, null);
            this.p = new ya$i(this);
            this.a.sendMessage(this.a.obtainMessage(3, this.b.get(), a));
            return;
        }
        a(new ya$i(this));
    }

    public final Context l() {
        return this.i;
    }

    public Account m() {
        return null;
    }

    public final Account n() {
        return m() != null ? m() : new Account("<<default account>>", "com.google");
    }

    protected Bundle o() {
        return new Bundle();
    }

    protected final void p() {
        if (!b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle q() {
        return null;
    }

    public final T r() throws DeadObjectException {
        T t;
        synchronized (this.m) {
            if (this.t == 4) {
                throw new DeadObjectException();
            }
            p();
            xr.a(this.q != null, (Object) "Client is connected but service is null");
            t = this.q;
        }
        return t;
    }

    public boolean s() {
        return false;
    }

    public boolean t() {
        return false;
    }

    protected Set<Scope> u() {
        return Collections.EMPTY_SET;
    }
}
