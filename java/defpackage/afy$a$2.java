package defpackage;

import android.content.ComponentName;

class afy$a$2 implements Runnable {
    final /* synthetic */ ComponentName a;
    final /* synthetic */ afy$a b;

    afy$a$2(afy$a afy_a, ComponentName componentName) {
        this.b = afy_a;
        this.a = componentName;
    }

    public void run() {
        this.b.a.a(this.a);
    }
}
