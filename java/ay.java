/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.ArrayList
 *  java.util.List
 */
import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;

class ay
implements aw {
    ay() {
    }

    @Override
    public ba a() {
        return new a();
    }

    @Override
    public void a(View view) {
    }

    static class a
    implements ba {
        List<av> a = new ArrayList();
        List<ax> b = new ArrayList();
        View c;
        private long d;
        private long e = 200;
        private float f = 0.0f;
        private boolean g = false;
        private boolean h = false;
        private Runnable i;

        public a() {
            this.i = new Runnable(){

                public void run() {
                    float f2 = 1.0f * (float)(a.this.e() - a.this.d) / (float)a.this.e;
                    if (f2 > 1.0f || a.this.c.getParent() == null) {
                        f2 = 1.0f;
                    }
                    a.this.f = f2;
                    a.this.d();
                    if (a.this.f >= 1.0f) {
                        a.this.g();
                        return;
                    }
                    a.this.c.postDelayed(a.this.i, 16);
                }
            };
        }

        private void d() {
            for (int i2 = -1 + this.b.size(); i2 >= 0; --i2) {
                ((ax)this.b.get(i2)).onAnimationUpdate(this);
            }
        }

        private long e() {
            return this.c.getDrawingTime();
        }

        private void f() {
            for (int i2 = -1 + this.a.size(); i2 >= 0; --i2) {
                ((av)this.a.get(i2)).onAnimationStart(this);
            }
        }

        private void g() {
            for (int i2 = -1 + this.a.size(); i2 >= 0; --i2) {
                ((av)this.a.get(i2)).onAnimationEnd(this);
            }
        }

        private void h() {
            for (int i2 = -1 + this.a.size(); i2 >= 0; --i2) {
                ((av)this.a.get(i2)).onAnimationCancel(this);
            }
        }

        @Override
        public void a() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.f();
            this.f = 0.0f;
            this.d = this.e();
            this.c.postDelayed(this.i, 16);
        }

        @Override
        public void a(long l2) {
            if (!this.g) {
                this.e = l2;
            }
        }

        @Override
        public void a(View view) {
            this.c = view;
        }

        @Override
        public void a(av av2) {
            this.a.add((Object)av2);
        }

        @Override
        public void a(ax ax2) {
            this.b.add((Object)ax2);
        }

        @Override
        public void b() {
            if (this.h) {
                return;
            }
            this.h = true;
            if (this.g) {
                this.h();
            }
            this.g();
        }

        @Override
        public float c() {
            return this.f;
        }

    }

}

