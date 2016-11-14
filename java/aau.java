/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.DeadObjectException
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReference
 */
import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicReference;

public class aau {

    public static abstract class a<R extends xc, A extends wx.c>
    extends aaw<R> {
        private final wx.d<A> d;
        private AtomicReference<abi.b> e;

        private void a(RemoteException remoteException) {
            this.a(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public void a(abi.b b2) {
            this.e.set((Object)b2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public final void a(Status status) {
            boolean bl2 = !status.f();
            xr.b(bl2, "Failed result must not be success");
            Object r2 = this.b(status);
            this.b(r2);
            this.a((R)r2);
        }

        public final void a(A a2) throws DeadObjectException {
            try {
                this.b(a2);
                return;
            }
            catch (DeadObjectException var3_2) {
                super.a((RemoteException)var3_2);
                throw var3_2;
            }
            catch (RemoteException var2_3) {
                super.a(var2_3);
                return;
            }
        }

        protected void a(R r2) {
        }

        public final wx.d<A> b() {
            return this.d;
        }

        @Override
        protected abstract void b(A var1) throws RemoteException;

        public void c() {
            this.a((R)null);
        }

        @Override
        protected void d() {
            abi.b b2 = (abi.b)this.e.getAndSet((Object)null);
            if (b2 != null) {
                b2.a(this);
            }
        }
    }

}

