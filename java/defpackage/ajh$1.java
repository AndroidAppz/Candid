package defpackage;

import java.sql.Date;

/* compiled from: SqlDateTypeAdapter */
class ajh$1 implements aik {
    ajh$1() {
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        return typeToken.getRawType() == Date.class ? new ajh() : null;
    }
}
