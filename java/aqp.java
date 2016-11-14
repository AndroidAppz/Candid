/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
import java.io.PrintStream;

public final class aqp {
    public static void a(Throwable throwable) {
        try {
            asc.a().b().a(throwable);
            return;
        }
        catch (Throwable var1_1) {
            aqp.b(var1_1);
            return;
        }
    }

    private static void b(Throwable throwable) {
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + throwable.getMessage());
        throwable.printStackTrace();
    }
}

