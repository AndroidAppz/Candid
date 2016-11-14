package defpackage;

import java.io.IOException;
import java.util.Currency;

/* compiled from: TypeAdapters */
class ajk$18 extends aij<Currency> {
    ajk$18() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Currency a(ajn in) throws IOException {
        return Currency.getInstance(in.h());
    }

    public void a(ajo out, Currency value) throws IOException {
        out.b(value.getCurrencyCode());
    }
}
