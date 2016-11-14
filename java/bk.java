/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

public final class bk {
    private static final a a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 15 ? new d() : (n2 >= 11 ? new c() : new b());
    }

    public static Intent a(ComponentName componentName) {
        return a.a(componentName);
    }

    static interface a {
        public Intent a(ComponentName var1);
    }

    static class b
    implements a {
        b() {
        }

        @Override
        public Intent a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    static class c
    extends b {
        c() {
        }

        @Override
        public Intent a(ComponentName componentName) {
            return bl.a(componentName);
        }
    }

    static class d
    extends c {
        d() {
        }
    }

}

