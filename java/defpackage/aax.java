package defpackage;

import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;

public class aax extends aav {
    protected void a(ConnectionResult connectionResult, int i) {
        aay aay = null;
        aay.b(connectionResult, i);
    }

    public void b() {
        Object obj = null;
        super.b();
        Iterator it = obj.iterator();
        while (it.hasNext()) {
            ((xj) it.next()).a();
        }
        obj.clear();
        obj.a(this);
    }

    protected void c() {
        aay aay = null;
        aay.b();
    }
}
