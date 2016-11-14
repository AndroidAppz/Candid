/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  java.lang.Object
 */
import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

public interface ub {
    public boolean a(int var1, int var2, Intent var3);

    public static class a {
        public static ub a() {
            return new CallbackManagerImpl();
        }
    }

}

