package defpackage;

class afx$3 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Object c;
    final /* synthetic */ long d;
    final /* synthetic */ afx e;

    afx$3(afx afx, String str, String str2, Object obj, long j) {
        this.e = afx;
        this.a = str;
        this.b = str2;
        this.c = obj;
        this.d = j;
    }

    public void run() {
        this.e.a(this.a, this.b, this.c, this.d);
    }
}
