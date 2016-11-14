package defpackage;

public final class wx<O extends wx$a> {
    private final wx$b<?, O> a;
    private final wx$i<?, O> b = null;
    private final wx$g<?> c;
    private final wx$j<?> d;
    private final String e;

    public <C extends wx$f> wx(String str, wx$b<C, O> wx_b_C__O, wx$g<C> wx_g_C) {
        xr.a((Object) wx_b_C__O, (Object) "Cannot construct an Api with a null ClientBuilder");
        xr.a((Object) wx_g_C, (Object) "Cannot construct an Api with a null ClientKey");
        this.e = str;
        this.a = wx_b_C__O;
        this.c = wx_g_C;
        this.d = null;
    }

    public wx$b<?, O> a() {
        xr.a(this.a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }

    public wx$i<?, O> b() {
        xr.a(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public wx$d<?> c() {
        if (this.c != null) {
            return this.c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.e;
    }
}
