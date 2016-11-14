/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  java.io.File
 *  java.lang.Object
 */
import android.content.Context;
import android.content.Intent;
import java.io.File;

class bf {
    public static File a(Context context) {
        return context.getObbDir();
    }

    static void a(Context context, Intent[] arrintent) {
        context.startActivities(arrintent);
    }
}

