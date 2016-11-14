package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: TypeAdapters */
class ajk$20 extends aij<Calendar> {
    ajk$20() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Calendar a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        in.c();
        int year = 0;
        int month = 0;
        int dayOfMonth = 0;
        int hourOfDay = 0;
        int minute = 0;
        int second = 0;
        while (in.f() != JsonToken.d) {
            String name = in.g();
            int value = in.m();
            if ("year".equals(name)) {
                year = value;
            } else if ("month".equals(name)) {
                month = value;
            } else if ("dayOfMonth".equals(name)) {
                dayOfMonth = value;
            } else if ("hourOfDay".equals(name)) {
                hourOfDay = value;
            } else if ("minute".equals(name)) {
                minute = value;
            } else if ("second".equals(name)) {
                second = value;
            }
        }
        in.d();
        return new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    public void a(ajo out, Calendar value) throws IOException {
        if (value == null) {
            out.f();
            return;
        }
        out.d();
        out.a("year");
        out.a((long) value.get(1));
        out.a("month");
        out.a((long) value.get(2));
        out.a("dayOfMonth");
        out.a((long) value.get(5));
        out.a("hourOfDay");
        out.a((long) value.get(11));
        out.a("minute");
        out.a((long) value.get(12));
        out.a("second");
        out.a((long) value.get(13));
        out.e();
    }
}
