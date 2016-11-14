package defpackage;

/* compiled from: CrashlyticsCore */
class sr$5 implements ans$b<Boolean> {
    final /* synthetic */ sr a;

    sr$5(sr srVar) {
        this.a = srVar;
    }

    public /* synthetic */ Object b(anu x0) {
        return a(x0);
    }

    public Boolean a(anu settingsData) {
        boolean z = false;
        if (!settingsData.d.a) {
            return Boolean.valueOf(false);
        }
        if (!this.a.y()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
