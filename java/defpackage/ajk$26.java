package defpackage;

/* compiled from: TypeAdapters */
class ajk$26 implements aik {
    final /* synthetic */ Class a;
    final /* synthetic */ Class b;
    final /* synthetic */ aij c;

    ajk$26(Class cls, Class cls2, aij aij) {
        this.a = cls;
        this.b = cls2;
        this.c = aij;
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        return (rawType == this.a || rawType == this.b) ? this.c : null;
    }

    public String toString() {
        return "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.c + "]";
    }
}
