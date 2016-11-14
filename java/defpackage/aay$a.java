package defpackage;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

final class aay$a extends PhantomReference<xj<?>> {
    final /* synthetic */ aay a;
    private final int b;

    public aay$a(aay aay, xj xjVar, int i, ReferenceQueue<xj<?>> referenceQueue) {
        this.a = aay;
        super(xjVar, referenceQueue);
        this.b = i;
    }

    public void a() {
        this.a.m.sendMessage(this.a.m.obtainMessage(2, this.b, 2));
    }
}
