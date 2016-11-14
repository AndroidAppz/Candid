/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonIOException
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.internal.LazilyParsedNumber
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.NoSuchFieldException
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.net.InetAddress
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.sql.Timestamp
 *  java.util.ArrayList
 *  java.util.BitSet
 *  java.util.Calendar
 *  java.util.Currency
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.StringTokenizer
 *  java.util.UUID
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicIntegerArray
 */
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class ajk {
    public static final aij<String> A;
    public static final aij<BigDecimal> B;
    public static final aij<BigInteger> C;
    public static final aik D;
    public static final aij<StringBuilder> E;
    public static final aik F;
    public static final aij<StringBuffer> G;
    public static final aik H;
    public static final aij<URL> I;
    public static final aik J;
    public static final aij<URI> K;
    public static final aik L;
    public static final aij<InetAddress> M;
    public static final aik N;
    public static final aij<UUID> O;
    public static final aik P;
    public static final aij<Currency> Q;
    public static final aik R;
    public static final aik S;
    public static final aij<Calendar> T;
    public static final aik U;
    public static final aij<Locale> V;
    public static final aik W;
    public static final aij<aid> X;
    public static final aik Y;
    public static final aik Z;
    public static final aij<Class> a;
    public static final aik b;
    public static final aij<BitSet> c;
    public static final aik d;
    public static final aij<Boolean> e;
    public static final aij<Boolean> f;
    public static final aik g;
    public static final aij<Number> h;
    public static final aik i;
    public static final aij<Number> j;
    public static final aik k;
    public static final aij<Number> l;
    public static final aik m;
    public static final aij<AtomicInteger> n;
    public static final aik o;
    public static final aij<AtomicBoolean> p;
    public static final aik q;
    public static final aij<AtomicIntegerArray> r;
    public static final aik s;
    public static final aij<Number> t;
    public static final aij<Number> u;
    public static final aij<Number> v;
    public static final aij<Number> w;
    public static final aik x;
    public static final aij<Character> y;
    public static final aik z;

    static {
        a = new aij<Class>(){

            public Class a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override
            public void a(ajo ajo2, Class class_) throws IOException {
                if (class_ == null) {
                    ajo2.f();
                    return;
                }
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + class_.getName() + ". Forgot to register a type adapter?");
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        b = ajk.a(Class.class, a);
        c = new aij<BitSet>(){

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public BitSet a(ajn ajn2) throws IOException {
                String string2;
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                BitSet bitSet = new BitSet();
                ajn2.a();
                int n2 = 0;
                JsonToken jsonToken = ajn2.f();
                do {
                    boolean bl2;
                    if (jsonToken == JsonToken.b) {
                        ajn2.b();
                        return bitSet;
                    }
                    switch (.a[jsonToken.ordinal()]) {
                        default: {
                            throw new JsonSyntaxException("Invalid bitset value type: " + (Object)jsonToken);
                        }
                        case 1: {
                            if (ajn2.m() != 0) {
                                bl2 = true;
                                break;
                            }
                            bl2 = false;
                            break;
                        }
                        case 2: {
                            bl2 = ajn2.i();
                            break;
                        }
                        case 3: {
                            string2 = ajn2.h();
                            int n3 = Integer.parseInt((String)string2);
                            bl2 = n3 != 0;
                        }
                    }
                    if (bl2) {
                        bitSet.set(n2);
                    }
                    ++n2;
                    jsonToken = ajn2.f();
                } while (true);
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + string2);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, BitSet bitSet) throws IOException {
                if (bitSet == null) {
                    ajo2.f();
                    return;
                }
                ajo2.b();
                int n2 = 0;
                do {
                    if (n2 >= bitSet.length()) {
                        ajo2.c();
                        return;
                    }
                    boolean bl2 = bitSet.get(n2);
                    ajo2.a((long)bl2 ? 1 : 0);
                    ++n2;
                } while (true);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        d = ajk.a(BitSet.class, c);
        e = new aij<Boolean>(){

            public Boolean a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                if (ajn2.f() == JsonToken.f) {
                    return Boolean.parseBoolean((String)ajn2.h());
                }
                return ajn2.i();
            }

            @Override
            public void a(ajo ajo2, Boolean bl2) throws IOException {
                if (bl2 == null) {
                    ajo2.f();
                    return;
                }
                ajo2.a(bl2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        f = new aij<Boolean>(){

            public Boolean a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return Boolean.valueOf((String)ajn2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, Boolean bl2) throws IOException {
                String string2 = bl2 == null ? "null" : bl2.toString();
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        g = ajk.a(Boolean.TYPE, Boolean.class, e);
        h = new aij<Number>(){

            public Number a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                try {
                    Byte by2 = Byte.valueOf((byte)((byte)ajn2.m()));
                    return by2;
                }
                catch (NumberFormatException var2_3) {
                    throw new JsonSyntaxException((Throwable)var2_3);
                }
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        i = ajk.a(Byte.TYPE, Byte.class, h);
        j = new aij<Number>(){

            public Number a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                try {
                    Short s2 = (short)ajn2.m();
                    return s2;
                }
                catch (NumberFormatException var2_3) {
                    throw new JsonSyntaxException((Throwable)var2_3);
                }
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        k = ajk.a(Short.TYPE, Short.class, j);
        l = new aij<Number>(){

            public Number a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                try {
                    Integer n2 = ajn2.m();
                    return n2;
                }
                catch (NumberFormatException var2_3) {
                    throw new JsonSyntaxException((Throwable)var2_3);
                }
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        m = ajk.a(Integer.TYPE, Integer.class, l);
        n = new aij<AtomicInteger>(){

            public AtomicInteger a(ajn ajn2) throws IOException {
                try {
                    AtomicInteger atomicInteger = new AtomicInteger(ajn2.m());
                    return atomicInteger;
                }
                catch (NumberFormatException var3_3) {
                    throw new JsonSyntaxException((Throwable)var3_3);
                }
            }

            @Override
            public void a(ajo ajo2, AtomicInteger atomicInteger) throws IOException {
                ajo2.a((long)atomicInteger.get());
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        }.a();
        o = ajk.a(AtomicInteger.class, n);
        p = new aij<AtomicBoolean>(){

            public AtomicBoolean a(ajn ajn2) throws IOException {
                return new AtomicBoolean(ajn2.i());
            }

            @Override
            public void a(ajo ajo2, AtomicBoolean atomicBoolean) throws IOException {
                ajo2.a(atomicBoolean.get());
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        }.a();
        q = ajk.a(AtomicBoolean.class, p);
        r = new aij<AtomicIntegerArray>(){

            public AtomicIntegerArray a(ajn ajn2) throws IOException {
                ArrayList arrayList = new ArrayList();
                ajn2.a();
                while (ajn2.e()) {
                    try {
                        arrayList.add((Object)ajn2.m());
                        continue;
                    }
                    catch (NumberFormatException var6_3) {
                        throw new JsonSyntaxException((Throwable)var6_3);
                    }
                }
                ajn2.b();
                int n2 = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(n2);
                for (int i2 = 0; i2 < n2; ++i2) {
                    atomicIntegerArray.set(i2, ((Integer)arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override
            public void a(ajo ajo2, AtomicIntegerArray atomicIntegerArray) throws IOException {
                ajo2.b();
                int n2 = atomicIntegerArray.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ajo2.a((long)atomicIntegerArray.get(i2));
                }
                ajo2.c();
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        }.a();
        s = ajk.a(AtomicIntegerArray.class, r);
        t = new aij<Number>(){

            public Number a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                try {
                    Long l2 = ajn2.l();
                    return l2;
                }
                catch (NumberFormatException var2_3) {
                    throw new JsonSyntaxException((Throwable)var2_3);
                }
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        u = new aij<Number>(){

            public Number a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return Float.valueOf((float)((float)ajn2.k()));
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        v = new aij<Number>(){

            public Number a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return ajn2.k();
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        w = new aij<Number>(){

            public Number a(ajn ajn2) throws IOException {
                JsonToken jsonToken = ajn2.f();
                switch (.a[jsonToken.ordinal()]) {
                    default: {
                        throw new JsonSyntaxException("Expecting number, got: " + (Object)jsonToken);
                    }
                    case 4: {
                        ajn2.j();
                        return null;
                    }
                    case 1: 
                }
                return new LazilyParsedNumber(ajn2.h());
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        x = ajk.a(Number.class, w);
        y = new aij<Character>(){

            public Character a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                String string2 = ajn2.h();
                if (string2.length() != 1) {
                    throw new JsonSyntaxException("Expecting character, got: " + string2);
                }
                return Character.valueOf((char)string2.charAt(0));
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, Character c2) throws IOException {
                String string2 = c2 == null ? null : String.valueOf((Object)c2);
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        z = ajk.a(Character.TYPE, Character.class, y);
        A = new aij<String>(){

            public String a(ajn ajn2) throws IOException {
                JsonToken jsonToken = ajn2.f();
                if (jsonToken == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                if (jsonToken == JsonToken.h) {
                    return Boolean.toString((boolean)ajn2.i());
                }
                return ajn2.h();
            }

            @Override
            public void a(ajo ajo2, String string2) throws IOException {
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        B = new aij<BigDecimal>(){

            public BigDecimal a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                try {
                    BigDecimal bigDecimal = new BigDecimal(ajn2.h());
                    return bigDecimal;
                }
                catch (NumberFormatException var3_3) {
                    throw new JsonSyntaxException((Throwable)var3_3);
                }
            }

            @Override
            public void a(ajo ajo2, BigDecimal bigDecimal) throws IOException {
                ajo2.a((Number)bigDecimal);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        C = new aij<BigInteger>(){

            public BigInteger a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                try {
                    BigInteger bigInteger = new BigInteger(ajn2.h());
                    return bigInteger;
                }
                catch (NumberFormatException var3_3) {
                    throw new JsonSyntaxException((Throwable)var3_3);
                }
            }

            @Override
            public void a(ajo ajo2, BigInteger bigInteger) throws IOException {
                ajo2.a((Number)bigInteger);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        D = ajk.a(String.class, A);
        E = new aij<StringBuilder>(){

            public StringBuilder a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return new StringBuilder(ajn2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, StringBuilder stringBuilder) throws IOException {
                String string2 = stringBuilder == null ? null : stringBuilder.toString();
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        F = ajk.a(StringBuilder.class, E);
        G = new aij<StringBuffer>(){

            public StringBuffer a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return new StringBuffer(ajn2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, StringBuffer stringBuffer) throws IOException {
                String string2 = stringBuffer == null ? null : stringBuffer.toString();
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        H = ajk.a(StringBuffer.class, G);
        I = new aij<URL>(){

            /*
             * Enabled aggressive block sorting
             */
            public URL a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                } else {
                    String string2 = ajn2.h();
                    if ("null".equals((Object)string2)) return null;
                    return new URL(string2);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, URL uRL) throws IOException {
                String string2 = uRL == null ? null : uRL.toExternalForm();
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        J = ajk.a(URL.class, I);
        K = new aij<URI>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public URI a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                try {
                    String string2 = ajn2.h();
                    if ("null".equals((Object)string2)) return null;
                    return new URI(string2);
                }
                catch (URISyntaxException var2_4) {
                    throw new JsonIOException((Throwable)var2_4);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, URI uRI) throws IOException {
                String string2 = uRI == null ? null : uRI.toASCIIString();
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        L = ajk.a(URI.class, K);
        M = new aij<InetAddress>(){

            public InetAddress a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return InetAddress.getByName((String)ajn2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, InetAddress inetAddress) throws IOException {
                String string2 = inetAddress == null ? null : inetAddress.getHostAddress();
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        N = ajk.b(InetAddress.class, M);
        O = new aij<UUID>(){

            public UUID a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return UUID.fromString((String)ajn2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, UUID uUID) throws IOException {
                String string2 = uUID == null ? null : uUID.toString();
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        P = ajk.a(UUID.class, O);
        Q = new aij<Currency>(){

            public Currency a(ajn ajn2) throws IOException {
                return Currency.getInstance((String)ajn2.h());
            }

            @Override
            public void a(ajo ajo2, Currency currency) throws IOException {
                ajo2.b(currency.getCurrencyCode());
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        }.a();
        R = ajk.a(Currency.class, Q);
        S = new aik(){

            @Override
            public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
                if (ajm2.getRawType() != Timestamp.class) {
                    return null;
                }
                return new aij<Timestamp>(ahz2.a(Date.class)){
                    final /* synthetic */ aij a;

                    public Timestamp a(ajn ajn2) throws IOException {
                        Date date = (Date)this.a.b(ajn2);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override
                    public void a(ajo ajo2, Timestamp timestamp) throws IOException {
                        this.a.a(ajo2, timestamp);
                    }

                    @Override
                    public /* synthetic */ Object b(ajn ajn2) throws IOException {
                        return this.a(ajn2);
                    }
                };
            }

        };
        T = new aij<Calendar>(){

            public Calendar a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                ajn2.c();
                int n2 = 0;
                int n3 = 0;
                int n4 = 0;
                int n5 = 0;
                int n6 = 0;
                int n7 = 0;
                while (ajn2.f() != JsonToken.d) {
                    String string2 = ajn2.g();
                    int n8 = ajn2.m();
                    if ("year".equals((Object)string2)) {
                        n2 = n8;
                        continue;
                    }
                    if ("month".equals((Object)string2)) {
                        n3 = n8;
                        continue;
                    }
                    if ("dayOfMonth".equals((Object)string2)) {
                        n4 = n8;
                        continue;
                    }
                    if ("hourOfDay".equals((Object)string2)) {
                        n5 = n8;
                        continue;
                    }
                    if ("minute".equals((Object)string2)) {
                        n6 = n8;
                        continue;
                    }
                    if (!"second".equals((Object)string2)) continue;
                    n7 = n8;
                }
                ajn2.d();
                return new GregorianCalendar(n2, n3, n4, n5, n6, n7);
            }

            @Override
            public void a(ajo ajo2, Calendar calendar) throws IOException {
                if (calendar == null) {
                    ajo2.f();
                    return;
                }
                ajo2.d();
                ajo2.a("year");
                ajo2.a((long)calendar.get(1));
                ajo2.a("month");
                ajo2.a((long)calendar.get(2));
                ajo2.a("dayOfMonth");
                ajo2.a((long)calendar.get(5));
                ajo2.a("hourOfDay");
                ajo2.a((long)calendar.get(11));
                ajo2.a("minute");
                ajo2.a((long)calendar.get(12));
                ajo2.a("second");
                ajo2.a((long)calendar.get(13));
                ajo2.e();
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        U = ajk.b(Calendar.class, GregorianCalendar.class, T);
        V = new aij<Locale>(){

            public Locale a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(ajn2.h(), "_");
                boolean bl2 = stringTokenizer.hasMoreElements();
                String string2 = null;
                if (bl2) {
                    string2 = stringTokenizer.nextToken();
                }
                boolean bl3 = stringTokenizer.hasMoreElements();
                String string3 = null;
                if (bl3) {
                    string3 = stringTokenizer.nextToken();
                }
                boolean bl4 = stringTokenizer.hasMoreElements();
                String string4 = null;
                if (bl4) {
                    string4 = stringTokenizer.nextToken();
                }
                if (string3 == null && string4 == null) {
                    return new Locale(string2);
                }
                if (string4 == null) {
                    return new Locale(string2, string3);
                }
                return new Locale(string2, string3, string4);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajo ajo2, Locale locale) throws IOException {
                String string2 = locale == null ? null : locale.toString();
                ajo2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        W = ajk.a(Locale.class, V);
        X = new aij<aid>(){

            @Override
            public aid a(ajn ajn2) throws IOException {
                switch (.a[ajn2.f().ordinal()]) {
                    default: {
                        throw new IllegalArgumentException();
                    }
                    case 3: {
                        return new aih(ajn2.h());
                    }
                    case 1: {
                        return new aih((Number)new LazilyParsedNumber(ajn2.h()));
                    }
                    case 2: {
                        return new aih(ajn2.i());
                    }
                    case 4: {
                        ajn2.j();
                        return aie.a;
                    }
                    case 5: {
                        aib aib2 = new aib();
                        ajn2.a();
                        while (ajn2.e()) {
                            aib2.a(this.a(ajn2));
                        }
                        ajn2.b();
                        return aib2;
                    }
                    case 6: 
                }
                aif aif2 = new aif();
                ajn2.c();
                while (ajn2.e()) {
                    aif2.a(ajn2.g(), this.a(ajn2));
                }
                ajn2.d();
                return aif2;
            }

            @Override
            public void a(ajo ajo2, aid aid2) throws IOException {
                if (aid2 == null || aid2.l()) {
                    ajo2.f();
                    return;
                }
                if (aid2.k()) {
                    aih aih2 = aid2.o();
                    if (aih2.q()) {
                        ajo2.a(aih2.b());
                        return;
                    }
                    if (aih2.a()) {
                        ajo2.a(aih2.h());
                        return;
                    }
                    ajo2.b(aih2.c());
                    return;
                }
                if (aid2.i()) {
                    ajo2.b();
                    Iterator<aid> iterator = aid2.n().iterator();
                    while (iterator.hasNext()) {
                        this.a(ajo2, (aid)iterator.next());
                    }
                    ajo2.c();
                    return;
                }
                if (aid2.j()) {
                    ajo2.d();
                    for (Map.Entry entry : aid2.m().a()) {
                        ajo2.a((String)entry.getKey());
                        this.a(ajo2, (aid)entry.getValue());
                    }
                    ajo2.e();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + (Object)aid2.getClass());
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
        Y = ajk.b(aid.class, X);
        Z = new aik(){

            @Override
            public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
                Class class_ = ajm2.getRawType();
                if (!Enum.class.isAssignableFrom(class_) || class_ == Enum.class) {
                    return null;
                }
                if (!class_.isEnum()) {
                    class_ = class_.getSuperclass();
                }
                return new a(class_);
            }
        };
    }

    public static <TT> aik a(final Class<TT> class_, final aij<TT> aij2) {
        return new aik(){

            @Override
            public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
                if (ajm2.getRawType() == class_) {
                    return aij2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_.getName() + ",adapter=" + aij2 + "]";
            }
        };
    }

    public static <TT> aik a(final Class<TT> class_, final Class<TT> class_2, final aij<? super TT> aij2) {
        return new aik(){

            @Override
            public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
                Class<T> class_3 = ajm2.getRawType();
                if (class_3 == class_ || class_3 == class_2) {
                    return aij2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_2.getName() + "+" + class_.getName() + ",adapter=" + aij2 + "]";
            }
        };
    }

    public static <T1> aik b(final Class<T1> class_, final aij<T1> aij2) {
        return new aik(){

            public <T2> aij<T2> a(ahz ahz2, ajm<T2> ajm2) {
                final Class<T2> class_2 = ajm2.getRawType();
                if (!class_.isAssignableFrom(class_2)) {
                    return null;
                }
                return new aij<T1>(){

                    @Override
                    public void a(ajo ajo2, T1 T1) throws IOException {
                        aij2.a(ajo2, T1);
                    }

                    @Override
                    public T1 b(ajn ajn2) throws IOException {
                        Object t2 = aij2.b(ajn2);
                        if (t2 != null && !class_2.isInstance(t2)) {
                            throw new JsonSyntaxException("Expected a " + class_2.getName() + " but was " + t2.getClass().getName());
                        }
                        return (T1)t2;
                    }
                };
            }

            public String toString() {
                return "Factory[typeHierarchy=" + class_.getName() + ",adapter=" + aij2 + "]";
            }

        };
    }

    public static <TT> aik b(final Class<TT> class_, final Class<? extends TT> class_2, final aij<? super TT> aij2) {
        return new aik(){

            @Override
            public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
                Class<T> class_3 = ajm2.getRawType();
                if (class_3 == class_ || class_3 == class_2) {
                    return aij2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_.getName() + "+" + class_2.getName() + ",adapter=" + aij2 + "]";
            }
        };
    }

    static final class a<T extends Enum<T>>
    extends aij<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public a(Class<T> class_) {
            try {
                Enum[] arrenum = (Enum[])class_.getEnumConstants();
                int n2 = arrenum.length;
                int n3 = 0;
                while (n3 < n2) {
                    Enum enum_ = arrenum[n3];
                    String string2 = enum_.name();
                    ain ain2 = (ain)class_.getField(string2).getAnnotation((Class)ain.class);
                    if (ain2 != null) {
                        string2 = ain2.a();
                        for (String string3 : ain2.b()) {
                            this.a.put((Object)string3, (Object)enum_);
                        }
                    }
                    this.a.put((Object)string2, (Object)enum_);
                    this.b.put((Object)enum_, (Object)string2);
                    ++n3;
                }
                return;
            }
            catch (NoSuchFieldException var2_12) {
                throw new AssertionError("Missing field in " + class_.getName(), (Throwable)var2_12);
            }
        }

        public T a(ajn ajn2) throws IOException {
            if (ajn2.f() == JsonToken.i) {
                ajn2.j();
                return null;
            }
            return (T)((Enum)this.a.get((Object)ajn2.h()));
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(ajo ajo2, T t2) throws IOException {
            String string2 = t2 == null ? null : (String)this.b.get(t2);
            ajo2.b(string2);
        }

        @Override
        public /* synthetic */ Object b(ajn ajn2) throws IOException {
            return this.a(ajn2);
        }
    }

}

