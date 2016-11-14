package defpackage;

import android.app.Activity;

/* compiled from: CrashlyticsCore */
class sr$6 implements ans$b<Boolean> {
    final /* synthetic */ sr a;

    sr$6(sr srVar) {
        this.a = srVar;
    }

    public /* synthetic */ Object b(anu x0) {
        return a(x0);
    }

    public Boolean a(anu settingsData) {
        boolean send = true;
        Activity activity = this.a.F().b();
        if (!(activity == null || activity.isFinishing() || !this.a.x())) {
            send = this.a.a(activity, settingsData.c);
        }
        return Boolean.valueOf(send);
    }
}
