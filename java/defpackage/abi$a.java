package defpackage;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import java.lang.ref.WeakReference;

class abi$a implements abi$b, DeathRecipient {
    private final WeakReference<aau$a<?, ?>> a;
    private final WeakReference<xk> b;
    private final WeakReference<IBinder> c;

    private abi$a(aau$a<?, ?> aau_a___, xk xkVar, IBinder iBinder) {
        this.b = new WeakReference(xkVar);
        this.a = new WeakReference(aau_a___);
        this.c = new WeakReference(iBinder);
    }

    private void a() {
        aau$a aau_a = (aau$a) this.a.get();
        xk xkVar = (xk) this.b.get();
        if (!(xkVar == null || aau_a == null)) {
            xkVar.a(aau_a.a().intValue());
        }
        IBinder iBinder = (IBinder) this.c.get();
        if (this.c != null) {
            iBinder.unlinkToDeath(this, 0);
        }
    }

    public void a(aau$a<?, ?> aau_a___) {
        a();
    }

    public void binderDied() {
        a();
    }
}
