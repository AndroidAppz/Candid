package defpackage;

public final class agr$a<V> {
    private final V a;
    private final abj<V> b;
    private final String c;

    private agr$a(String str, abj<V> abj_V, V v) {
        xr.a((Object) abj_V);
        this.b = abj_V;
        this.a = v;
        this.c = str;
    }

    static agr$a<Integer> a(String str, int i) {
        return agr$a.a(str, i, i);
    }

    static agr$a<Integer> a(String str, int i, int i2) {
        return new agr$a(str, abj.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static agr$a<Long> a(String str, long j) {
        return agr$a.a(str, j, j);
    }

    static agr$a<Long> a(String str, long j, long j2) {
        return new agr$a(str, abj.a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static agr$a<String> a(String str, String str2) {
        return agr$a.a(str, str2, str2);
    }

    static agr$a<String> a(String str, String str2, String str3) {
        return new agr$a(str, abj.a(str, str3), str2);
    }

    static agr$a<Boolean> a(String str, boolean z) {
        return agr$a.a(str, z, z);
    }

    static agr$a<Boolean> a(String str, boolean z, boolean z2) {
        return new agr$a(str, abj.a(str, z2), Boolean.valueOf(z));
    }

    public V a(V v) {
        return v != null ? v : this.a;
    }

    public String a() {
        return this.c;
    }

    public V b() {
        return this.a;
    }
}
