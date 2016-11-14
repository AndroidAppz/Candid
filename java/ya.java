/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.GetServiceRequest
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicInteger
 */
import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ya<T extends IInterface> {
    public static final String[] c = new String[]{"service_esmobile", "service_googleme"};
    final Handler a;
    protected AtomicInteger b = new AtomicInteger(0);
    private int d;
    private long e;
    private long f;
    private int g;
    private long h;
    private final Context i;
    private final Looper j;
    private final yi k;
    private final zs l;
    private final Object m = new Object();
    private final Object n = new Object();
    private yp o;
    private f p;
    private T q;
    private final ArrayList<e<?>> r = new ArrayList();
    private h s;
    private int t = 1;
    private final b u;
    private final c v;
    private final int w;
    private final String x;

    protected ya(Context context, Looper looper, int n2, b b2, c c2, String string2) {
        this(context, looper, yi.a(context), zs.b(), n2, xr.a(b2), xr.a(c2), string2);
    }

    protected ya(Context context, Looper looper, yi yi2, zs zs2, int n2, b b2, c c2, String string2) {
        this.i = xr.a(context, (Object)"Context must not be null");
        this.j = xr.a(looper, (Object)"Looper must not be null");
        this.k = xr.a(yi2, (Object)"Supervisor must not be null");
        this.l = xr.a(zs2, (Object)"API availability must not be null");
        this.a = (ya)this.new d(looper);
        this.w = n2;
        this.u = b2;
        this.v = c2;
        this.x = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(int n2, int n3, T t2) {
        Object object;
        Object object2 = object = this.m;
        synchronized (object2) {
            if (this.t != n2) {
                return false;
            }
            super.b(n3, t2);
            return true;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void b(int var1, T var2_2) {
        var3_3 = true;
        var4_4 = var1 == 3 ? var3_3 : false;
        var5_5 = var2_2 != null ? var3_3 : false;
        if (var4_4 != var5_5) {
            var3_3 = false;
        }
        xr.b(var3_3);
        var8_7 = var6_6 = this.m;
        // MONITORENTER : var8_7
        this.t = var1;
        this.q = var2_2;
        this.a(var1, var2_2);
        switch (var1) {
            case 2: {
                super.h();
                ** break;
            }
            case 3: {
                this.a(var2_2);
            }
lbl18: // 3 sources:
            default: {
                // MONITOREXIT : var8_7
                return;
            }
            case 1: 
        }
        super.v();
    }

    private void h() {
        if (this.s != null) {
            String string2 = String.valueOf((Object)this.f());
            String string3 = String.valueOf((Object)this.i());
            Log.e((String)"GmsClient", (String)new StringBuilder(70 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length()).append("Calling connect() while still connected, missing disconnect() for ").append(string2).append(" on ").append(string3).toString());
            this.k.b(this.f(), this.i(), this.s, this.j());
            this.b.incrementAndGet();
        }
        this.s = new h(this.b.get());
        if (!this.k.a(this.f(), this.i(), this.s, this.j())) {
            String string4 = String.valueOf((Object)this.f());
            String string5 = String.valueOf((Object)this.i());
            Log.e((String)"GmsClient", (String)new StringBuilder(34 + String.valueOf((Object)string4).length() + String.valueOf((Object)string5).length()).append("unable to connect to service: ").append(string4).append(" on ").append(string5).toString());
            this.a(16, null, this.b.get());
        }
    }

    private void v() {
        if (this.s != null) {
            this.k.b(this.f(), this.i(), this.s, this.j());
            this.s = null;
        }
    }

    protected abstract T a(IBinder var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        ArrayList<e<?>> arrayList;
        this.b.incrementAndGet();
        ArrayList<e<?>> arrayList2 = arrayList = this.r;
        synchronized (arrayList2) {
            int n2 = this.r.size();
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    Object object;
                    this.r.clear();
                    // MONITOREXIT [8, 7, 5] lbl9 : MonitorExitStatement: MONITOREXIT : var8_2
                    Object object2 = object = this.n;
                    synchronized (object2) {
                        this.o = null;
                    }
                    this.b(1, null);
                    return;
                }
                ((e)this.r.get(n3)).e();
                ++n3;
            } while (true);
        }
    }

    protected void a(int n2) {
        this.d = n2;
        this.e = System.currentTimeMillis();
    }

    protected void a(int n2, Bundle bundle, int n3) {
        this.a.sendMessage(this.a.obtainMessage(5, n3, -1, (Object)(ya)this.new k(n2, bundle)));
    }

    protected void a(int n2, IBinder iBinder, Bundle bundle, int n3) {
        this.a.sendMessage(this.a.obtainMessage(1, n3, -1, (Object)(ya)this.new j(n2, iBinder, bundle)));
    }

    void a(int n2, T t2) {
    }

    protected void a(T t2) {
        this.f = System.currentTimeMillis();
    }

    protected void a(ConnectionResult connectionResult) {
        this.g = connectionResult.c();
        this.h = System.currentTimeMillis();
    }

    public void a(f f2) {
        this.p = xr.a(f2, (Object)"Connection progress callbacks cannot be null.");
        super.b(2, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(yl var1, Set<Scope> var2_2) {
        try {
            var7_3 = this.o();
            var8_4 = new GetServiceRequest(this.w).a(this.i.getPackageName()).a(var7_3);
            if (var2_2 != null) {
                var8_4.a(var2_2);
            }
            if (this.s()) {
                var8_4.a(this.n()).a(var1);
            } else if (this.t()) {
                var8_4.a(this.m());
            }
            var15_6 = var11_5 = this.n;
            // MONITORENTER : var15_6
            ** if (this.o == null) goto lbl-1000
        }
        catch (DeadObjectException var5_7) {
            Log.w((String)"GmsClient", (String)"service died");
            this.b(1);
            return;
        }
lbl-1000: // 1 sources:
        {
            this.o.a((yo)new g((ya)this, this.b.get()), var8_4);
            // MONITOREXIT : var15_6
            return;
        }
lbl-1000: // 1 sources:
        {
        }
        Log.w((String)"GmsClient", (String)"mServiceBroker is null, client disconnected");
        return;
        catch (RemoteException var3_8) {
            Log.w((String)"GmsClient", (String)"Remote exception occurred", (Throwable)var3_8);
            return;
        }
    }

    public void b(int n2) {
        this.a.sendMessage(this.a.obtainMessage(4, this.b.get(), n2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b() {
        Object object;
        Object object2 = object = this.m;
        synchronized (object2) {
            if (this.t != 3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c() {
        Object object;
        Object object2 = object = this.m;
        synchronized (object2) {
            if (this.t != 2) return false;
            return true;
        }
    }

    public boolean d() {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public IBinder e() {
        Object object;
        Object object2 = object = this.n;
        synchronized (object2) {
            if (this.o != null) return this.o.asBinder();
            return null;
        }
    }

    protected abstract String f();

    protected abstract String g();

    protected String i() {
        return "com.google.android.gms";
    }

    protected final String j() {
        if (this.x == null) {
            return this.i.getClass().getName();
        }
        return this.x;
    }

    public void k() {
        int n2 = this.l.a(this.i);
        if (n2 != 0) {
            this.b(1, null);
            this.p = new i();
            this.a.sendMessage(this.a.obtainMessage(3, this.b.get(), n2));
            return;
        }
        this.a(new i());
    }

    public final Context l() {
        return this.i;
    }

    public Account m() {
        return null;
    }

    public final Account n() {
        if (this.m() != null) {
            return this.m();
        }
        return new Account("<<default account>>", "com.google");
    }

    protected Bundle o() {
        return new Bundle();
    }

    protected final void p() {
        if (!this.b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle q() {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final T r() throws DeadObjectException {
        Object object;
        Object object2 = object = this.m;
        synchronized (object2) {
            if (this.t == 4) {
                throw new DeadObjectException();
            }
            this.p();
            boolean bl2 = this.q != null;
            xr.a(bl2, (Object)"Client is connected but service is null");
            T t2 = this.q;
            return t2;
        }
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

    abstract class a
    extends e<Boolean> {
        public final int a;
        public final Bundle b;

        protected a(int n2, Bundle bundle) {
            super(true);
            this.a = n2;
            this.b = bundle;
        }

        @Override
        protected abstract void a(ConnectionResult var1);

        /*
         * Enabled aggressive block sorting
         */
        @Override
        protected void a(Boolean bl2) {
            if (bl2 == null) {
                ya.this.b(1, (T)null);
                return;
            }
            switch (this.a) {
                default: {
                    ya.this.b(1, (T)null);
                    Bundle bundle = this.b;
                    PendingIntent pendingIntent = null;
                    if (bundle != null) {
                        pendingIntent = (PendingIntent)this.b.getParcelable("pendingIntent");
                    }
                    this.a(new ConnectionResult(this.a, pendingIntent));
                    return;
                }
                case 0: {
                    if (this.a()) return;
                    {
                        ya.this.b(1, (T)null);
                        this.a(new ConnectionResult(8, null));
                        return;
                    }
                }
                case 10: 
            }
            ya.this.b(1, (T)null);
            throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
        }

        @Override
        protected /* synthetic */ void a(Object object) {
            this.a((Boolean)object);
        }

        protected abstract boolean a();

        @Override
        protected void b() {
        }
    }

    public static interface b {
        public void a(int var1);

        public void a(Bundle var1);
    }

    public static interface c {
        public void a(ConnectionResult var1);
    }

    final class d
    extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        private void a(Message message) {
            e e2 = (e)message.obj;
            e2.b();
            e2.d();
        }

        private boolean b(Message message) {
            if (message.what == 2 || message.what == 1 || message.what == 5) {
                return true;
            }
            return false;
        }

        public void handleMessage(Message message) {
            if (ya.this.b.get() != message.arg1) {
                if (super.b(message)) {
                    super.a(message);
                }
                return;
            }
            if (!(message.what != 1 && message.what != 5 || ya.this.c())) {
                super.a(message);
                return;
            }
            if (message.what == 3) {
                boolean bl2 = message.obj instanceof PendingIntent;
                PendingIntent pendingIntent = null;
                if (bl2) {
                    pendingIntent = (PendingIntent)message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                ya.this.p.a(connectionResult);
                ya.this.a(connectionResult);
                return;
            }
            if (message.what == 4) {
                ya.this.b(4, (T)null);
                if (ya.this.u != null) {
                    ya.this.u.a(message.arg2);
                }
                ya.this.a(message.arg2);
                ya.this.a(4, 1, (T)null);
                return;
            }
            if (message.what == 2 && !ya.this.b()) {
                super.a(message);
                return;
            }
            if (super.b(message)) {
                ((e)message.obj).c();
                return;
            }
            int n2 = message.what;
            Log.wtf((String)"GmsClient", (String)new StringBuilder(45).append("Don't know how to handle message: ").append(n2).toString(), (Throwable)new Exception());
        }
    }

    public abstract class e<TListener> {
        private TListener a;
        private boolean b;

        public e(TListener TListener) {
            this.a = TListener;
            this.b = false;
        }

        protected abstract void a(TListener var1);

        protected abstract void b();

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        public void c() {
            e e2 = this;
            // MONITORENTER : e2
            TListener TListener = this.a;
            if (this.b) {
                String string2 = String.valueOf((Object)this);
                Log.w((String)"GmsClient", (String)new StringBuilder(47 + String.valueOf((Object)string2).length()).append("Callback proxy ").append(string2).append(" being reused. This is not safe.").toString());
            }
            // MONITOREXIT : e2
            if (TListener != null) {
                try {
                    this.a(TListener);
                }
                catch (RuntimeException var4_4) {
                    this.b();
                    throw var4_4;
                }
            } else {
                this.b();
            }
            e2 = this;
            // MONITORENTER : e2
            this.b = true;
            // MONITOREXIT : e2
            this.d();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void d() {
            ArrayList arrayList;
            this.e();
            ArrayList arrayList2 = arrayList = ya.this.r;
            synchronized (arrayList2) {
                ya.this.r.remove((Object)this);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void e() {
            e e2 = this;
            synchronized (e2) {
                this.a = null;
                return;
            }
        }
    }

    public static interface f {
        public void a(ConnectionResult var1);
    }

    public static final class g
    extends yo.a {
        private ya a;
        private final int b;

        public g(ya ya2, int n2) {
            this.a = ya2;
            this.b = n2;
        }

        private void a() {
            this.a = null;
        }

        @Override
        public void a(int n2, Bundle bundle) {
            Log.wtf((String)"GmsClient", (String)"received deprecated onAccountValidationComplete callback, ignoring", (Throwable)new Exception());
        }

        @Override
        public void a(int n2, IBinder iBinder, Bundle bundle) {
            xr.a(this.a, (Object)"onPostInitComplete can be called only once per call to getRemoteService");
            this.a.a(n2, iBinder, bundle, this.b);
            super.a();
        }
    }

    public final class h
    implements ServiceConnection {
        private final int b;

        public h(int n2) {
            this.b = n2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Object object;
            xr.a(iBinder, (Object)"Expecting a valid IBinder");
            Object object2 = object = ya.this.n;
            synchronized (object2) {
                ya.this.o = yp.a.a(iBinder);
            }
            ya.this.a(0, null, this.b);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void onServiceDisconnected(ComponentName componentName) {
            Object object;
            Object object2 = object = ya.this.n;
            synchronized (object2) {
                ya.this.o = null;
            }
            ya.this.a.sendMessage(ya.this.a.obtainMessage(4, this.b, 1));
        }
    }

    public class i
    implements f {
        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(ConnectionResult connectionResult) {
            if (connectionResult.b()) {
                ya.this.a(null, ya.this.u());
                return;
            } else {
                if (ya.this.v == null) return;
                {
                    ya.this.v.a(connectionResult);
                    return;
                }
            }
        }
    }

    public final class j
    extends a {
        public final IBinder e;

        public j(int n2, IBinder iBinder, Bundle bundle) {
            super(n2, bundle);
            this.e = iBinder;
        }

        @Override
        protected void a(ConnectionResult connectionResult) {
            if (ya.this.v != null) {
                ya.this.v.a(connectionResult);
            }
            ya.this.a(connectionResult);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        protected boolean a() {
            String string2;
            try {
                string2 = this.e.getInterfaceDescriptor();
            }
            catch (RemoteException var1_3) {
                Log.w((String)"GmsClient", (String)"service probably died");
                return false;
            }
            if (!ya.this.g().equals((Object)string2)) {
                String string3 = String.valueOf((Object)ya.this.g());
                Log.e((String)"GmsClient", (String)new StringBuilder(34 + String.valueOf((Object)string3).length() + String.valueOf((Object)string2).length()).append("service descriptor mismatch: ").append(string3).append(" vs. ").append(string2).toString());
                return false;
            } else {
                Object t2 = ya.this.a(this.e);
                if (t2 == null || !ya.this.a(2, 3, (T)t2)) return false;
                {
                    Bundle bundle = ya.this.q();
                    if (ya.this.u == null) return true;
                    {
                        ya.this.u.a(bundle);
                    }
                    return true;
                }
            }
        }
    }

    public final class k
    extends a {
        public k(int n2, Bundle bundle) {
            super(n2, bundle);
        }

        @Override
        protected void a(ConnectionResult connectionResult) {
            ya.this.p.a(connectionResult);
            ya.this.a(connectionResult);
        }

        @Override
        protected boolean a() {
            ya.this.p.a(ConnectionResult.a);
            return true;
        }
    }

}

