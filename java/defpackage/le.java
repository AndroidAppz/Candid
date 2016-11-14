package defpackage;

import java.util.Queue;

/* compiled from: BaseKeyPool */
abstract class le<T extends lk> {
    private final Queue<T> a = ra.a(20);

    protected abstract T b();

    le() {
    }

    protected T c() {
        lk result = (lk) this.a.poll();
        if (result == null) {
            return b();
        }
        return result;
    }

    public void a(T key) {
        if (this.a.size() < 20) {
            this.a.offer(key);
        }
    }
}
