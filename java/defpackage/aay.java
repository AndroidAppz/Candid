package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.Set;

public class aay implements Callback {
    private static final Object d = new Object();
    private static aay e;
    private long a;
    private long b;
    private long c;
    private final Context f;
    private final wv g;
    private int h;
    private final SparseArray<aay$c<?>> i;
    private final Map<aas<?>, aay$c<?>> j;
    private aax k;
    private final Set<aas<?>> l;
    private final Handler m;
    private final ReferenceQueue<xj<?>> n;
    private final SparseArray<aay$a> o;
    private aay$b p;

    public static aay a() {
        aay aay;
        synchronized (d) {
            aay = e;
        }
        return aay;
    }

    private void a(aar aar) {
        ((aay$c) this.i.get(aar.a)).a(aar);
    }

    private void a(xj<?> xjVar, int i) {
        aas d = xjVar.d();
        if (!this.j.containsKey(d)) {
            this.j.put(d, new aay$c(this, xjVar));
        }
        aay$c aay_c = (aay$c) this.j.get(d);
        aay_c.b(i);
        this.i.put(i, aay_c);
        aay_c.j();
        this.o.put(i, new aay$a(this, xjVar, i, this.n));
        if (this.p == null || !this.p.c.get()) {
            this.p = new aay$b(this.n, this.o);
            this.p.start();
        }
    }

    private void b(int i, boolean z) {
        aay$c aay_c = (aay$c) this.i.get(i);
        if (aay_c != null) {
            if (!z) {
                this.i.delete(i);
            }
            aay_c.a(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    private void d() {
        for (aay$c aay_c : this.j.values()) {
            aay_c.b();
            aay_c.j();
        }
    }

    public void a(int i, boolean z) {
        this.m.sendMessage(this.m.obtainMessage(7, i, z ? 1 : 2));
    }

    public void a(aat aat) {
        for (aas aas : aat.b()) {
            aay$c aay_c = (aay$c) this.j.get(aas);
            if (aay_c == null) {
                aat.f();
                return;
            } else if (aay_c.d()) {
                aat.a(aas, ConnectionResult.a);
            } else if (aay_c.c() != null) {
                aat.a(aas, aay_c.c());
            } else {
                aay_c.a(aat);
            }
        }
    }

    public void a(aax aax) {
        synchronized (d) {
            if (aax == null) {
                this.k = null;
                this.l.clear();
            }
        }
    }

    boolean a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.a() && !this.g.a(connectionResult.c())) {
            return false;
        }
        this.g.a(this.f, connectionResult, i);
        return true;
    }

    public void b() {
        this.m.sendMessage(this.m.obtainMessage(3));
    }

    public void b(ConnectionResult connectionResult, int i) {
        if (!a(connectionResult, i)) {
            this.m.sendMessage(this.m.obtainMessage(5, i, 0));
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                a((aat) message.obj);
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                b(i, z);
                break;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                d();
                break;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                a((aar) message.obj);
                break;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                if (this.i.get(message.arg1) != null) {
                    ((aay$c) this.i.get(message.arg1)).a(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                a((xj) message.obj, message.arg1);
                break;
            case um$h.CardView_contentPadding /*8*/:
                if (this.j.containsKey(message.obj)) {
                    ((aay$c) this.j.get(message.obj)).e();
                    break;
                }
                break;
            case um$h.CardView_contentPaddingLeft /*9*/:
                if (this.j.containsKey(message.obj)) {
                    ((aay$c) this.j.get(message.obj)).g();
                    break;
                }
                break;
            case um$h.CardView_contentPaddingRight /*10*/:
                if (this.j.containsKey(message.obj)) {
                    ((aay$c) this.j.get(message.obj)).i();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
