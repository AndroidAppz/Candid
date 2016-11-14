package defpackage;

/* compiled from: ActivityParams */
public class aof {
    public static final aof a = new aof$a().a(500).a();
    private long b;

    aof(long interval) {
        this.b = interval;
    }

    public long a() {
        return this.b;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof aof)) {
            return false;
        }
        if (this.b != ((aof) o).b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (this.b ^ (this.b >>> 32));
    }
}
