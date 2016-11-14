package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* compiled from: AnimatedVectorDrawableCompat */
public class ak extends an implements Animatable {
    private ak$a b;
    private Context c;
    private ArgbEvaluator d;
    private final Callback e;

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect x0) {
        return super.getPadding(x0);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean x0) {
        super.setAutoMirrored(x0);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int x0) {
        super.setChangingConfigurations(x0);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int x0, Mode x1) {
        super.setColorFilter(x0, x1);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean x0) {
        super.setFilterBitmap(x0);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float x0, float x1) {
        super.setHotspot(x0, x1);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int x0, int x1, int x2, int x3) {
        super.setHotspotBounds(x0, x1, x2, x3);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] x0) {
        return super.setState(x0);
    }

    private ak() {
        this(null, null, null);
    }

    private ak(Context context) {
        this(context, null, null);
    }

    private ak(Context context, ak$a state, Resources res) {
        this.d = null;
        this.e = new ak$1(this);
        this.c = context;
        if (state != null) {
            this.b = state;
        } else {
            this.b = new ak$a(context, state, this.e, res);
        }
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static ak a(Context context, Resources r, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        ak drawable = new ak(context);
        drawable.inflate(r, parser, attrs, theme);
        return drawable;
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new ak$b(this.a.getConstantState());
        }
        return null;
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.a;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.b.b.draw(canvas);
        if (a()) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect bounds) {
        if (this.a != null) {
            this.a.setBounds(bounds);
        } else {
            this.b.b.setBounds(bounds);
        }
    }

    protected boolean onStateChange(int[] state) {
        if (this.a != null) {
            return this.a.setState(state);
        }
        return this.b.b.setState(state);
    }

    protected boolean onLevelChange(int level) {
        if (this.a != null) {
            return this.a.setLevel(level);
        }
        return this.b.b.setLevel(level);
    }

    public int getAlpha() {
        if (this.a != null) {
            return bv.c(this.a);
        }
        return this.b.b.getAlpha();
    }

    public void setAlpha(int alpha) {
        if (this.a != null) {
            this.a.setAlpha(alpha);
        } else {
            this.b.b.setAlpha(alpha);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.b.b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int tint) {
        if (this.a != null) {
            bv.a(this.a, tint);
        } else {
            this.b.b.setTint(tint);
        }
    }

    public void setTintList(ColorStateList tint) {
        if (this.a != null) {
            bv.a(this.a, tint);
        } else {
            this.b.b.setTintList(tint);
        }
    }

    public void setTintMode(Mode tintMode) {
        if (this.a != null) {
            bv.a(this.a, tintMode);
        } else {
            this.b.b.setTintMode(tintMode);
        }
    }

    public boolean setVisible(boolean visible, boolean restart) {
        if (this.a != null) {
            return this.a.setVisible(visible, restart);
        }
        this.b.b.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return this.b.b.isStateful();
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return this.b.b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return this.b.b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return this.b.b.getIntrinsicHeight();
    }

    static TypedArray a(Resources res, Theme theme, AttributeSet set, int[] attrs) {
        if (theme == null) {
            return res.obtainAttributes(set, attrs);
        }
        return theme.obtainStyledAttributes(set, attrs, 0, 0);
    }

    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        if (this.a != null) {
            bv.a(this.a, res, parser, attrs, theme);
            return;
        }
        int eventType = parser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String tagName = parser.getName();
                TypedArray a;
                if ("animated-vector".equals(tagName)) {
                    a = ak.a(res, theme, attrs, aj.e);
                    int drawableRes = a.getResourceId(0, 0);
                    if (drawableRes != 0) {
                        ao vectorDrawable = ao.a(res, drawableRes, theme);
                        vectorDrawable.a(false);
                        vectorDrawable.setCallback(this.e);
                        if (this.b.b != null) {
                            this.b.b.setCallback(null);
                        }
                        this.b.b = vectorDrawable;
                    }
                    a.recycle();
                } else if ("target".equals(tagName)) {
                    a = res.obtainAttributes(attrs, aj.f);
                    String target = a.getString(0);
                    int id = a.getResourceId(1, 0);
                    if (id != 0) {
                        if (this.c != null) {
                            a(target, AnimatorInflater.loadAnimator(this.c, id));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = parser.next();
        }
    }

    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        inflate(res, parser, attrs, null);
    }

    public void applyTheme(Theme t) {
        if (this.a != null) {
            bv.a(this.a, t);
        }
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            return bv.d(this.a);
        }
        return false;
    }

    private void a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List<Animator> childAnimators = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimators != null) {
                for (int i = 0; i < childAnimators.size(); i++) {
                    a((Animator) childAnimators.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnim = (ObjectAnimator) animator;
            String propertyName = objectAnim.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.d == null) {
                    this.d = new ArgbEvaluator();
                }
                objectAnim.setEvaluator(this.d);
            }
        }
    }

    private void a(String name, Animator animator) {
        animator.setTarget(this.b.b.a(name));
        if (VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.b.c == null) {
            this.b.c = new ArrayList();
            this.b.d = new dh();
        }
        this.b.c.add(animator);
        this.b.d.put(animator, name);
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable) this.a).isRunning();
        }
        ArrayList<Animator> animators = this.b.c;
        int size = animators.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) animators.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean a() {
        ArrayList<Animator> animators = this.b.c;
        if (animators == null) {
            return false;
        }
        int size = animators.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) animators.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).start();
        } else if (!a()) {
            ArrayList<Animator> animators = this.b.c;
            int size = animators.size();
            for (int i = 0; i < size; i++) {
                ((Animator) animators.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).stop();
            return;
        }
        ArrayList<Animator> animators = this.b.c;
        int size = animators.size();
        for (int i = 0; i < size; i++) {
            ((Animator) animators.get(i)).end();
        }
    }
}
