/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonIOException
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Throwable
 */
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

public abstract class aij<T> {
    public final aid a(T t2) {
        try {
            ajd ajd2 = new ajd();
            this.a(ajd2, t2);
            aid aid2 = ajd2.a();
            return aid2;
        }
        catch (IOException var3_4) {
            throw new JsonIOException((Throwable)var3_4);
        }
    }

    public final aij<T> a() {
        return new aij<T>(){

            @Override
            public void a(ajo ajo2, T t2) throws IOException {
                if (t2 == null) {
                    ajo2.f();
                    return;
                }
                aij.this.a(ajo2, t2);
            }

            @Override
            public T b(ajn ajn2) throws IOException {
                if (ajn2.f() == JsonToken.i) {
                    ajn2.j();
                    return null;
                }
                return aij.this.b(ajn2);
            }
        };
    }

    public abstract void a(ajo var1, T var2) throws IOException;

    public abstract T b(ajn var1) throws IOException;

}

