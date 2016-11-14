package defpackage;

class yc$3 extends yc {
    final /* synthetic */ char p;

    yc$3(char c) {
        this.p = c;
    }

    public yc a(yc ycVar) {
        return ycVar.b(this.p) ? ycVar : super.a(ycVar);
    }

    public boolean b(char c) {
        return c == this.p;
    }
}
