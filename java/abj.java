/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
public abstract class abj<T> {
    private static final Object c = new Object();
    private static a d = null;
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String a;
    protected final T b;
    private T g = null;

    protected abj(String string2, T t2) {
        this.a = string2;
        this.b = t2;
    }

    public static abj<Integer> a(String string2, Integer n2) {
        return new abj<Integer>(string2, n2){

            @Override
            protected /* synthetic */ Object a(String string2) {
                return this.b(string2);
            }

            protected Integer b(String string2) {
                return abj.b().a(this.a, (Integer)this.b);
            }
        };
    }

    public static abj<Long> a(String string2, Long l2) {
        return new abj<Long>(string2, l2){

            @Override
            protected /* synthetic */ Object a(String string2) {
                return this.b(string2);
            }

            protected Long b(String string2) {
                return abj.b().a(this.a, (Long)this.b);
            }
        };
    }

    public static abj<String> a(String string2, String string3) {
        return new abj<String>(string2, string3){

            @Override
            protected /* synthetic */ Object a(String string2) {
                return this.b(string2);
            }

            protected String b(String string2) {
                return abj.b().a(this.a, (String)this.b);
            }
        };
    }

    public static abj<Boolean> a(String string2, boolean bl2) {
        return new abj<Boolean>(string2, Boolean.valueOf((boolean)bl2)){

            @Override
            protected /* synthetic */ Object a(String string2) {
                return this.b(string2);
            }

            protected Boolean b(String string2) {
                return abj.b().a(this.a, (Boolean)this.b);
            }
        };
    }

    static /* synthetic */ a b() {
        return null;
    }

    public final T a() {
        return this.a(this.a);
    }

    protected abstract T a(String var1);

    static interface a {
        public Boolean a(String var1, Boolean var2);

        public Integer a(String var1, Integer var2);

        public Long a(String var1, Long var2);

        public String a(String var1, String var2);
    }

}

