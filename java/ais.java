/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ais
implements aik,
Cloneable {
    public static final ais a = new ais();
    private double b = -1.0;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<ahw> f = Collections.emptyList();
    private List<ahw> g = Collections.emptyList();

    private boolean a(aio aio2) {
        if (aio2 != null && aio2.a() > this.b) {
            return false;
        }
        return true;
    }

    private boolean a(aio aio2, aip aip2) {
        if (super.a(aio2) && super.a(aip2)) {
            return true;
        }
        return false;
    }

    private boolean a(aip aip2) {
        if (aip2 != null && aip2.a() <= this.b) {
            return false;
        }
        return true;
    }

    private boolean a(Class<?> class_) {
        if (!Enum.class.isAssignableFrom(class_) && (class_.isAnonymousClass() || class_.isLocalClass())) {
            return true;
        }
        return false;
    }

    private boolean b(Class<?> class_) {
        if (class_.isMemberClass() && !super.c(class_)) {
            return true;
        }
        return false;
    }

    private boolean c(Class<?> class_) {
        if ((8 & class_.getModifiers()) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public <T> aij<T> a(final ahz ahz2, final ajm<T> ajm2) {
        Class<T> class_ = ajm2.getRawType();
        final boolean bl2 = this.a(class_, true);
        final boolean bl3 = this.a(class_, false);
        if (!bl2 && !bl3) {
            return null;
        }
        return new aij<T>(){
            private aij<T> f;

            private aij<T> b() {
                aij aij2;
                aij<T> aij3 = this.f;
                if (aij3 != null) {
                    return aij3;
                }
                this.f = aij2 = ahz2.a(ais.this, ajm2);
                return aij2;
            }

            @Override
            public void a(ajo ajo2, T t2) throws IOException {
                if (bl2) {
                    ajo2.f();
                    return;
                }
                super.b().a(ajo2, t2);
            }

            @Override
            public T b(ajn ajn2) throws IOException {
                if (bl3) {
                    ajn2.n();
                    return null;
                }
                return super.b().b(ajn2);
            }
        };
    }

    protected ais a() {
        try {
            ais ais2 = (ais)super.clone();
            return ais2;
        }
        catch (CloneNotSupportedException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(Class<?> class_, boolean bl2) {
        if (this.b != -1.0 && !super.a((aio)class_.getAnnotation((Class)aio.class), (aip)class_.getAnnotation((Class)aip.class))) {
            return true;
        }
        if (!this.d && super.b(class_)) {
            return true;
        }
        if (super.a(class_)) {
            return true;
        }
        List<ahw> list = bl2 ? this.f : this.g;
        Iterator iterator = list.iterator();
        do {
            if (iterator.hasNext()) continue;
            return false;
        } while (!((ahw)iterator.next()).a(class_));
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(Field field, boolean bl2) {
        ail ail2;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.b != -1.0 && !super.a((aio)field.getAnnotation((Class)aio.class), (aip)field.getAnnotation((Class)aip.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.e && ((ail2 = (ail)field.getAnnotation((Class)ail.class)) == null || (bl2 ? !ail2.a() : !ail2.b()))) {
            return true;
        }
        if (!this.d && super.b(field.getType())) {
            return true;
        }
        if (super.a(field.getType())) {
            return true;
        }
        List<ahw> list = bl2 ? this.f : this.g;
        if (!list.isEmpty()) {
            ahx ahx2 = new ahx(field);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (!((ahw)iterator.next()).a(ahx2)) continue;
                return true;
            }
        }
        return false;
    }

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.a();
    }

}

