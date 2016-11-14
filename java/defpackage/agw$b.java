package defpackage;

import java.util.List;
import java.util.Map;

class agw$b implements Runnable {
    private final agw$a a;
    private final int b;
    private final Throwable c;
    private final byte[] d;
    private final String e;
    private final Map<String, List<String>> f;

    private agw$b(String str, agw$a agw_a, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        xr.a((Object) agw_a);
        this.a = agw_a;
        this.b = i;
        this.c = th;
        this.d = bArr;
        this.e = str;
        this.f = map;
    }

    public void run() {
        this.a.a(this.e, this.b, this.c, this.d, this.f);
    }
}
