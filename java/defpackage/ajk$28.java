package defpackage;

/* compiled from: TypeAdapters */
class ajk$28 implements aik {
    final /* synthetic */ Class a;
    final /* synthetic */ aij b;

    ajk$28(Class cls, aij aij) {
        this.a = cls;
        this.b = aij;
    }

    public <T2> aij<T2> a(ahz gson, ajm<T2> typeToken) {
        Class<? super T2> requestedType = typeToken.getRawType();
        if (this.a.isAssignableFrom(requestedType)) {
            return new ajk$28$1(this, requestedType);
        }
        return null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}
