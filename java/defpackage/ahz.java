package defpackage;

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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
public final class ahz {
    final aic a;
    final aii b;
    private final ThreadLocal<Map<ajm<?>, ahz$a<?>>> c;
    private final Map<ajm<?>, aij<?>> d;
    private final List<aik> e;
    private final air f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;

    public ahz() {
        this(ais.a, FieldNamingPolicy.a, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.a, Collections.emptyList());
    }

    ahz(ais excluder, ahy fieldNamingPolicy, Map<Type, aia<?>> instanceCreators, boolean serializeNulls, boolean complexMapKeySerialization, boolean generateNonExecutableGson, boolean htmlSafe, boolean prettyPrinting, boolean lenient, boolean serializeSpecialFloatingPointValues, LongSerializationPolicy longSerializationPolicy, List<aik> typeAdapterFactories) {
        this.c = new ThreadLocal();
        this.d = Collections.synchronizedMap(new HashMap());
        this.a = new ahz$1(this);
        this.b = new ahz$2(this);
        this.f = new air(instanceCreators);
        this.g = serializeNulls;
        this.i = generateNonExecutableGson;
        this.h = htmlSafe;
        this.j = prettyPrinting;
        this.k = lenient;
        List<aik> factories = new ArrayList();
        factories.add(ajk.Y);
        factories.add(ajf.a);
        factories.add(excluder);
        factories.addAll(typeAdapterFactories);
        factories.add(ajk.D);
        factories.add(ajk.m);
        factories.add(ajk.g);
        factories.add(ajk.i);
        factories.add(ajk.k);
        aij longAdapter = ahz.a(longSerializationPolicy);
        factories.add(ajk.a(Long.TYPE, Long.class, longAdapter));
        factories.add(ajk.a(Double.TYPE, Double.class, a(serializeSpecialFloatingPointValues)));
        factories.add(ajk.a(Float.TYPE, Float.class, b(serializeSpecialFloatingPointValues)));
        factories.add(ajk.x);
        factories.add(ajk.o);
        factories.add(ajk.q);
        factories.add(ajk.a(AtomicLong.class, ahz.a(longAdapter)));
        factories.add(ajk.a(AtomicLongArray.class, ahz.b(longAdapter)));
        factories.add(ajk.s);
        factories.add(ajk.z);
        factories.add(ajk.F);
        factories.add(ajk.H);
        factories.add(ajk.a(BigDecimal.class, ajk.B));
        factories.add(ajk.a(BigInteger.class, ajk.C));
        factories.add(ajk.J);
        factories.add(ajk.L);
        factories.add(ajk.P);
        factories.add(ajk.R);
        factories.add(ajk.W);
        factories.add(ajk.N);
        factories.add(ajk.d);
        factories.add(aja.a);
        factories.add(ajk.U);
        factories.add(aji.a);
        factories.add(ajh.a);
        factories.add(ajk.S);
        factories.add(aiy.a);
        factories.add(ajk.b);
        factories.add(new aiz(this.f));
        factories.add(new aje(this.f, complexMapKeySerialization));
        factories.add(new ajb(this.f));
        factories.add(ajk.Z);
        factories.add(new ajg(this.f, fieldNamingPolicy, excluder));
        this.e = Collections.unmodifiableList(factories);
    }

    private aij<Number> a(boolean serializeSpecialFloatingPointValues) {
        if (serializeSpecialFloatingPointValues) {
            return ajk.v;
        }
        return new ahz$3(this);
    }

    private aij<Number> b(boolean serializeSpecialFloatingPointValues) {
        if (serializeSpecialFloatingPointValues) {
            return ajk.u;
        }
        return new ahz$4(this);
    }

    static void a(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(value + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static aij<Number> a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.a) {
            return ajk.t;
        }
        return new ahz$5();
    }

    private static aij<AtomicLong> a(aij<Number> longAdapter) {
        return new ahz$6(longAdapter).a();
    }

    private static aij<AtomicLongArray> b(aij<Number> longAdapter) {
        return new ahz$7(longAdapter).a();
    }

