/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.util.Date
 *  java.util.Locale
 */
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class aja
extends aij<Date> {
    public static final aik a = new aik(){

        @Override
        public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
            if (ajm2.getRawType() == Date.class) {
                return new aja();
            }
            return null;
        }
    };
    private final DateFormat b = DateFormat.getDateTimeInstance((int)2, (int)2, (Locale)Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance((int)2, (int)2);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Date a(String string2) {
        void var10_2 = this;
        synchronized (var10_2) {
            try {
                Date date = this.c.parse(string2);
                return date;
            }
            catch (ParseException var3_5) {
                try {
                    Date date = this.b.parse(string2);
                    return date;
                }
                catch (ParseException var4_7) {
                    try {
                        Date date = ajl.a(string2, new ParsePosition(0));
                        return date;
                    }
                    catch (ParseException var5_9) {
                        throw new JsonSyntaxException(string2, (Throwable)var5_9);
                    }
                }
            }
        }
    }

    public Date a(ajn ajn2) throws IOException {
        if (ajn2.f() == JsonToken.i) {
            ajn2.j();
            return null;
        }
        return super.a(ajn2.h());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(ajo ajo2, Date date) throws IOException {
        void var6_3 = this;
        synchronized (var6_3) {
            if (date == null) {
                ajo2.f();
            } else {
                ajo2.b(this.b.format(date));
            }
            return;
        }
    }

    @Override
    public /* synthetic */ Object b(ajn ajn2) throws IOException {
        return this.a(ajn2);
    }

}

