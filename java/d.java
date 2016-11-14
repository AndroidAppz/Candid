/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  java.lang.Object
 */
import android.os.IBinder;

public class d {
    private final e a;
    private final a b;

    public d(e e2) {
        this.a = e2;
        this.b = new a(){};
    }

    public IBinder a() {
        return this.a.asBinder();
    }

    public boolean equals(Object object) {
        if (!(object instanceof d)) {
            return false;
        }
        return ((d)object).a().equals((Object)this.a.asBinder());
    }

    public int hashCode() {
        return this.a().hashCode();
    }

}

