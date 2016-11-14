package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicReference;

public abstract class aau$a<R extends xc, A extends wx$c> extends aaw<R> {
    private final wx$d<A> d;
    private AtomicReference<abi$b> e;

    private void a(RemoteException remoteException) {
        a(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public void a(abi$b abi_b) {
        this.e.set(abi_b);
    }

    public final void a(Status status) {
        xr.b(!status.f(), "Failed result must not be success");
        xc b = b(status);
        b(b);
        a(b);
    }

    public final void a(A a) throws DeadObjectException {
        try {
            b(a);
        } catch (RemoteException e) {
            a(e);
            throw e;
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    protected void a(R r) {
    }

    public final wx$d<A> b() {
        return this.d;
    }

    protected abstract void b(A a) throws RemoteException;

    public void c() {
        a(null);
    }

    protected void d() {
        abi$b abi_b = (abi$b) this.e.getAndSet(null);
        if (abi_b != null) {
            abi_b.a(this);
        }
    }
}
