/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteException
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.common.api.Status
 *  java.lang.Boolean
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.concurrent.CountDownLatch
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class aaw<R extends xc>
extends xa<R> {
    static final ThreadLocal<Boolean> a = new ThreadLocal<Boolean>(){

        protected Boolean a() {
            return false;
        }

        protected /* synthetic */ Object initialValue() {
            return this.a();
        }
    };
    protected final a<R> b = new a(Looper.getMainLooper());
    protected final WeakReference<wz> c = new WeakReference((Object)null);
    private final Object d = new Object();
    private final CountDownLatch e = new CountDownLatch(1);
    private final ArrayList<xa.a> f = new ArrayList();
    private xd<? super R> g;
    private R h;
    private b i;
    private volatile boolean j;
    private boolean k;
    private boolean l;
    private ym m;
    private volatile abh<R> n;
    private boolean o = false;

    @Deprecated
    aaw() {
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(R r2) {
        this.h = r2;
        this.m = null;
        this.e.countDown();
        Status status = this.h.a();
        if (this.k) {
            this.g = null;
        } else if (this.g == null) {
            if (this.h instanceof xb) {
                this.i = new b((aaw)this, null);
            }
        } else {
            this.b.a();
            this.b.a(this.g, (R)super.b());
        }
        Iterator iterator = this.f.iterator();
        do {
            if (!iterator.hasNext()) {
                this.f.clear();
                return;
            }
            ((xa.a)iterator.next()).a(status);
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private R b() {
        Object object;
        R r2;
        boolean bl2 = true;
        Object object2 = object = this.d;
        synchronized (object2) {
            if (this.j) {
                bl2 = false;
            }
            xr.a(bl2, (Object)"Result has already been consumed.");
            xr.a(this.e(), (Object)"Result is not ready.");
            r2 = this.h;
            this.h = null;
            this.g = null;
            this.j = true;
        }
        this.d();
        return r2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void c(xc xc2) {
        if (!(xc2 instanceof xb)) return;
        try {
            ((xb)((Object)xc2)).a();
            return;
        }
        catch (RuntimeException var1_1) {
            String string = String.valueOf((Object)xc2);
            Log.w((String)"BasePendingResult", (String)new StringBuilder(18 + String.valueOf((Object)string).length()).append("Unable to release ").append(string).toString(), (Throwable)var1_1);
            return;
        }
    }

    @Override
    public Integer a() {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void a(xd<? super R> xd2) {
        Object object;
        boolean bl2 = true;
        Object object2 = object = this.d;
        synchronized (object2) {
            if (xd2 == null) {
                this.g = null;
                return;
            }
            boolean bl3 = !this.j ? bl2 : false;
            xr.a(bl3, (Object)"Result has already been consumed.");
            if (this.n != null) {
                bl2 = false;
            }
            xr.a(bl2, (Object)"Cannot set callbacks if then() has been called.");
            if (this.h()) {
                return;
            }
            if (this.e()) {
                this.b.a(xd2, (R)super.b());
            } else {
                this.g = xd2;
            }
            return;
        }
    }

    protected abstract R b(Status var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(R r2) {
        Object object;
        boolean bl2 = true;
        Object object2 = object = this.d;
        synchronized (object2) {
            if (this.l || this.k || this.e() && this.i()) {
                aaw.c(r2);
                return;
            }
            boolean bl3 = !this.e() ? bl2 : false;
            xr.a(bl3, (Object)"Results have already been set");
            if (this.j) {
                bl2 = false;
            }
            xr.a(bl2, (Object)"Result has already been consumed");
            super.a(r2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void c(Status status) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            if (!this.e()) {
                this.b(this.b(status));
                this.l = true;
            }
            return;
        }
    }

    protected void d() {
    }

    public final boolean e() {
        if (this.e.getCount() == 0) {
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void f() {
        var5_2 = var1_1 = this.d;
        synchronized (var5_2) {
            if (this.k || this.j) {
                return;
            }
            var3_3 = this.m;
            if (var3_3 != null) {
                this.m.a();
            }
lbl10: // 4 sources:
            do {
                aaw.c(this.h);
                this.k = true;
                this.a(this.b(Status.e));
                return;
                break;
            } while (true);
            catch (Throwable var2_4) {}
            {
                throw var2_4;
            }
            {
                catch (RemoteException var4_5) {
                    ** continue;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean g() {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            if ((wz)this.c.get() != null) {
                if (this.o) return this.h();
            }
            this.f();
            return this.h();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean h() {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return this.k;
        }
    }

    boolean i() {
        return false;
    }

    public static class a<R extends xc>
    extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            this.removeMessages(2);
        }

        public void a(xd<? super R> xd2, R r2) {
            this.sendMessage(this.obtainMessage(1, (Object)new Pair(xd2, r2)));
        }

        protected void b(xd<? super R> xd2, R r2) {
            try {
                xd2.a(r2);
                return;
            }
            catch (RuntimeException var3_3) {
                aaw.c(r2);
                throw var3_3;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                default: {
                    int n2 = message.what;
                    Log.wtf((String)"BasePendingResult", (String)new StringBuilder(45).append("Don't know how to handle message: ").append(n2).toString(), (Throwable)new Exception());
                    return;
                }
                case 1: {
                    Pair pair = (Pair)message.obj;
                    this.b((xd)pair.first, (xc)pair.second);
                    return;
                }
                case 2: 
            }
            ((aaw)message.obj).c(Status.d);
        }
    }

    final class b {
        final /* synthetic */ aaw a;

        private b(aaw aaw2) {
            this.a = aaw2;
        }

        /* synthetic */ b(aaw aaw2,  var2_2) {
            super(aaw2);
        }

        protected void finalize() throws Throwable {
            aaw.c(this.a.h);
            super.finalize();
        }
    }

}

