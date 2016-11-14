package defpackage;

/* compiled from: RxJavaPluginUtils */
public final class aqp {
    public static void a(Throwable e) {
        try {
            asc.a().b().a(e);
        } catch (Throwable pluginException) {
            aqp.b(pluginException);
        }
    }

    private static void b(Throwable pluginException) {
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + pluginException.getMessage());
        pluginException.printStackTrace();
    }
}
