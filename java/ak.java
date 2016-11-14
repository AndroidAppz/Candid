/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.ArgbEvaluator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimatedVectorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(value=21)
public class ak
extends an
implements Animatable {
    private a b;
    private Context c;
    private ArgbEvaluator d;
    private final Drawable.Callback e;

    private ak() {
        this(null, null, null);
    }

    /* synthetic */ ak( var1) {
    }

    private ak(Context context) {
        super(context, null, null);
    }

    private ak(Context context, a a2, Resources resources) {
        this.d = null;
        this.e = new Drawable.Callback(){

            public void invalidateDrawable(Drawable drawable) {
                ak.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
                ak.this.scheduleSelf(runnable, l2);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                ak.this.unscheduleSelf(runnable);
            }
        };
        this.c = context;
        if (a2 != null) {
            this.b = a2;
            return;
        }
        this.b = new a(context, a2, this.e, resources);
    }

    public static ak a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ak ak2 = new ak(context);
        ak2.inflate(resources, xmlPullParser, attributeSet, theme);
        return ak2;
    }

    static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] arrn) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, arrn);
        }
        return theme.obtainStyledAttributes(attributeSet, arrn, 0, 0);
    }

    private void a(Animator animator) {
        ArrayList arrayList;
        ObjectAnimator objectAnimator;
        String string2;
        if (animator instanceof AnimatorSet && (arrayList = ((AnimatorSet)animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                super.a((Animator)arrayList.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator && ("fillColor".equals((Object)(string2 = (objectAnimator = (ObjectAnimator)animator).getPropertyName())) || "strokeColor".equals((Object)string2))) {
            if (this.d == null) {
                this.d = new ArgbEvaluator();
            }
            objectAnimator.setEvaluator((TypeEvaluator)this.d);
        }
    }

    private void a(String string2, Animator animator) {
        animator.setTarget(this.b.b.a(string2));
        if (Build.VERSION.SDK_INT < 21) {
            super.a(animator);
        }
        if (this.b.c == null) {
            this.b.c = new ArrayList();
            this.b.d = new dh();
        }
        this.b.c.add((Object)animator);
        this.b.d.put(animator, string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a() {
        ArrayList<Animator> arrayList = this.b.c;
        if (arrayList == null) {
            return false;
        }
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            if (((Animator)arrayList.get(n3)).isRunning()) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        if (this.a != null) {
            bv.a(this.a, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            return bv.d(this.a);
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        } else {
            this.b.b.draw(canvas);
            if (!super.a()) return;
            {
                this.invalidateSelf();
                return;
            }
        }
    }

    public int getAlpha() {
        if (this.a != null) {
            return bv.c(this.a);
        }
        return this.b.b.getAlpha();
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.a;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.a != null) {
            return new b(this.a.getConstantState());
        }
        return null;
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return this.b.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return this.b.b.getIntrinsicWidth();
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return this.b.b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.a != null) {
            bv.a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int n2 = xmlPullParser.getEventType();
        while (n2 != 1) {
            if (n2 == 2) {
                String string2 = xmlPullParser.getName();
                if ("animated-vector".equals((Object)string2)) {
                    TypedArray typedArray = ak.a(resources, theme, attributeSet, aj.e);
                    int n3 = typedArray.getResourceId(0, 0);
                    if (n3 != 0) {
                        ao ao2 = ao.a(resources, n3, theme);
                        ao2.a(false);
                        ao2.setCallback(this.e);
                        if (this.b.b != null) {
                            this.b.b.setCallback(null);
                        }
                        this.b.b = ao2;
                    }
                    typedArray.recycle();
                } else if ("target".equals((Object)string2)) {
                    TypedArray typedArray = resources.obtainAttributes(attributeSet, aj.f);
                    String string3 = typedArray.getString(0);
                    int n4 = typedArray.getResourceId(1, 0);
                    if (n4 != 0) {
                        if (this.c == null) {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        super.a(string3, AnimatorInflater.loadAnimator((Context)this.c, (int)n4));
                    }
                    typedArray.recycle();
                }
            }
            n2 = xmlPullParser.next();
        }
        return;
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable)this.a).isRunning();
        }
        ArrayList<Animator> arrayList = this.b.c;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((Animator)arrayList.get(i2)).isRunning()) continue;
            return true;
        }
        return false;
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return this.b.b.isStateful();
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    @Override
    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
            return;
        }
        this.b.b.setBounds(rect);
    }

    @Override
    protected boolean onLevelChange(int n2) {
        if (this.a != null) {
            return this.a.setLevel(n2);
        }
        return this.b.b.setLevel(n2);
    }

    protected boolean onStateChange(int[] arrn) {
        if (this.a != null) {
            return this.a.setState(arrn);
        }
        return this.b.b.setState(arrn);
    }

    public void setAlpha(int n2) {
        if (this.a != null) {
            this.a.setAlpha(n2);
            return;
        }
        this.b.b.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.b.b.setColorFilter(colorFilter);
    }

    @Override
    public void setTint(int n2) {
        if (this.a != null) {
            bv.a(this.a, n2);
            return;
        }
        this.b.b.setTint(n2);
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            bv.a(this.a, colorStateList);
            return;
        }
        this.b.b.setTintList(colorStateList);
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            bv.a(this.a, mode);
            return;
        }
        this.b.b.setTintMode(mode);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        if (this.a != null) {
            return this.a.setVisible(bl2, bl3);
        }
        this.b.b.setVisible(bl2, bl3);
        return super.setVisible(bl2, bl3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable)this.a).start();
            return;
        } else {
            if (this.a()) return;
            {
                ArrayList<Animator> arrayList = this.b.c;
                int n2 = arrayList.size();
                int n3 = 0;
                do {
                    if (n3 >= n2) {
                        this.invalidateSelf();
                        return;
                    }
                    ((Animator)arrayList.get(n3)).start();
                    ++n3;
                } while (true);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable)this.a).stop();
            return;
        }
        ArrayList<Animator> arrayList = this.b.c;
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            ((Animator)arrayList.get(n3)).end();
            ++n3;
        }
    }

    static class a
    extends Drawable.ConstantState {
        int a;
        ao b;
        ArrayList<Animator> c;
        dh<Animator, String> d;

        /*
         * Enabled aggressive block sorting
         */
        public a(Context context, a a2, Drawable.Callback callback, Resources resources) {
            if (a2 != null) {
                this.a = a2.a;
                if (a2.b != null) {
                    Drawable.ConstantState constantState = a2.b.getConstantState();
                    this.b = resources != null ? (ao)constantState.newDrawable(resources) : (ao)constantState.newDrawable();
                    this.b = (ao)this.b.mutate();
                    this.b.setCallback(callback);
                    this.b.setBounds(a2.b.getBounds());
                    this.b.a(false);
                }
                if (a2.c != null) {
                    int n2 = a2.c.size();
                    this.c = new ArrayList(n2);
                    this.d = new dh(n2);
                    int n3 = 0;
                    while (n3 < n2) {
                        Animator animator = (Animator)a2.c.get(n3);
                        Animator animator2 = animator.clone();
                        String string2 = a2.d.get((Object)animator);
                        animator2.setTarget(this.b.a(string2));
                        this.c.add((Object)animator2);
                        this.d.put(animator2, string2);
                        ++n3;
                    }
                    return;
                }
            }
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }
    }

    static class b
    extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public b(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            ak ak2 = new ak(null);
            ak2.a = this.a.newDrawable();
            ak2.a.setCallback(ak2.e);
            return ak2;
        }

        public Drawable newDrawable(Resources resources) {
            ak ak2 = new ak(null);
            ak2.a = this.a.newDrawable(resources);
            ak2.a.setCallback(ak2.e);
            return ak2;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            ak ak2 = new ak(null);
            ak2.a = this.a.newDrawable(resources, theme);
            ak2.a.setCallback(ak2.e);
            return ak2;
        }
    }

}

