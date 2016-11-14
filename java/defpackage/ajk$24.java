package defpackage;

/* compiled from: TypeAdapters */
class ajk$24 implements aik {
    ajk$24() {
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
            return null;
        }
        if (!rawType.isEnum()) {
            rawType = rawType.getSuperclass();
        }
        return new ajk$a(rawType);
    }
}
