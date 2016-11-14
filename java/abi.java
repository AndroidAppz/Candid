/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.Collections
 *  java.util.Map
 *  java.util.Set
 *  java.util.WeakHashMap
 */
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class abi {
    private static final aau.a<?, ?>[] b = new aau.a[0];
    final Set<aau.a<?, ?>> a = Collections.synchronizedSet((Set)Collections.newSetFromMap((Map)new WeakHashMap()));
    private final b c;
    private final Map<wx.d<?>, wx.f> d;

    public abi(wx.d<?> d2, wx.f f2) {
        this.c = new b(){

            @Override
            public void a(aau.a<?, ?> a2) {
                abi.this.a.remove(a2);
                if (a2.a() != null && abi.a(abi.this) != null) {
                    abi.a(abi.this).a(a2.a());
                }
            }
        };
        this.d = new dh();
        this.d.put(d2, (Object)f2);
    }

    static /* synthetic */ xk a(abi abi2) {
        return null;
    }

    private static void a(aau.a<?, ?> a2, xk xk2, IBinder iBinder) {
        if (a2.e()) {
            a2.a(new a(a2, xk2, iBinder, null));
            return;
        }
        if (iBinder != null && iBinder.isBinderAlive()) {
            a a3 = new a(a2, xk2, iBinder, null);
            a2.a(a3);
            try {
                iBinder.linkToDeath((IBinder.DeathRecipient)a3, 0);
                return;
            }
            catch (RemoteException var4_4) {
                a2.f();
                xk2.a(a2.a());
                return;
            }
        }
        a2.a((b)null);
        a2.f();
        xk2.a(a2.a());
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        aau.a[] arra = (aau.a[])this.a.toArray(b);
        int n2 = arra.length;
        int n3 = 0;
        while (n3 < n2) {
            aau.a a2 = arra[n3];
            a2.a((b)null);
            if (a2.a() == null) {
                if (a2.g()) {
                    this.a.remove((Object)a2);
                }
            } else {
                a2.c();
                abi.a(a2, null, ((wx.f)this.d.get(a2.b())).e());
                this.a.remove((Object)a2);
            }
            ++n3;
        }
    }

    <A extends wx.c> void a(aau.a<? extends xc, A> a2) {
        this.a.add(a2);
        a2.a(this.c);
    }

    public boolean b() {
        aau.a[] arra = (aau.a[])this.a.toArray(b);
        int n2 = arra.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arra[i2].e()) continue;
            return true;
        }
        return false;
    }

    static class a
    implements b,
    IBinder.DeathRecipient {
        private final WeakReference<aau.a<?, ?>> a;
        private final WeakReference<xk> b;
        private final WeakReference<IBinder> c;

        private a(aau.a<?, ?> a2, xk xk2, IBinder iBinder) {
            this.b = new WeakReference((Object)xk2);
            this.a = new WeakReference(a2);
            this.c = new WeakReference((Object)iBinder);
        }

        /* synthetic */ a(aau.a a2, xk xk2, IBinder iBinder,  var4) {
            super(a2, xk2, iBinder);
        }

        private void a() {
            aau.a a2 = (aau.a)this.a.get();
            xk xk2 = (xk)this.b.get();
            if (xk2 != null && a2 != null) {
                xk2.a(a2.a());
            }
            IBinder iBinder = (IBinder)this.c.get();
            if (this.c != null) {
                iBinder.unlinkToDeath((IBinder.DeathRecipient)this, 0);
            }
        }

        @Override
        public void a(aau.a<?, ?> a2) {
            super.a();
        }

        public void binderDied() {
            this.a();
        }
    }

    static interface b {
        public void a(aau.a<?, ?> var1);
    }

}

