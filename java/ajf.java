/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedTreeMap
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

public final class ajf
extends aij<Object> {
    public static final aik a = new aik(){

        @Override
        public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
            if (ajm2.getRawType() == Object.class) {
                return new ajf(ahz2);
            }
            return null;
        }
    };
    private final ahz b;

    ajf(ahz ahz2) {
        this.b = ahz2;
    }

    @Override
    public void a(ajo ajo2, Object object) throws IOException {
        if (object == null) {
            ajo2.f();
            return;
        }
        aij<Object> aij2 = this.b.a(object.getClass());
        if (aij2 instanceof ajf) {
            ajo2.d();
            ajo2.e();
            return;
        }
        aij2.a(ajo2, object);
    }

    @Override
    public Object b(ajn ajn2) throws IOException {
        JsonToken jsonToken = ajn2.f();
        switch (.a[jsonToken.ordinal()]) {
            default: {
                throw new IllegalStateException();
            }
            case 1: {
                ArrayList arrayList = new ArrayList();
                ajn2.a();
                while (ajn2.e()) {
                    arrayList.add(this.b(ajn2));
                }
                ajn2.b();
                return arrayList;
            }
            case 2: {
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                ajn2.c();
                while (ajn2.e()) {
                    linkedTreeMap.put((Object)ajn2.g(), this.b(ajn2));
                }
                ajn2.d();
                return linkedTreeMap;
            }
            case 3: {
                return ajn2.h();
            }
            case 4: {
                return ajn2.k();
            }
            case 5: {
                return ajn2.i();
            }
            case 6: 
        }
        ajn2.j();
        return null;
    }

}

