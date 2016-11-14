package defpackage;

import java.sql.Time;

/* compiled from: TimeTypeAdapter */
class aji$1 implements aik {
    aji$1() {
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        return typeToken.getRawType() == Time.class ? new aji() : null;
    }
}
