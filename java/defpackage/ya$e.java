package defpackage;

import android.util.Log;

public abstract class ya$e<TListener> {
    private TListener a;
    private boolean b = false;
    final /* synthetic */ ya d;

    public ya$e(ya yaVar, TListener tListener) {
        this.d = yaVar;
        this.a = tListener;
    }

    protected abstract void a(TListener tListener);

    protected abstract void b();

    public void c() {
        synchronized (this) {
            Object obj = this.a;
            if (this.b) {
                String valueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e) {
                b();
                throw e;
            }
        }
        b();
        synchronized (this) {
            this.b = true;
        }
        d();
    }

    public void d() {
        e();
        synchronized (this.d.r) {
            this.d.r.remove(this);
        }
    }

    public void e() {
        synchronized (this) {
            this.a = null;
        }
    }
}
