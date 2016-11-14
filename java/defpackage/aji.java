package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: TimeTypeAdapter */
public final class aji extends aij<Time> {
    public static final aik a = new aji$1();
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public synchronized Time a(ajn in) throws IOException {
        Time time;
        if (in.f() == JsonToken.i) {
            in.j();
            time = null;
        } else {
            try {
                time = new Time(this.b.parse(in.h()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    public synchronized void a(ajo out, Time value) throws IOException {
        out.b(value == null ? null : this.b.format(value));
    }
}
