package defpackage;

import android.annotation.SuppressLint;

/* compiled from: LruResourceCache */
public class ls extends qx<kf, lb<?>> implements lt {
    private lt$a a;

    public /* synthetic */ lb a(kf x0) {
        return (lb) super.c(x0);
    }

    public /* bridge */ /* synthetic */ lb b(kf x0, lb x1) {
        return (lb) super.b(x0, x1);
    }

    public ls(int size) {
        super(size);
    }

    public void a(lt$a listener) {
        this.a = listener;
    }

    protected void a(kf key, lb<?> item) {
        if (this.a != null) {
            this.a.b(item);
        }
    }

    protected int a(lb<?> item) {
        return item.c();
    }

    @SuppressLint({"InlinedApi"})
    public void a(int level) {
        if (level >= 60) {
            a();
        } else if (level >= 40) {
            b(b() / 2);
        }
    }
}
