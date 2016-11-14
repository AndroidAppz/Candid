package defpackage;

import android.os.IBinder;
import android.os.RemoteException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class abi {
    private static final aau$a<?, ?>[] b = new aau$a[0];
    final Set<aau$a<?, ?>> a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final abi$b c = new abi$1(this);
    private final Map<wx$d<?>, wx$f> d = new dh();

    public abi(wx$d<?> wx_d_, wx$f wx_f) {
        this.d.put(wx_d_, wx_f);
    }

    private static void a(aau$a<?, ?> aau_a___, xk xkVar, IBinder iBinder) {
        if (aau_a___.e()) {
            aau_a___.a(new abi$a(aau_a___, xkVar, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            aau_a___.a(null);
            aau_a___.f();
            xkVar.a(aau_a___.a().intValue());
        } else {
            Object abi_a = new abi$a(aau_a___, xkVar, iBinder, null);
            aau_a___.a((abi$b) abi_a);
            try {
                iBinder.linkToDeath(abi_a, 0);
            } catch (RemoteException e) {
                aau_a___.f();
                xkVar.a(aau_a___.a().intValue());
            }
        }
    }

    public void a() {
        for (aau$a aau_a : (aau$a[]) this.a.toArray(b)) {
            aau_a.a(null);
            if (aau_a.a() != null) {
                aau_a.c();
                abi.a(aau_a, null, ((wx$f) this.d.get(aau_a.b())).e());
                this.a.remove(aau_a);
            } else if (aau_a.g()) {
                this.a.remove(aau_a);
            }
        }
    }

    <A extends wx$c> void a(aau$a<? extends xc, A> aau_a__extends_xc__A) {
        this.a.add(aau_a__extends_xc__A);
        aau_a__extends_xc__A.a(this.c);
    }

    public boolean b() {
        for (aau$a e : (aau$a[]) this.a.toArray(b)) {
            if (!e.e()) {
                return true;
            }
        }
        return false;
    }
}
