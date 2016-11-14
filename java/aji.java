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
 *  java.sql.Time
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Date
 */
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class aji
extends aij<Time> {
    public static final aik a = new aik(){

        @Override
        public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
            if (ajm2.getRawType() == Time.class) {
                return new aji();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Time a(ajn ajn2) throws IOException {
        void var5_2 = this;
        synchronized (var5_2) {
            if (ajn2.f() == JsonToken.i) {
                ajn2.j();
                return null;
            }
            try {
                return new Time(this.b.parse(ajn2.h()).getTime());
            }
            catch (ParseException var4_4) {
                throw new JsonSyntaxException((Throwable)var4_4);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(ajo ajo2, Time time) throws IOException {
        void var7_3 = this;
        synchronized (var7_3) {
            String string2;
            String string3 = time == null ? null : (string2 = this.b.format((Date)time));
            ajo2.b(string3);
            return;
        }
    }

    @Override
    public /* synthetic */ Object b(ajn ajn2) throws IOException {
        return this.a(ajn2);
    }

}

