/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicReference
 */
import android.content.Context;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class aaj {
    private static final AtomicReference<aaj> a = new AtomicReference();

    aaj(Context context) {
    }

    public static aaj a() {
        return (aaj)a.get();
    }

    public static aaj a(Context context) {
        a.compareAndSet((Object)null, (Object)new aaj(context));
        return (aaj)a.get();
    }

    public void a(ahn ahn2) {
    }

    public Set<String> b() {
        return Collections.emptySet();
    }
}

