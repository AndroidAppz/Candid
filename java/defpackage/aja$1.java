package defpackage;

import java.util.Date;

/* compiled from: DateTypeAdapter */
class aja$1 implements aik {
    aja$1() {
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        return typeToken.getRawType() == Date.class ? new aja() : null;
    }
}
