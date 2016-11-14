package defpackage;

/* compiled from: TrampolineScheduler */
public final class asi extends apg {
    private static final asi b = new asi();

    public static asi a() {
        return b;
    }

    public apg$a createWorker() {
        return new asi$a();
    }

    asi() {
    }

    static int a(int x, int y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }
}
