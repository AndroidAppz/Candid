package defpackage;

import android.os.IBinder;

/* compiled from: CustomTabsSessionToken */
public class d {
    private final e a;
    private final a b = new d$1(this);

    public d(e callbackBinder) {
        this.a = callbackBinder;
    }

    public IBinder a() {
        return this.a.asBinder();
    }

    public int hashCode() {
        return a().hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof d) {
            return ((d) o).a().equals(this.a.asBinder());
        }
        return false;
    }
}
