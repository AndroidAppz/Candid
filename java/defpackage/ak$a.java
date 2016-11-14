package defpackage;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import java.util.ArrayList;

/* compiled from: AnimatedVectorDrawableCompat */
class ak$a extends ConstantState {
    int a;
    ao b;
    ArrayList<Animator> c;
    dh<Animator, String> d;

    public ak$a(Context context, ak$a copy, Callback owner, Resources res) {
        if (copy != null) {
            this.a = copy.a;
            if (copy.b != null) {
                ConstantState cs = copy.b.getConstantState();
                if (res != null) {
                    this.b = (ao) cs.newDrawable(res);
                } else {
                    this.b = (ao) cs.newDrawable();
                }
                this.b = (ao) this.b.mutate();
                this.b.setCallback(owner);
                this.b.setBounds(copy.b.getBounds());
                this.b.a(false);
            }
            if (copy.c != null) {
                int numAnimators = copy.c.size();
                this.c = new ArrayList(numAnimators);
                this.d = new dh(numAnimators);
                for (int i = 0; i < numAnimators; i++) {
                    Animator anim = (Animator) copy.c.get(i);
                    Animator animClone = anim.clone();
                    String targetName = (String) copy.d.get(anim);
                    animClone.setTarget(this.b.a(targetName));
                    this.c.add(animClone);
                    this.d.put(animClone, targetName);
                }
            }
        }
    }

    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 23.");
    }

    public Drawable newDrawable(Resources res) {
        throw new IllegalStateException("No constant state support for SDK < 23.");
    }

    public int getChangingConfigurations() {
        return this.a;
    }
}
