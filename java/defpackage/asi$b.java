package defpackage;

/* compiled from: TrampolineScheduler */
final class asi$b implements Comparable<asi$b> {
    final apq a;
    final Long b;
    final int c;

    public /* synthetic */ int compareTo(Object x0) {
        return a((asi$b) x0);
    }

    asi$b(apq action, Long execTime, int count) {
        this.a = action;
        this.b = execTime;
        this.c = count;
    }

    public int a(asi$b that) {
        int result = this.b.compareTo(that.b);
        if (result == 0) {
            return asi.a(this.c, that.c);
        }
        return result;
    }
}
