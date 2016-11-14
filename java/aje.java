/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.internal.
 *  com.google.gson.internal.$Gson
 *  com.google.gson.internal.$Gson$Types
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class aje
implements aik {
    final boolean a;
    private final air b;

    public aje(air air2, boolean bl2) {
        this.b = air2;
        this.a = bl2;
    }

    private aij<?> a(ahz ahz2, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return ajk.f;
        }
        return ahz2.a(ajm.get(type));
    }

    @Override
    public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
        Type type = ajm2.getType();
        if (!Map.class.isAssignableFrom(ajm2.getRawType())) {
            return null;
        }
        Type[] arrtype = .Gson.Types.b((Type)type, (Class).Gson.Types.e((Type)type));
        aij aij2 = super.a(ahz2, arrtype[0]);
        aij aij3 = ahz2.a(ajm.get(arrtype[1]));
        aiu<T> aiu2 = this.b.a(ajm2);
        return (aje)this.new a(ahz2, arrtype[0], aij2, arrtype[1], aij3, aiu2);
    }

    final class a<K, V>
    extends aij<Map<K, V>> {
        private final aij<K> b;
        private final aij<V> c;
        private final aiu<? extends Map<K, V>> d;

        public a(ahz ahz2, Type type, aij<K> aij2, Type type2, aij<V> aij3, aiu<? extends Map<K, V>> aiu2) {
            this.b = new ajj<K>(ahz2, aij2, type);
            this.c = new ajj<V>(ahz2, aij3, type2);
            this.d = aiu2;
        }

        private String a(aid aid2) {
            if (aid2.k()) {
                aih aih2 = aid2.o();
                if (aih2.q()) {
                    return String.valueOf((Object)aih2.b());
                }
                if (aih2.a()) {
                    return Boolean.toString((boolean)aih2.h());
                }
                if (aih2.r()) {
                    return aih2.c();
                }
                throw new AssertionError();
            }
            if (aid2.l()) {
                return "null";
            }
            throw new AssertionError();
        }

        public Map<K, V> a(ajn ajn2) throws IOException {
            JsonToken jsonToken = ajn2.f();
            if (jsonToken == JsonToken.i) {
                ajn2.j();
                return null;
            }
            Map<K, V> map = this.d.a();
            if (jsonToken == JsonToken.a) {
                ajn2.a();
                while (ajn2.e()) {
                    ajn2.a();
                    K k2 = this.b.b(ajn2);
                    if (map.put(k2, this.c.b(ajn2)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + k2);
                    }
                    ajn2.b();
                }
                ajn2.b();
                return map;
            }
            ajn2.c();
            while (ajn2.e()) {
                ait.a.a(ajn2);
                K k3 = this.b.b(ajn2);
                if (map.put(k3, this.c.b(ajn2)) == null) continue;
                throw new JsonSyntaxException("duplicate key: " + k3);
            }
            ajn2.d();
            return map;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(ajo ajo2, Map<K, V> map) throws IOException {
            if (map == null) {
                ajo2.f();
                return;
            }
            if (!aje.this.a) {
                ajo2.d();
                Iterator iterator = map.entrySet().iterator();
                do {
                    if (!iterator.hasNext()) {
                        ajo2.e();
                        return;
                    }
                    Map.Entry entry = (Map.Entry)iterator.next();
                    ajo2.a(String.valueOf((Object)entry.getKey()));
                    this.c.a(ajo2, (Object)entry.getValue());
                } while (true);
            }
            boolean bl2 = false;
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                aid aid2 = this.b.a((Object)entry.getKey());
                arrayList.add((Object)aid2);
                arrayList2.add(entry.getValue());
                boolean bl3 = aid2.i() || aid2.j();
                bl2 |= bl3;
            }
            if (bl2) {
                ajo2.b();
                int n2 = 0;
                do {
                    if (n2 >= arrayList.size()) {
                        ajo2.c();
                        return;
                    }
                    ajo2.b();
                    aiw.a((aid)arrayList.get(n2), ajo2);
                    this.c.a(ajo2, (Object)arrayList2.get(n2));
                    ajo2.c();
                    ++n2;
                } while (true);
            }
            ajo2.d();
            int n3 = 0;
            do {
                if (n3 >= arrayList.size()) {
                    ajo2.e();
                    return;
                }
                ajo2.a(super.a((aid)arrayList.get(n3)));
                this.c.a(ajo2, (Object)arrayList2.get(n3));
                ++n3;
            } while (true);
        }

        @Override
        public /* synthetic */ Object b(ajn ajn2) throws IOException {
            return this.a(ajn2);
        }
    }

}

