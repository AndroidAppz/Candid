package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: JsonTreeReader */
public final class ajc extends ajn {
    private static final Reader b = new ajc$1();
    private static final Object c = new Object();
    private final List<Object> d = new ArrayList();

    public ajc(aid element) {
        super(b);
        this.d.add(element);
    }

    public void a() throws IOException {
        a(JsonToken.a);
        this.d.add(((aib) u()).iterator());
    }

    public void b() throws IOException {
        a(JsonToken.b);
        v();
        v();
    }

    public void c() throws IOException {
        a(JsonToken.c);
        this.d.add(((aif) u()).a().iterator());
    }

    public void d() throws IOException {
        a(JsonToken.d);
        v();
        v();
    }

    public boolean e() throws IOException {
        JsonToken token = f();
        return (token == JsonToken.d || token == JsonToken.b) ? false : true;
    }

    public JsonToken f() throws IOException {
        if (this.d.isEmpty()) {
            return JsonToken.j;
        }
        Iterator<?> o = u();
        if (o instanceof Iterator) {
            boolean isObject = this.d.get(this.d.size() - 2) instanceof aif;
            Iterator<?> iterator = o;
            if (!iterator.hasNext()) {
                return isObject ? JsonToken.d : JsonToken.b;
            } else {
                if (isObject) {
                    return JsonToken.e;
                }
                this.d.add(iterator.next());
                return f();
            }
        } else if (o instanceof aif) {
            return JsonToken.c;
        } else {
            if (o instanceof aib) {
                return JsonToken.a;
            }
            if (o instanceof aih) {
                aih primitive = (aih) o;
                if (primitive.r()) {
                    return JsonToken.f;
                }
                if (primitive.a()) {
                    return JsonToken.h;
                }
                if (primitive.q()) {
                    return JsonToken.g;
                }
                throw new AssertionError();
            } else if (o instanceof aie) {
                return JsonToken.i;
            } else {
                if (o == c) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object u() {
        return this.d.get(this.d.size() - 1);
    }

    private Object v() {
        return this.d.remove(this.d.size() - 1);
    }

    private void a(JsonToken expected) throws IOException {
        if (f() != expected) {
            throw new IllegalStateException("Expected " + expected + " but was " + f());
        }
    }

    public String g() throws IOException {
        a(JsonToken.e);
        Entry<?, ?> entry = (Entry) ((Iterator) u()).next();
        this.d.add(entry.getValue());
        return (String) entry.getKey();
    }

    public String h() throws IOException {
        JsonToken token = f();
        if (token == JsonToken.f || token == JsonToken.g) {
            return ((aih) v()).c();
        }
        throw new IllegalStateException("Expected " + JsonToken.f + " but was " + token);
    }

    public boolean i() throws IOException {
        a(JsonToken.h);
        return ((aih) v()).h();
    }

    public void j() throws IOException {
        a(JsonToken.i);
        v();
    }

    public double k() throws IOException {
        JsonToken token = f();
        if (token == JsonToken.g || token == JsonToken.f) {
            double result = ((aih) u()).d();
            if (p() || !(Double.isNaN(result) || Double.isInfinite(result))) {
                v();
                return result;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + result);
        }
        throw new IllegalStateException("Expected " + JsonToken.g + " but was " + token);
    }

    public long l() throws IOException {
        JsonToken token = f();
        if (token == JsonToken.g || token == JsonToken.f) {
            long result = ((aih) u()).f();
            v();
            return result;
        }
        throw new IllegalStateException("Expected " + JsonToken.g + " but was " + token);
    }

    public int m() throws IOException {
        JsonToken token = f();
        if (token == JsonToken.g || token == JsonToken.f) {
            int result = ((aih) u()).g();
            v();
            return result;
        }
        throw new IllegalStateException("Expected " + JsonToken.g + " but was " + token);
    }

    public void close() throws IOException {
        this.d.clear();
        this.d.add(c);
    }

    public void n() throws IOException {
        if (f() == JsonToken.e) {
            g();
        } else {
            v();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void o() throws IOException {
        a(JsonToken.e);
        Entry<?, ?> entry = (Entry) ((Iterator) u()).next();
        this.d.add(entry.getValue());
        this.d.add(new aih((String) entry.getKey()));
    }
}
