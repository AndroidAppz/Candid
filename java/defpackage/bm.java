package defpackage;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader */
public class bm<D> {
    int a;
    bm$b<D> b;
    bm$a<D> c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;

    public void a(int id, bm$b<D> listener) {
        if (this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.b = listener;
        this.a = id;
    }

    public void a(bm$b<D> listener) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.b != listener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.b = null;
        }
    }

    public void a(bm$a<D> listener) {
        if (this.c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.c = listener;
    }

    public void b(bm$a<D> listener) {
        if (this.c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.c != listener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.c = null;
        }
    }

    public final void a() {
        this.d = true;
        this.f = false;
        this.e = false;
        b();
    }

    protected void b() {
    }

    public boolean c() {
        return d();
    }

    protected boolean d() {
        return false;
    }

    public void e() {
        this.d = false;
        f();
    }

    protected void f() {
    }

    public void g() {
        this.e = true;
        h();
    }

    protected void h() {
    }

    public void i() {
        j();
        this.f = true;
        this.d = false;
        this.e = false;
        this.g = false;
        this.h = false;
    }

    protected void j() {
    }

    public String a(D data) {
        StringBuilder sb = new StringBuilder(64);
        dj.a(data, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        dj.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }

    public void a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("mId=");
        writer.print(this.a);
        writer.print(" mListener=");
        writer.println(this.b);
        if (this.d || this.g || this.h) {
            writer.print(prefix);
            writer.print("mStarted=");
            writer.print(this.d);
            writer.print(" mContentChanged=");
            writer.print(this.g);
            writer.print(" mProcessingChange=");
            writer.println(this.h);
        }
        if (this.e || this.f) {
            writer.print(prefix);
            writer.print("mAbandoned=");
            writer.print(this.e);
            writer.print(" mReset=");
            writer.println(this.f);
        }
    }
}
