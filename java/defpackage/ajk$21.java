package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: TypeAdapters */
class ajk$21 extends aij<Locale> {
    ajk$21() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Locale a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        StringTokenizer tokenizer = new StringTokenizer(in.h(), "_");
        String language = null;
        String country = null;
        String variant = null;
        if (tokenizer.hasMoreElements()) {
            language = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreElements()) {
            country = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreElements()) {
            variant = tokenizer.nextToken();
        }
        if (country == null && variant == null) {
            return new Locale(language);
        }
        if (variant == null) {
            return new Locale(language, country);
        }
        return new Locale(language, country, variant);
    }

    public void a(ajo out, Locale value) throws IOException {
        out.b(value == null ? null : value.toString());
    }
}
