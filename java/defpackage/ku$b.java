package defpackage;

/* compiled from: Engine */
class ku$b implements kt$a {
    private final lm$a a;
    private volatile lm b;

    public ku$b(lm$a factory) {
        this.a = factory;
    }

    public lm a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = this.a.a();
                }
                if (this.b == null) {
                    this.b = new ln();
                }
            }
        }
        return this.b;
    }
}
