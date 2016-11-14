package defpackage;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters */
class ajk$19$1 extends aij<Timestamp> {
    final /* synthetic */ aij a;
    final /* synthetic */ ajk$19 b;

    ajk$19$1(ajk$19 this$0, aij aij) {
        this.b = this$0;
        this.a = aij;
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Timestamp a(ajn in) throws IOException {
        Date date = (Date) this.a.b(in);
        return date != null ? new Timestamp(date.getTime()) : null;
    }

    public void a(ajo out, Timestamp value) throws IOException {
        this.a.a(out, value);
    }
}
