package defpackage;

import android.content.ComponentName;
import android.content.Intent;

/* compiled from: IntentCompat */
class bk$b implements bk$a {
    bk$b() {
    }

    public Intent a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
