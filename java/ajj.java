/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 */
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class ajj<T>
extends aij<T> {
    private final ahz a;
    private final aij<T> b;
    private final Type c;

    ajj(ahz ahz2, aij<T> aij2, Type type) {
        this.a = ahz2;
        this.b = aij2;
        this.c = type;
    }

    private Type a(Type type, Object object) {
        if (object != null && (type == Object.class || type instanceof TypeVariable || type instanceof Class)) {
            type = object.getClass();
        }
        return type;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(ajo ajo2, T t2) throws IOException {
        void var3_5;
        aij<T> aij2 = this.b;
        Type type = super.a(this.c, t2);
        if (type != this.c) {
            aij aij3 = this.a.a(ajm.get(type));
            if (!(aij3 instanceof ajg.a)) {
                aij aij4 = aij3;
            } else if (!(this.b instanceof ajg.a)) {
                aij<T> aij5 = this.b;
            } else {
                aij aij6 = aij3;
            }
        }
        var3_5.a(ajo2, t2);
    }

    @Override
    public T b(ajn ajn2) throws IOException {
        return this.b.b(ajn2);
    }
}

