/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 */
public final class aiq {
    public static <T> T a(T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        return t2;
    }

    public static void a(boolean bl2) {
        if (!bl2) {
            throw new IllegalArgumentException();
        }
    }
}

