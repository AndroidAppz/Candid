package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class xw<T extends IInterface> extends yh<T> {
    private final wx$h<T> d;

    public xw(Context context, Looper looper, int i, wz$b wz_b, wz$c wz_c, yd ydVar, wx$h<T> wx_h_T) {
        super(context, looper, i, ydVar, wz_b, wz_c);
        this.d = wx_h_T;
    }

    protected T a(IBinder iBinder) {
        return this.d.a(iBinder);
    }

    protected void a(int i, T t) {
        this.d.a(i, t);
    }

    protected String f() {
        return this.d.a();
    }

    protected String g() {
        return this.d.b();
    }

    public wx$h<T> h() {
        return this.d;
    }
}
