package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: MapTypeAdapterFactory */
final class aje$a<K, V> extends aij<Map<K, V>> {
    final /* synthetic */ aje a;
    private final aij<K> b;
    private final aij<V> c;
    private final aiu<? extends Map<K, V>> d;

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public aje$a(aje aje, ahz context, Type keyType, aij<K> keyTypeAdapter, Type valueType, aij<V> valueTypeAdapter, aiu<? extends Map<K, V>> constructor) {
        this.a = aje;
        this.b = new ajj(context, keyTypeAdapter, keyType);
        this.c = new ajj(context, valueTypeAdapter, valueType);
        this.d = constructor;
    }

    public Map<K, V> a(ajn in) throws IOException {
        JsonToken peek = in.f();
        if (peek == JsonToken.i) {
            in.j();
            return null;
        }
        Map<K, V> map = (Map) this.d.a();
        K key;
        if (peek == JsonToken.a) {
            in.a();
            while (in.e()) {
                in.a();
                key = this.b.b(in);
                if (map.put(key, this.c.b(in)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + key);
                }
                in.b();
            }
            in.b();
            return map;
        }
        in.c();
        while (in.e()) {
            ait.a.a(in);
            key = this.b.b(in);
            if (map.put(key, this.c.b(in)) != null) {
                throw new JsonSyntaxException("duplicate key: " + key);
            }
        }
        in.d();
        return map;
    }

    public void a(ajo out, Map<K, V> map) throws IOException {
        if (map == null) {
            out.f();
        } else if (this.a.a) {
            boolean hasComplexKeys = false;
            List<aid> keys = new ArrayList(map.size());
            List<V> values = new ArrayList(map.size());
            for (Entry<K, V> entry : map.entrySet()) {
                aid keyElement = this.b.a(entry.getKey());
                keys.add(keyElement);
                values.add(entry.getValue());
                int i = (keyElement.i() || keyElement.j()) ? 1 : 0;
                hasComplexKeys |= i;
            }
            int i2;
            if (hasComplexKeys) {
                out.b();
                for (i2 = 0; i2 < keys.size(); i2++) {
                    out.b();
                    aiw.a((aid) keys.get(i2), out);
                    this.c.a(out, values.get(i2));
                    out.c();
                }
                out.c();
                return;
            }
            out.d();
            for (i2 = 0; i2 < keys.size(); i2++) {
                out.a(a((aid) keys.get(i2)));
                this.c.a(out, values.get(i2));
            }
            out.e();
        } else {
            out.d();
            for (Entry<K, V> entry2 : map.entrySet()) {
                out.a(String.valueOf(entry2.getKey()));
                this.c.a(out, entry2.getValue());
            }
            out.e();
        }
    }

    private String a(aid keyElement) {
        if (keyElement.k()) {
            aih primitive = keyElement.o();
            if (primitive.q()) {
                return String.valueOf(primitive.b());
            }
            if (primitive.a()) {
                return Boolean.toString(primitive.h());
            }
            if (primitive.r()) {
                return primitive.c();
            }
            throw new AssertionError();
        } else if (keyElement.l()) {
            return "null";
        } else {
            throw new AssertionError();
        }
    }
}
