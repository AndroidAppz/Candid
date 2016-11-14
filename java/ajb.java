/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 */
import java.lang.annotation.Annotation;

public final class ajb
implements aik {
    private final air a;

    public ajb(air air2) {
        this.a = air2;
    }

    /*
     * Enabled aggressive block sorting
     */
    static aij<?> a(air air2, ahz ahz2, ajm<?> ajm2, aim aim2) {
        void var5_8;
        void var5_6;
        Class class_ = aim2.a();
        if (aij.class.isAssignableFrom(class_)) {
            aij aij2 = (aij)air2.a(ajm.get(class_)).a();
        } else {
            if (!aik.class.isAssignableFrom(class_)) {
                throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
            }
            aij aij3 = ((aik)air2.a(ajm.get(class_)).a()).a(ahz2, ajm2);
        }
        if (var5_6 != null) {
            aij aij4 = var5_6.a();
        }
        return var5_8;
    }

    @Override
    public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
        aim aim2 = (aim)ajm2.getRawType().getAnnotation((Class)aim.class);
        if (aim2 == null) {
            return null;
        }
        return ajb.a(this.a, ahz2, ajm2, aim2);
    }
}

