package defpackage;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: StateListAnimator */
final class z {
    private final ArrayList<z$a> a = new ArrayList();
    private z$a b = null;
    private Animation c = null;
    private WeakReference<View> d;
    private AnimationListener e = new z$1(this);

    z() {
    }

    public void a(int[] specs, Animation animation) {
        z$a tuple = new z$a(specs, animation, null);
        animation.setAnimationListener(this.e);
        this.a.add(tuple);
    }

    View a() {
        return this.d == null ? null : (View) this.d.get();
    }

    void a(View view) {
        View current = a();
        if (current != view) {
            if (current != null) {
                c();
            }
            if (view != null) {
                this.d = new WeakReference(view);
            }
        }
    }

    private void c() {
        View view = a();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (view.getAnimation() == ((z$a) this.a.get(i)).b) {
                view.clearAnimation();
            }
        }
        this.d = null;
        this.b = null;
        this.c = null;
    }

    void a(int[] state) {
        z$a match = null;
        int count = this.a.size();
        for (int i = 0; i < count; i++) {
            z$a tuple = (z$a) this.a.get(i);
            if (StateSet.stateSetMatches(tuple.a, state)) {
                match = tuple;
                break;
            }
        }
        if (match != this.b) {
            if (this.b != null) {
                d();
            }
            this.b = match;
            View view = (View) this.d.get();
            if (match != null && view != null && view.getVisibility() == 0) {
                a(match);
            }
        }
    }

    private void a(z$a match) {
        this.c = match.b;
        View view = a();
        if (view != null) {
            view.startAnimation(this.c);
        }
    }

    private void d() {
        if (this.c != null) {
            View view = a();
            if (view != null && view.getAnimation() == this.c) {
                view.clearAnimation();
            }
            this.c = null;
        }
    }

    public void b() {
        if (this.c != null) {
            View view = a();
            if (view != null && view.getAnimation() == this.c) {
                view.clearAnimation();
            }
        }
    }
}
