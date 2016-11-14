/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public final class aqt {
    private static final a a = new a();

    public static <T> apu<T, T> a() {
        return new apu<T, T>(){

            @Override
            public T call(T t2) {
                return t2;
            }
        };
    }

    static final class a<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R>
    implements apt<R>,
    apu<T0, R>,
    apv<T0, T1, R>,
    apw<R> {
        a() {
        }

        @Override
        public /* varargs */ R a(Object ... arrobject) {
            return null;
        }

        public R call() {
            return null;
        }

        @Override
        public R call(T0 T0) {
            return null;
        }

        @Override
        public R call(T0 T0, T1 T1) {
            return null;
        }
    }

}

