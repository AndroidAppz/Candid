/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.util.Locale
 */
import java.util.Locale;

public final class de {
    public static final dd a = new e(null, false, null);
    public static final dd b = new e(null, true, null);
    public static final dd c = new e(b.a, false, null);
    public static final dd d = new e(b.a, true, null);
    public static final dd e = new e(a.a, false, null);
    public static final dd f = f.a;

    private static int c(int n2) {
        switch (n2) {
            default: {
                return 2;
            }
            case 0: {
                return 1;
            }
            case 1: 
            case 2: 
        }
        return 0;
    }

    private static int d(int n2) {
        switch (n2) {
            default: {
                return 2;
            }
            case 0: 
            case 14: 
            case 15: {
                return 1;
            }
            case 1: 
            case 2: 
            case 16: 
            case 17: 
        }
        return 0;
    }

    static class a
    implements c {
        public static final a a = new a(true);
        public static final a b = new a(false);
        private final boolean c;

        private a(boolean bl2) {
            this.c = bl2;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public int a(CharSequence charSequence, int n2, int n3) {
            int n4 = 1;
            boolean bl2 = false;
            int n5 = n2 + n3;
            block4 : for (int i2 = n2; i2 < n5; ++i2) {
                switch (de.c(Character.getDirectionality((char)charSequence.charAt(i2)))) {
                    case 0: {
                        if (this.c) {
                            return 0;
                        }
                        bl2 = true;
                    }
                    default: {
                        continue block4;
                    }
                    case 1: {
                        if (!this.c) return n4;
                        bl2 = true;
                    }
                }
            }
            if (!bl2) {
                return 2;
            }
            if (this.c) return n4;
            return 0;
        }
    }

    static class b
    implements c {
        public static final b a = new b();

        private b() {
        }

        @Override
        public int a(CharSequence charSequence, int n2, int n3) {
            int n4 = 2;
            int n5 = n2 + n3;
            for (int i2 = n2; i2 < n5 && n4 == 2; ++i2) {
                n4 = de.d(Character.getDirectionality((char)charSequence.charAt(i2)));
            }
            return n4;
        }
    }

    static interface c {
        public int a(CharSequence var1, int var2, int var3);
    }

    static abstract class d
    implements dd {
        private final c a;

        public d(c c2) {
            this.a = c2;
        }

        private boolean b(CharSequence charSequence, int n2, int n3) {
            switch (this.a.a(charSequence, n2, n3)) {
                default: {
                    return this.a();
                }
                case 0: {
                    return true;
                }
                case 1: 
            }
            return false;
        }

        protected abstract boolean a();

        @Override
        public boolean a(CharSequence charSequence, int n2, int n3) {
            if (charSequence == null || n2 < 0 || n3 < 0 || charSequence.length() - n3 < n2) {
                throw new IllegalArgumentException();
            }
            if (this.a == null) {
                return this.a();
            }
            return super.b(charSequence, n2, n3);
        }
    }

    static class e
    extends d {
        private final boolean a;

        private e(c c2, boolean bl2) {
            super(c2);
            this.a = bl2;
        }

        /* synthetic */ e(c c2, boolean bl2,  var3_2) {
            super(c2, bl2);
        }

        @Override
        protected boolean a() {
            return this.a;
        }
    }

    static class f
    extends d {
        public static final f a = new f();

        public f() {
            super(null);
        }

        @Override
        protected boolean a() {
            if (df.a(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

}

