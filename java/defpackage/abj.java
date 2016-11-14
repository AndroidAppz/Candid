package defpackage;

public abstract class abj<T> {
    private static final Object c = new Object();
    private static abj$a d = null;
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String a;
    protected final T b;
    private T g = null;

    protected abj(String str, T t) {
        this.a = str;
        this.b = t;
    }

    public static abj<Integer> a(String str, Integer num) {
        return new abj$3(str, num);
    }

    public static abj<Long> a(String str, Long l) {
        return new abj$2(str, l);
    }

    public static abj<String> a(String str, String str2) {
        return new abj$4(str, str2);
    }

    public static abj<Boolean> a(String str, boolean z) {
        return new abj$1(str, Boolean.valueOf(z));
    }

    public final T a() {
        return a(this.a);
    }

    protected abstract T a(String str);
}
