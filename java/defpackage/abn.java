package defpackage;

import android.content.Context;

public class abn {
    private static abn b = new abn();
    private abm a = null;

    public static abm b(Context context) {
        return b.a(context);
    }

    public synchronized abm a(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new abm(context);
        }
        return this.a;
    }
}
