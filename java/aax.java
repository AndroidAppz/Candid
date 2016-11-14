/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  java.lang.Object
 *  java.util.Iterator
 */
import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;

public class aax
extends aav {
    @Override
    protected void a(ConnectionResult connectionResult, int n2) {
        ((aay)null).b(connectionResult, n2);
    }

    @Override
    public void b() {
        super.b();
        Iterator iterator = ((zd)null).iterator();
        while (iterator.hasNext()) {
            ((xj)iterator.next()).a();
        }
        ((zd)null).clear();
        ((aay)null).a(this);
    }

    @Override
    protected void c() {
        ((aay)null).b();
    }
}

