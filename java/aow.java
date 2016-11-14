/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.Throwable
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class aow {
    private static final String[] a = new String[]{"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    public static String a(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter((Writer)stringWriter, true));
        return stringWriter.getBuffer().toString();
    }
}

