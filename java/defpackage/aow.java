package defpackage;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: ExceptionUtils */
public class aow {
    private static final String[] a = new String[]{"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    public static String a(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }
}
