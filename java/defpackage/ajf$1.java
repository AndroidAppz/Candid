package defpackage;

/* compiled from: ObjectTypeAdapter */
class ajf$1 implements aik {
    ajf$1() {
    }

    public <T> aij<T> a(ahz gson, ajm<T> type) {
        if (type.getRawType() == Object.class) {
            return new ajf(gson);
        }
        return null;
    }
}
