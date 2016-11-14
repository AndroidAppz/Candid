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
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ajg
implements aik {
    private final air a;
    private final ahy b;
    private final ais c;

    public ajg(air air2, ahy ahy2, ais ais2) {
        this.a = air2;
        this.b = ahy2;
        this.c = ais2;
    }

    private b a(final ahz ahz2, final Field field, String string2, final ajm<?> ajm2, boolean bl2, boolean bl3) {
        return new b(string2, bl2, bl3, aiv.a(ajm2.getRawType())){
            final aij<?> a;
            final /* synthetic */ boolean e;

            @Override
            void a(ajn ajn2, Object object) throws IOException, IllegalAccessException {
                Object obj = this.a.b(ajn2);
                if (obj != null || !this.e) {
                    field.set(object, obj);
                }
            }

            @Override
            void a(ajo ajo2, Object object) throws IOException, IllegalAccessException {
                Object object2 = field.get(object);
                new ajj(ahz2, this.a, ajm2.getType()).a(ajo2, (Object)object2);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public boolean a(Object object) throws IOException, IllegalAccessException {
                if (!this.h || field.get(object) == object) {
                    return false;
                }
                return true;
            }
        };
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static List<String> a(ahy ahy2, Field field) {
        ain ain2 = (ain)field.getAnnotation((Class)ain.class);
        LinkedList linkedList = new LinkedList();
        if (ain2 == null) {
            linkedList.add((Object)ahy2.a(field));
            return linkedList;
        }
        linkedList.add((Object)ain2.a());
        String[] arrstring = ain2.b();
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            linkedList.add((Object)arrstring[n3]);
            ++n3;
        }
        return linkedList;
    }

    private List<String> a(Field field) {
        return ajg.a(this.b, field);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private Map<String, b> a(ahz ahz2, ajm<?> ajm2, Class<?> class_) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (class_.isInterface()) {
            return linkedHashMap;
        }
        Type type = ajm2.getType();
        while (class_ != Object.class) {
            for (Field field : class_.getDeclaredFields()) {
                boolean bl2 = this.a(field, true);
                boolean bl3 = this.a(field, false);
                if (!bl2 && !bl3) continue;
                field.setAccessible(true);
                Type type2 = ajm2.getType();
                Type type3 = field.getGenericType();
                Type type4 = .Gson.Types.a((Type)type2, class_, (Type)type3);
                List<String> list = super.a(field);
                b b2 = null;
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    String string2 = (String)list.get(i2);
                    if (i2 != 0) {
                        bl2 = false;
                    }
                    b b3 = (b)linkedHashMap.put((Object)string2, (Object)super.a(ahz2, field, string2, ajm.get(type4), bl2, bl3));
                    if (b2 != null) continue;
                    b2 = b3;
                }
            }
            Type type5 = ajm2.getType();
            Type type6 = class_.getGenericSuperclass();
            ajm2 = ajm.get(.Gson.Types.a((Type)type5, class_, (Type)type6));
            class_ = ajm2.getRawType();
        }
        return linkedHashMap;
    }

    static boolean a(Field field, boolean bl2, ais ais2) {
        if (!ais2.a(field.getType(), bl2) && !ais2.a(field, bl2)) {
            return true;
        }
        return false;
    }

    @Override
    public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
        Class<T> class_ = ajm2.getRawType();
        if (!Object.class.isAssignableFrom(class_)) {
            return null;
        }
        return new a<T>(this.a.a(ajm2), super.a(ahz2, ajm2, class_));
    }

    aij<?> a(ahz ahz2, Field field, ajm<?> ajm2) {
        aij aij2;
        aim aim2 = (aim)field.getAnnotation((Class)aim.class);
        if (aim2 != null && (aij2 = ajb.a(this.a, ahz2, ajm2, aim2)) != null) {
            return aij2;
        }
        return ahz2.a(ajm2);
    }

    public boolean a(Field field, boolean bl2) {
        return ajg.a(field, bl2, this.c);
    }

    public static final class a<T>
    extends aij<T> {
        private final aiu<T> a;
        private final Map<String, b> b;

        a(aiu<T> aiu2, Map<String, b> map) {
            this.a = aiu2;
            this.b = map;
        }

        @Override
        public void a(ajo ajo2, T t2) throws IOException {
            if (t2 == null) {
                ajo2.f();
                return;
            }
            ajo2.d();
            try {
                for (b b2 : this.b.values()) {
                    if (!b2.a(t2)) continue;
                    ajo2.a(b2.g);
                    b2.a(ajo2, t2);
                }
            }
            catch (IllegalAccessException var4_5) {
                throw new AssertionError((Object)var4_5);
            }
            ajo2.e();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public T b(ajn ajn2) throws IOException {
            if (ajn2.f() == JsonToken.i) {
                ajn2.j();
                return null;
            }
            T t2 = this.a.a();
            try {
                ajn2.c();
                while (ajn2.e()) {
                    String string2 = ajn2.g();
                    b b2 = (b)this.b.get((Object)string2);
                    if (b2 == null || !b2.i) {
                        ajn2.n();
                        continue;
                    }
                    b2.a(ajn2, t2);
                }
            }
            catch (IllegalStateException var4_5) {
                throw new JsonSyntaxException((Throwable)var4_5);
            }
            catch (IllegalAccessException var3_6) {
                throw new AssertionError((Object)var3_6);
            }
            ajn2.d();
            return t2;
        }
    }

    static abstract class b {
        final String g;
        final boolean h;
        final boolean i;

        protected b(String string2, boolean bl2, boolean bl3) {
            this.g = string2;
            this.h = bl2;
            this.i = bl3;
        }

        abstract void a(ajn var1, Object var2) throws IOException, IllegalAccessException;

        abstract void a(ajo var1, Object var2) throws IOException, IllegalAccessException;

        abstract boolean a(Object var1) throws IOException, IllegalAccessException;
    }

}