    public <T> aij<T> a(ajm<T> type) {
        aij<?> cached = (aij) this.d.get(type);
        if (cached != null) {
            return cached;
        }
        Map<ajm<?>, ahz$a<?>> threadCalls = (Map) this.c.get();
        boolean requiresThreadLocalCleanup = false;
        if (threadCalls == null) {
            threadCalls = new HashMap();
            this.c.set(threadCalls);
            requiresThreadLocalCleanup = true;
        }
        aij ongoingCall = (ahz$a) threadCalls.get(type);
        if (ongoingCall != null) {
            return ongoingCall;
        }
        try {
            ahz$a<T> call = new ahz$a();
            threadCalls.put(type, call);
            for (aik factory : this.e) {
                aij<T> candidate = factory.a(this, type);
                if (candidate != null) {
                    call.a(candidate);
                    this.d.put(type, candidate);
                    return candidate;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + type);
        } finally {
            threadCalls.remove(type);
            if (requiresThreadLocalCleanup) {
                this.c.remove();
            }
        }
    }

    public <T> aij<T> a(aik skipPast, ajm<T> type) {
        boolean skipPastFound = false;
        if (!this.e.contains(skipPast)) {
            skipPastFound = true;
        }
        for (aik factory : this.e) {
            if (skipPastFound) {
                aij<T> candidate = factory.a(this, type);
                if (candidate != null) {
                    return candidate;
                }
            } else if (factory == skipPast) {
                skipPastFound = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + type);
    }

    public <T> aij<T> a(Class<T> type) {
        return a(ajm.get((Class) type));
    }

    public String a(Object src) {
        if (src == null) {
            return a(aie.a);
        }
        return a(src, src.getClass());
    }

    public String a(Object src, Type typeOfSrc) {
        Appendable writer = new StringWriter();
        a(src, typeOfSrc, writer);
        return writer.toString();
    }

    public void a(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
        try {
            a(src, typeOfSrc, a(aiw.a(writer)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void a(Object src, Type typeOfSrc, ajo writer) throws JsonIOException {
        aij<?> adapter = a(ajm.get(typeOfSrc));
        boolean oldLenient = writer.g();
        writer.b(true);
        boolean oldHtmlSafe = writer.h();
        writer.c(this.h);
        boolean oldSerializeNulls = writer.i();
        writer.d(this.g);
        try {
            adapter.a(writer, src);
            writer.b(oldLenient);
            writer.c(oldHtmlSafe);
            writer.d(oldSerializeNulls);
        } catch (IOException e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            writer.b(oldLenient);
            writer.c(oldHtmlSafe);
            writer.d(oldSerializeNulls);
        }
    }

    public String a(aid jsonElement) {
        Appendable writer = new StringWriter();
        a(jsonElement, writer);
        return writer.toString();
    }

    public void a(aid jsonElement, Appendable writer) throws JsonIOException {
        try {
            a(jsonElement, a(aiw.a(writer)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ajo a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        ajo jsonWriter = new ajo(writer);
        if (this.j) {
            jsonWriter.c("  ");
        }
        jsonWriter.d(this.g);
        return jsonWriter;
    }

    public ajn a(Reader reader) {
        ajn jsonReader = new ajn(reader);
        jsonReader.a(this.k);
        return jsonReader;
    }

    public void a(aid jsonElement, ajo writer) throws JsonIOException {
        boolean oldLenient = writer.g();
        writer.b(true);
        boolean oldHtmlSafe = writer.h();
        writer.c(this.h);
        boolean oldSerializeNulls = writer.i();
        writer.d(this.g);
        try {
            aiw.a(jsonElement, writer);
            writer.b(oldLenient);
            writer.c(oldHtmlSafe);
            writer.d(oldSerializeNulls);
        } catch (IOException e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            writer.b(oldLenient);
            writer.c(oldHtmlSafe);
            writer.d(oldSerializeNulls);
        }
    }

    public <T> T a(String json, Class<T> classOfT) throws JsonSyntaxException {
        return aiv.a((Class) classOfT).cast(a(json, (Type) classOfT));
    }

    public <T> T a(String json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return a(new StringReader(json), typeOfT);
    }

    public <T> T a(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        ajn jsonReader = a(json);
        Object object = a(jsonReader, typeOfT);
        ahz.a(object, jsonReader);
        return object;
    }

    private static void a(Object obj, ajn reader) {
        if (obj != null) {
            try {
                if (reader.f() != JsonToken.j) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public <T> T a(ajn reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        boolean isEmpty = true;
        boolean oldLenient = reader.p();
        reader.a(true);
        try {
            reader.f();
            isEmpty = false;
            T object = a(ajm.get(typeOfT)).b(reader);
            reader.a(oldLenient);
            return object;
        } catch (EOFException e) {
            if (isEmpty) {
                reader.a(oldLenient);
                return null;
            }
            throw new JsonSyntaxException(e);
        } catch (IllegalStateException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonSyntaxException(e3);
        } catch (Throwable th) {
            reader.a(oldLenient);
        }
    }

    public <T> T a(aid json, Class<T> classOfT) throws JsonSyntaxException {
        return aiv.a((Class) classOfT).cast(a(json, (Type) classOfT));
    }

    public <T> T a(aid json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return a(new ajc(json), typeOfT);
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }
}
