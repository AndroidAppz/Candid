package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter */
public final class ajh extends aij<Date> {
    public static final aik a = new ajh$1();
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public synchronized Date a(ajn in) throws IOException {
        Date date;
        if (in.f() == JsonToken.i) {
            in.j();
            date = null;
        } else {
            try {
                date = new Date(this.b.parse(in.h()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    public synchronized void a(ajo out, Date value) throws IOException {
        out.b(value == null ? null : this.b.format(value));
    }
}
