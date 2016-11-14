/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.FieldNamingPolicy
 *  com.google.gson.JsonIOException
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.LongSerializationPolicy
 *  com.google.gson.stream.JsonToken
 *  com.google.gson.stream.MalformedJsonException
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.atomic.AtomicLongArray
 */
import com.google.gson.FieldNamingPolicy;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class ahz {
    final aic a;
    final aii b;
    private final ThreadLocal<Map<ajm<?>, a<?>>> c = new ThreadLocal();
    private final Map<ajm<?>, aij<?>> d = Collections.synchronizedMap((Map)new HashMap());
    private final List<aik> e;
    private final air f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;

    public ahz() {
        this(ais.a, (ahy)FieldNamingPolicy.a, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.a, Collections.emptyList());
    }

    ahz(ais ais2, ahy ahy2, Map<Type, aia<?>> map, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, LongSerializationPolicy longSerializationPolicy, List<aik> list) {
        this.a = new aic(){};
        this.b = new aii(){};
        this.f = new air(map);
        this.g = bl2;
        this.i = bl4;
        this.h = bl5;
        this.j = bl6;
        this.k = bl7;
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)ajk.Y);
        arrayList.add((Object)ajf.a);
        arrayList.add((Object)ais2);
        arrayList.addAll(list);
        arrayList.add((Object)ajk.D);
        arrayList.add((Object)ajk.m);
        arrayList.add((Object)ajk.g);
        arrayList.add((Object)ajk.i);
        arrayList.add((Object)ajk.k);
        aij<Number> aij2 = ahz.a(longSerializationPolicy);
        arrayList.add((Object)ajk.a(Long.TYPE, Long.class, aij2));
        arrayList.add((Object)ajk.a(Double.TYPE, Double.class, super.a(bl8)));
        arrayList.add((Object)ajk.a(Float.TYPE, Float.class, super.b(bl8)));
        arrayList.add((Object)ajk.x);
        arrayList.add((Object)ajk.o);
        arrayList.add((Object)ajk.q);
        arrayList.add((Object)ajk.a(AtomicLong.class, ahz.a(aij2)));
        arrayList.add((Object)ajk.a(AtomicLongArray.class, ahz.b(aij2)));
        arrayList.add((Object)ajk.s);
        arrayList.add((Object)ajk.z);
        arrayList.add((Object)ajk.F);
        arrayList.add((Object)ajk.H);
        arrayList.add((Object)ajk.a(BigDecimal.class, ajk.B));
        arrayList.add((Object)ajk.a(BigInteger.class, ajk.C));
        arrayList.add((Object)ajk.J);
        arrayList.add((Object)ajk.L);
        arrayList.add((Object)ajk.P);
        arrayList.add((Object)ajk.R);
        arrayList.add((Object)ajk.W);
        arrayList.add((Object)ajk.N);
        arrayList.add((Object)ajk.d);
        arrayList.add((Object)aja.a);
        arrayList.add((Object)ajk.U);
        arrayList.add((Object)aji.a);
        arrayList.add((Object)ajh.a);
        arrayList.add((Object)ajk.S);
        arrayList.add((Object)aiy.a);
        arrayList.add((Object)ajk.b);
        arrayList.add((Object)new aiz(this.f));
        arrayList.add((Object)new aje(this.f, bl3));
        arrayList.add((Object)new ajb(this.f));
        arrayList.add((Object)ajk.Z);
        arrayList.add((Object)new ajg(this.f, ahy2, ais2));
        this.e = Collections.unmodifiableList((List)arrayList);
    }

    private static aij<AtomicLong> a(final aij<Number> aij2) {
        return new aij<AtomicLong>(){

            public AtomicLong a(ajn ajn2) throws IOException {
                return new AtomicLong(((Number)aij2.b(ajn2)).longValue());
            }

            @Override
            public void a(ajo ajo2, AtomicLong atomicLong) throws IOException {
                aij2.a(ajo2, atomicLong.get());
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        }.a();
    }

    private static aij<Number> a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.a) {
            return ajk.t;
        }
        return new aij<Number>(){

            public Number a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return ajn2.l();
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                if (number == null) {
                    ajo2.f();
                    return;
                }
                ajo2.b(number.toString());
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
    }

    private aij<Number> a(boolean bl2) {
        if (bl2) {
            return ajk.v;
        }
        return new aij<Number>(){

            public Double a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return ajn2.k();
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                if (number == null) {
                    ajo2.f();
                    return;
                }
                ahz.a(number.doubleValue());
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
    }

    static void a(double d2) {
        if (Double.isNaN((double)d2) || Double.isInfinite((double)d2)) {
            throw new IllegalArgumentException("" + d2 + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void a(Object object, ajn ajn2) {
        if (object != null) {
            try {
                if (ajn2.f() != JsonToken.j) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            }
            catch (MalformedJsonException var3_2) {
                throw new JsonSyntaxException((Throwable)var3_2);
            }
            catch (IOException var2_3) {
                throw new JsonIOException((Throwable)var2_3);
            }
        }
    }

    private static aij<AtomicLongArray> b(final aij<Number> aij2) {
        return new aij<AtomicLongArray>(){

            public AtomicLongArray a(ajn ajn2) throws IOException {
                ArrayList arrayList = new ArrayList();
                ajn2.a();
                while (ajn2.e()) {
                    arrayList.add((Object)((Number)aij2.b(ajn2)).longValue());
                }
                ajn2.b();
                int n2 = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(n2);
                for (int i2 = 0; i2 < n2; ++i2) {
                    atomicLongArray.set(i2, ((Long)arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }

            @Override
            public void a(ajo ajo2, AtomicLongArray atomicLongArray) throws IOException {
                ajo2.b();
                int n2 = atomicLongArray.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    aij2.a(ajo2, atomicLongArray.get(i2));
                }
                ajo2.c();
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        }.a();
    }

    private aij<Number> b(boolean bl2) {
        if (bl2) {
            return ajk.u;
        }
        return new aij<Number>(){

            public Float a(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return Float.valueOf((float)((float)ajn2.k()));
            }

            @Override
            public void a(ajo ajo2, Number number) throws IOException {
                if (number == null) {
                    ajo2.f();
                    return;
                }
                ahz.a(number.floatValue());
                ajo2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajn ajn2) throws IOException {
                return this.a(ajn2);
            }
        };
    }

    public <T> aij<T> a(aik aik2, ajm<T> ajm2) {
        boolean bl2 = this.e.contains((Object)aik2);
        boolean bl3 = false;
        if (!bl2) {
            bl3 = true;
        }
        for (aik aik3 : this.e) {
            if (!bl3) {
                if (aik3 != aik2) continue;
                bl3 = true;
                continue;
            }
            aij<T> aij2 = aik3.a((ahz)this, ajm2);
            if (aij2 == null) continue;
            return aij2;
        }
        throw new IllegalArgumentException("GSON cannot serialize " + ajm2);
    }

    public <T> aij<T> a(ajm<T> ajm2) {
        a a2;
        aij aij2 = (aij)this.d.get(ajm2);
        if (aij2 != null) {
            return aij2;
        }
        Map map = (Map)this.c.get();
        boolean bl2 = false;
        if (map == null) {
            map = new HashMap();
            this.c.set((Object)map);
            bl2 = true;
        }
        if ((a2 = (a)map.get(ajm2)) != null) {
            return a2;
        }
        try {
            a<T> a3 = new a<T>();
            map.put(ajm2, a3);
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                aij<T> aij3 = ((aik)iterator.next()).a((ahz)this, ajm2);
                if (aij3 == null) continue;
                a3.a(aij3);
                this.d.put(ajm2, aij3);
                return aij3;
            }
            throw new IllegalArgumentException("GSON cannot handle " + ajm2);
        }
        finally {
            map.remove(ajm2);
            if (bl2) {
                this.c.remove();
            }
        }
    }

    public <T> aij<T> a(Class<T> class_) {
        return this.a(ajm.get(class_));
    }

    public ajn a(Reader reader) {
        ajn ajn2 = new ajn(reader);
        ajn2.a(this.k);
        return ajn2;
    }

    public ajo a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        ajo ajo2 = new ajo(writer);
        if (this.j) {
            ajo2.c("  ");
        }
        ajo2.d(this.g);
        return ajo2;
    }

    public <T> T a(aid aid2, Class<T> class_) throws JsonSyntaxException {
        T t2 = this.a(aid2, (Type)class_);
        return (T)aiv.a(class_).cast(t2);
    }

    public <T> T a(aid aid2, Type type) throws JsonSyntaxException {
        if (aid2 == null) {
            return null;
        }
        return this.a(new ajc(aid2), type);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T> T a(ajn ajn2, Type type) throws JsonIOException, JsonSyntaxException {
        boolean bl2 = true;
        boolean bl3 = ajn2.p();
        ajn2.a(true);
        try {
            ajn2.f();
            bl2 = false;
            Object obj = this.a(ajm.get(type)).b(ajn2);
            return (T)obj;
        }
        catch (EOFException var8_6) {
            if (!bl2) throw new JsonSyntaxException((Throwable)var8_6);
            return null;
        }
        catch (IllegalStateException var7_8) {
            throw new JsonSyntaxException((Throwable)var7_8);
        }
        catch (IOException var5_9) {
            throw new JsonSyntaxException((Throwable)var5_9);
        }
        finally {
            ajn2.a(bl3);
        }
    }

    public <T> T a(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        ajn ajn2 = this.a(reader);
        T t2 = this.a(ajn2, type);
        ahz.a(t2, ajn2);
        return t2;
    }

    public <T> T a(String string2, Class<T> class_) throws JsonSyntaxException {
        T t2 = this.a(string2, (Type)class_);
        return (T)aiv.a(class_).cast(t2);
    }

    public <T> T a(String string2, Type type) throws JsonSyntaxException {
        if (string2 == null) {
            return null;
        }
        return this.a((Reader)new StringReader(string2), type);
    }

    public String a(aid aid2) {
        StringWriter stringWriter = new StringWriter();
        this.a(aid2, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public String a(Object object) {
        if (object == null) {
            return this.a(aie.a);
        }
        return this.a(object, (Type)object.getClass());
    }

    public String a(Object object, Type type) {
        StringWriter stringWriter = new StringWriter();
        this.a(object, type, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public void a(aid aid2, ajo ajo2) throws JsonIOException {
        boolean bl2 = ajo2.g();
        ajo2.b(true);
        boolean bl3 = ajo2.h();
        ajo2.c(this.h);
        boolean bl4 = ajo2.i();
        ajo2.d(this.g);
        try {
            aiw.a(aid2, ajo2);
            return;
        }
        catch (IOException var7_6) {
            throw new JsonIOException((Throwable)var7_6);
        }
        finally {
            ajo2.b(bl2);
            ajo2.c(bl3);
            ajo2.d(bl4);
        }
    }

    public void a(aid aid2, Appendable appendable) throws JsonIOException {
        try {
            this.a(aid2, this.a(aiw.a(appendable)));
            return;
        }
        catch (IOException var3_3) {
            throw new RuntimeException((Throwable)var3_3);
        }
    }

    public void a(Object object, Type type, ajo ajo2) throws JsonIOException {
        aij aij2 = this.a(ajm.get(type));
        boolean bl2 = ajo2.g();
        ajo2.b(true);
        boolean bl3 = ajo2.h();
        ajo2.c(this.h);
        boolean bl4 = ajo2.i();
        ajo2.d(this.g);
        try {
            aij2.a(ajo2, (Object)object);
            return;
        }
        catch (IOException var9_8) {
            throw new JsonIOException((Throwable)var9_8);
        }
        finally {
            ajo2.b(bl2);
            ajo2.c(bl3);
            ajo2.d(bl4);
        }
    }

    public void a(Object object, Type type, Appendable appendable) throws JsonIOException {
        try {
            this.a(object, type, this.a(aiw.a(appendable)));
            return;
        }
        catch (IOException var4_4) {
            throw new JsonIOException((Throwable)var4_4);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }

    static class a<T>
    extends aij<T> {
        private aij<T> a;

        a() {
        }

        public void a(aij<T> aij2) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = aij2;
        }

        @Override
        public void a(ajo ajo2, T t2) throws IOException {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            this.a.a(ajo2, t2);
        }

        @Override
        public T b(ajn ajn2) throws IOException {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            return this.a.b(ajn2);
        }
    }

}

