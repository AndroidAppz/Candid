/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.FileDescriptor
 *  java.io.PrintWriter
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class bm<D> {
    int a;
    b<D> b;
    a<D> c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;

    public String a(D d2) {
        StringBuilder stringBuilder = new StringBuilder(64);
        dj.a(d2, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a() {
        this.d = true;
        this.f = false;
        this.e = false;
        this.b();
    }

    public void a(int n2, b<D> b2) {
        if (this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.b = b2;
        this.a = n2;
    }

    public void a(a<D> a2) {
        if (this.c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.c = a2;
    }

    public void a(b<D> b2) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.b != b2) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.b = null;
    }

    public void a(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.print(string2);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.d || this.g || this.h) {
            printWriter.print(string2);
            printWriter.print("mStarted=");
            printWriter.print(this.d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.h);
        }
        if (this.e || this.f) {
            printWriter.print(string2);
            printWriter.print("mAbandoned=");
            printWriter.print(this.e);
            printWriter.print(" mReset=");
            printWriter.println(this.f);
        }
    }

    protected void b() {
    }

    public void b(a<D> a2) {
        if (this.c == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.c != a2) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.c = null;
    }

    public boolean c() {
        return this.d();
    }

    protected boolean d() {
        return false;
    }

    public void e() {
        this.d = false;
        this.f();
    }

    protected void f() {
    }

    public void g() {
        this.e = true;
        this.h();
    }

    protected void h() {
    }

    public void i() {
        this.j();
        this.f = true;
        this.d = false;
        this.e = false;
        this.g = false;
        this.h = false;
    }

    protected void j() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        dj.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static interface a<D> {
    }

    public static interface b<D> {
    }

}

