/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
public final class dp {

    public static interface a<T> {
        public T a();

        public boolean a(T var1);
    }

    public static class b<T>
    implements a<T> {
        private final Object[] a;
        private int b;

        public b(int n2) {
            if (n2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.a = new Object[n2];
        }

        private boolean b(T t2) {
            for (int i2 = 0; i2 < this.b; ++i2) {
                if (this.a[i2] != t2) continue;
                return true;
            }
            return false;
        }

        @Override
        public T a() {
            if (this.b > 0) {
                int n2 = -1 + this.b;
                Object object = this.a[n2];
                this.a[n2] = null;
                this.b = -1 + this.b;
                return (T)object;
            }
            return null;
        }

        @Override
        public boolean a(T t2) {
            if (super.b(t2)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.b < this.a.length) {
                this.a[this.b] = t2;
                this.b = 1 + this.b;
                return true;
            }
            return false;
        }
    }

    public static class c<T>
    extends b<T> {
        private final Object a = new Object();

        public c(int n2) {
            super(n2);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public T a() {
            Object object;
            Object object2 = object = this.a;
            synchronized (object2) {
                Object t2 = super.a();
                return t2;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean a(T t2) {
            Object object;
            Object object2 = object = this.a;
            synchronized (object2) {
                return super.a(t2);
            }
        }
    }

}

