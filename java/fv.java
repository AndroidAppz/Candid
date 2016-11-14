/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.animation.Interpolator
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.ref.WeakReference
 *  java.util.WeakHashMap
 */
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class fv {
    static final g a;
    private WeakReference<View> b;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 21 ? new f() : (n2 >= 19 ? new e() : (n2 >= 18 ? new c() : (n2 >= 16 ? new d() : (n2 >= 14 ? new b() : new a()))));
    }

    fv(View view) {
        this.b = new WeakReference((Object)view);
    }

    public long a() {
        View view = (View)this.b.get();
        if (view != null) {
            return a.a(this, view);
        }
        return 0;
    }

    public fv a(float f2) {
        View view = (View)this.b.get();
        if (view != null) {
            a.a((fv)this, view, f2);
        }
        return this;
    }

    public fv a(long l2) {
        View view = (View)this.b.get();
        if (view != null) {
            a.a((fv)this, view, l2);
        }
        return this;
    }

    public fv a(Interpolator interpolator) {
        View view = (View)this.b.get();
        if (view != null) {
            a.a((fv)this, view, interpolator);
        }
        return this;
    }

    public fv a(fz fz2) {
        View view = (View)this.b.get();
        if (view != null) {
            a.a((fv)this, view, fz2);
        }
        return this;
    }

    public fv a(gb gb2) {
        View view = (View)this.b.get();
        if (view != null) {
            a.a((fv)this, view, gb2);
        }
        return this;
    }

    public fv b(float f2) {
        View view = (View)this.b.get();
        if (view != null) {
            a.b((fv)this, view, f2);
        }
        return this;
    }

    public fv b(long l2) {
        View view = (View)this.b.get();
        if (view != null) {
            a.b((fv)this, view, l2);
        }
        return this;
    }

    public void b() {
        View view = (View)this.b.get();
        if (view != null) {
            a.b(this, view);
        }
    }

    public fv c(float f2) {
        View view = (View)this.b.get();
        if (view != null) {
            a.c((fv)this, view, f2);
        }
        return this;
    }

    public void c() {
        View view = (View)this.b.get();
        if (view != null) {
            a.c(this, view);
        }
    }

    static class fv$a
    implements g {
        WeakHashMap<View, Runnable> a = null;

        fv$a() {
        }

        private void a(View view) {
            Runnable runnable;
            if (this.a != null && (runnable = (Runnable)this.a.get((Object)view)) != null) {
                view.removeCallbacks(runnable);
            }
        }

        private void d(fv fv2, View view) {
            Object object = view.getTag(2113929216);
            boolean bl2 = object instanceof fz;
            fz fz2 = null;
            if (bl2) {
                fz2 = (fz)object;
            }
            Runnable runnable = fv2.c;
            Runnable runnable2 = fv2.d;
            fv2.c = null;
            fv2.d = null;
            if (runnable != null) {
                runnable.run();
            }
            if (fz2 != null) {
                fz2.onAnimationStart(view);
                fz2.onAnimationEnd(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (this.a != null) {
                this.a.remove((Object)view);
            }
        }

        private void e(fv fv2, View view) {
            WeakHashMap<View, Runnable> weakHashMap = this.a;
            Runnable runnable = null;
            if (weakHashMap != null) {
                runnable = (Runnable)this.a.get((Object)view);
            }
            if (runnable == null) {
                runnable = new a((fv$a)this, fv2, view, null);
                if (this.a == null) {
                    this.a = new WeakHashMap();
                }
                this.a.put((Object)view, (Object)runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }

        @Override
        public long a(fv fv2, View view) {
            return 0;
        }

        @Override
        public void a(fv fv2, View view, float f2) {
            super.e(fv2, view);
        }

        @Override
        public void a(fv fv2, View view, long l2) {
        }

        @Override
        public void a(fv fv2, View view, Interpolator interpolator) {
        }

        @Override
        public void a(fv fv2, View view, fz fz2) {
            view.setTag(2113929216, (Object)fz2);
        }

        @Override
        public void a(fv fv2, View view, gb gb2) {
        }

        @Override
        public void b(fv fv2, View view) {
            super.e(fv2, view);
        }

        @Override
        public void b(fv fv2, View view, float f2) {
            super.e(fv2, view);
        }

        @Override
        public void b(fv fv2, View view, long l2) {
        }

        @Override
        public void c(fv fv2, View view) {
            super.a(view);
            super.d(fv2, view);
        }

        @Override
        public void c(fv fv2, View view, float f2) {
            super.e(fv2, view);
        }

        class a
        implements Runnable {
            WeakReference<View> a;
            fv b;
            final /* synthetic */ fv$a c;

            private a(fv$a a2, fv fv2, View view) {
                this.c = a2;
                this.a = new WeakReference((Object)view);
                this.b = fv2;
            }

            /* synthetic */ a(fv$a a2, fv fv2, View view,  var4) {
                super(a2, fv2, view);
            }

            public void run() {
                View view = (View)this.a.get();
                if (view != null) {
                    this.c.d(this.b, view);
                }
            }
        }

    }

    static class b
    extends fv$a {
        WeakHashMap<View, Integer> b = null;

        b() {
        }

        @Override
        public long a(fv fv2, View view) {
            return fw.a(view);
        }

        @Override
        public void a(fv fv2, View view, float f2) {
            fw.a(view, f2);
        }

        @Override
        public void a(fv fv2, View view, long l2) {
            fw.a(view, l2);
        }

        @Override
        public void a(fv fv2, View view, Interpolator interpolator) {
            fw.a(view, interpolator);
        }

        @Override
        public void a(fv fv2, View view, fz fz2) {
            view.setTag(2113929216, (Object)fz2);
            fw.a(view, new a(fv2));
        }

        @Override
        public void b(fv fv2, View view) {
            fw.b(view);
        }

        @Override
        public void b(fv fv2, View view, float f2) {
            fw.b(view, f2);
        }

        @Override
        public void b(fv fv2, View view, long l2) {
            fw.b(view, l2);
        }

        @Override
        public void c(fv fv2, View view) {
            fw.c(view);
        }

        @Override
        public void c(fv fv2, View view, float f2) {
            fw.c(view, f2);
        }

        static class a
        implements fz {
            fv a;
            boolean b;

            a(fv fv2) {
                this.a = fv2;
            }

            @Override
            public void onAnimationCancel(View view) {
                Object object = view.getTag(2113929216);
                boolean bl2 = object instanceof fz;
                fz fz2 = null;
                if (bl2) {
                    fz2 = (fz)object;
                }
                if (fz2 != null) {
                    fz2.onAnimationCancel(view);
                }
            }

            @Override
            public void onAnimationEnd(View view) {
                if (this.a.e >= 0) {
                    fb.a(view, this.a.e, null);
                    this.a.e = -1;
                }
                if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                    if (this.a.d != null) {
                        Runnable runnable = this.a.d;
                        this.a.d = null;
                        runnable.run();
                    }
                    Object object = view.getTag(2113929216);
                    boolean bl2 = object instanceof fz;
                    fz fz2 = null;
                    if (bl2) {
                        fz2 = (fz)object;
                    }
                    if (fz2 != null) {
                        fz2.onAnimationEnd(view);
                    }
                    this.b = true;
                }
            }

            @Override
            public void onAnimationStart(View view) {
                this.b = false;
                if (this.a.e >= 0) {
                    fb.a(view, 2, null);
                }
                if (this.a.c != null) {
                    Runnable runnable = this.a.c;
                    this.a.c = null;
                    runnable.run();
                }
                Object object = view.getTag(2113929216);
                boolean bl2 = object instanceof fz;
                fz fz2 = null;
                if (bl2) {
                    fz2 = (fz)object;
                }
                if (fz2 != null) {
                    fz2.onAnimationStart(view);
                }
            }
        }

    }

    static class c
    extends d {
        c() {
        }
    }

    static class d
    extends b {
        d() {
        }

        @Override
        public void a(fv fv2, View view, fz fz2) {
            fx.a(view, fz2);
        }
    }

    static class e
    extends c {
        e() {
        }

        @Override
        public void a(fv fv2, View view, gb gb2) {
            fy.a(view, gb2);
        }
    }

    static class f
    extends e {
        f() {
        }
    }

    static interface g {
        public long a(fv var1, View var2);

        public void a(fv var1, View var2, float var3);

        public void a(fv var1, View var2, long var3);

        public void a(fv var1, View var2, Interpolator var3);

        public void a(fv var1, View var2, fz var3);

        public void a(fv var1, View var2, gb var3);

        public void b(fv var1, View var2);

        public void b(fv var1, View var2, float var3);

        public void b(fv var1, View var2, long var3);

        public void c(fv var1, View var2);

        public void c(fv var1, View var2, float var3);
    }

}

