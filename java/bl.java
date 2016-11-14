/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 *  java.lang.Object
 */
import android.content.ComponentName;
import android.content.Intent;

class bl {
    public static Intent a(ComponentName componentName) {
        return Intent.makeMainActivity((ComponentName)componentName);
    }
}

