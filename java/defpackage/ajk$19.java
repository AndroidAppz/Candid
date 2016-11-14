package defpackage;

import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters */
class ajk$19 implements aik {
    ajk$19() {
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        if (typeToken.getRawType() != Timestamp.class) {
            return null;
        }
        return new ajk$19$1(this, gson.a(Date.class));
    }
}
