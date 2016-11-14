package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: TimeBasedFileRollOverRunnable */
public class amq implements Runnable {
    private final Context a;
    private final amm b;

    public amq(Context context, amm fileRollOverManager) {
        this.a = context;
        this.b = fileRollOverManager;
    }

    public void run() {
        try {
            CommonUtils.a(this.a, "Performing time based file roll over.");
            if (!this.b.c()) {
                this.b.d();
            }
        } catch (Exception e) {
            CommonUtils.a(this.a, "Failed to roll over file", e);
        }
    }
}
