package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public abstract class aam {
    protected volatile int a = -1;

    public int a() {
        if (this.a < 0) {
            b();
        }
        return this.a;
    }

    public abstract aam a(aak aak) throws IOException;

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
    }

    public int b() {
        int c = c();
        this.a = c;
        return c;
    }

    protected int c() {
        return 0;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return d();
    }

    public aam d() throws CloneNotSupportedException {
        return (aam) super.clone();
    }

    public String toString() {
        return aan.a(this);
    }
}
