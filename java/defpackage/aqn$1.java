package defpackage;

/* compiled from: ObjectPool */
class aqn$1 implements apq {
    final /* synthetic */ aqn a;

    aqn$1(aqn aqn) {
        this.a = aqn;
    }

    public void call() {
        int size = this.a.a.size();
        int i;
        if (size < this.a.b) {
            int sizeToBeAdded = this.a.c - size;
            for (i = 0; i < sizeToBeAdded; i++) {
                this.a.a.add(this.a.d());
            }
        } else if (size > this.a.c) {
            int sizeToBeRemoved = size - this.a.c;
            for (i = 0; i < sizeToBeRemoved; i++) {
                this.a.a.poll();
            }
        }
    }
}
