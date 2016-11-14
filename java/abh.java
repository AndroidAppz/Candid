/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.api.Status
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.Future
 */
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

public class abh<R extends xc>
extends xg<R>
implements xd<R> {
    private xf<? super R, ? extends xc> a;
    private abh<? extends xc> b;
    private volatile xe<? super R> c;
    private xa<R> d;
    private final Object e;
    private Status f;
    private final WeakReference<wz> g;
    private final a h;
    private boolean i;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a() {
        if (this.a == null && this.c == null) {
            return;
        }
        wz wz2 = (wz)this.g.get();
        if (!this.i && this.a != null && wz2 != null) {
            wz2.a(this);
            this.i = true;
        }
        if (this.f != null) {
            this.b(this.f);
            return;
        }
        if (this.d == null) return;
        this.d.a(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    private void a(Status status) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            this.f = status;
            super.b(this.f);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Status status) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            if (this.a != null) {
                Status status2 = this.a.a(status);
                xr.a(status2, (Object)"onFailure must not return null");
                super.a(status2);
            } else if (super.b()) {
                this.c.a(status);
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void b(xc xc2) {
        if (!(xc2 instanceof xb)) return;
        try {
            ((xb)((Object)xc2)).a();
            return;
        }
        catch (RuntimeException var2_2) {
            String string2 = String.valueOf((Object)xc2);
            Log.w((String)"TransformedResultImpl", (String)new StringBuilder(18 + String.valueOf((Object)string2).length()).append("Unable to release ").append(string2).toString(), (Throwable)var2_2);
            return;
        }
    }

    private boolean b() {
        wz wz2 = (wz)this.g.get();
        if (this.c != null && wz2 != null) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(xa<?> xa2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            this.d = xa2;
            super.a();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(R r2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            if (r2.a().f()) {
                if (this.a != null) {
                    abf.a().submit(new Runnable((xc)r2){
                        final /* synthetic */ xc a;

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         * Lifted jumps to return sites
                         */
                        public void run() {
                            try {
                                aaw.a.set((Object)true);
                                xa xa2 = abh.this.a.a(this.a);
                                abh.this.h.sendMessage(abh.this.h.obtainMessage(0, xa2));
                                return;
                            }
                            catch (RuntimeException var3_3) {
                                abh.this.h.sendMessage(abh.this.h.obtainMessage(1, (Object)var3_3));
                                return;
                            }
                            finally {
                                aaw.a.set((Object)false);
                                abh.this.b(this.a);
                                wz wz2 = (wz)abh.this.g.get();
                                if (wz2 == null) return;
                                wz2.b(abh.this);
                            }
                        }
                    });
                } else if (super.b()) {
                    this.c.b(r2);
                }
            } else {
                super.a(r2.a());
                super.b((xc)r2);
            }
            return;
        }
    }

    final class a
    extends Handler {
        final /* synthetic */ abh a;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void handleMessage(Message message) {
            switch (message.what) {
                default: {
                    int n2 = message.what;
                    Log.e((String)"TransformedResultImpl", (String)new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(n2).toString());
                    return;
                }
                case 0: {
                    Object object;
                    xa xa2 = (xa)message.obj;
                    Object object2 = object = this.a.e;
                    synchronized (object2) {
                        if (xa2 == null) {
                            this.a.b.a(new Status(13, "Transform returned null"));
                        } else if (xa2 instanceof abg) {
                            this.a.b.a(((abg)xa2).b());
                        } else {
                            this.a.b.a(xa2);
                        }
                        return;
                    }
                }
                case 1: 
            }
            RuntimeException runtimeException = (RuntimeException)message.obj;
            String string2 = String.valueOf((Object)runtimeException.getMessage());
            String string3 = string2.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(string2) : new String("Runtime exception on the transformation worker thread: ");
            Log.e((String)"TransformedResultImpl", (String)string3);
            throw runtimeException;
        }
    }

}

