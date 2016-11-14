/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

public class amq
implements Runnable {
    private final Context a;
    private final amm b;

    public amq(Context context, amm amm2) {
        this.a = context;
        this.b = amm2;
    }

    public void run() {
        try {
            CommonUtils.a((Context)this.a, (String)"Performing time based file roll over.");
            if (!this.b.c()) {
                this.b.d();
            }
            return;
        }
        catch (Exception var1_1) {
            CommonUtils.a((Context)this.a, (String)"Failed to roll over file", (Throwable)var1_1);
            return;
        }
    }
}

