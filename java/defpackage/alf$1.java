package defpackage;

/* compiled from: AdvertisingInfoProvider */
class alf$1 extends alk {
    final /* synthetic */ ale a;
    final /* synthetic */ alf b;

    alf$1(alf alf, ale ale) {
        this.b = alf;
        this.a = ale;
    }

    public void a() {
        ale infoToStore = this.b.e();
        if (!this.a.equals(infoToStore)) {
            akp.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            this.b.b(infoToStore);
        }
    }
}
