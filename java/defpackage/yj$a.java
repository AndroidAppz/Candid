package defpackage;

import android.content.ComponentName;
import android.content.Intent;

final class yj$a {
    private final String a;
    private final String b;
    private final ComponentName c = null;

    public yj$a(String str, String str2) {
        this.a = xr.a(str);
        this.b = xr.a(str2);
    }

    public Intent a() {
        return this.a != null ? new Intent(this.a).setPackage(this.b) : new Intent().setComponent(this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yj$a)) {
            return false;
        }
        yj$a yj_a = (yj$a) obj;
        return yu.a(this.a, yj_a.a) && yu.a(this.c, yj_a.c);
    }

    public int hashCode() {
        return yu.a(this.a, this.c);
    }

    public String toString() {
        return this.a == null ? this.c.flattenToString() : this.a;
    }
}
