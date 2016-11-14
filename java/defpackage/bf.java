package defpackage;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* compiled from: ContextCompatHoneycomb */
class bf {
    static void a(Context context, Intent[] intents) {
        context.startActivities(intents);
    }

    public static File a(Context context) {
        return context.getObbDir();
    }
}
