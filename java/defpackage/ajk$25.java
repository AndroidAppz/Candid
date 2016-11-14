package defpackage;

/* compiled from: TypeAdapters */
class ajk$25 implements aik {
    final /* synthetic */ Class a;
    final /* synthetic */ aij b;

    ajk$25(Class cls, aij aij) {
        this.a = cls;
        this.b = aij;
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        return typeToken.getRawType() == this.a ? this.b : null;
    }

    public String toString() {
        return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}
