package defpackage;

import android.os.Bundle;

class afx$2 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ boolean e;
    final /* synthetic */ boolean f;
    final /* synthetic */ boolean g;
    final /* synthetic */ String h;
    final /* synthetic */ afx i;

    afx$2(afx afx, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.i = afx;
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = bundle;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = str3;
    }

    public void run() {
        this.i.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
