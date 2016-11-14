package defpackage;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* compiled from: VectorDrawableCompat */
public class ao extends an {
    static final Mode b = Mode.SRC_IN;
    private ao$f c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

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

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
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

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private ao() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new ao$f();
    }

    private ao(ao$f state) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = state;
        this.d = a(this.d, state.c, state.d);
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        } else if (!this.f && super.mutate() == this) {
            this.c = new ao$f(this.c);
            this.f = true;
        }
        return this;
    }

    Object a(String name) {
        return this.c.b.g.get(name);
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new ao$g(this.a.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.e == null ? this.d : this.e;
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float canvasScaleX = Math.abs(this.i[0]);
            float canvasScaleY = Math.abs(this.i[4]);
            float canvasSkewX = Math.abs(this.i[1]);
            float canvasSkewY = Math.abs(this.i[3]);
            if (!(canvasSkewX == 0.0f && canvasSkewY == 0.0f)) {
                canvasScaleX = 1.0f;
                canvasScaleY = 1.0f;
            }
            int scaledHeight = (int) (((float) this.k.height()) * canvasScaleY);
            int scaledWidth = Math.min(2048, (int) (((float) this.k.width()) * canvasScaleX));
            scaledHeight = Math.min(2048, scaledHeight);
            if (scaledWidth > 0 && scaledHeight > 0) {
                int saveCount = canvas.save();
                canvas.translate((float) this.k.left, (float) this.k.top);
                if (a()) {
                    canvas.translate((float) this.k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.c.b(scaledWidth, scaledHeight);
                if (!this.g) {
                    this.c.a(scaledWidth, scaledHeight);
                } else if (!this.c.b()) {
                    this.c.a(scaledWidth, scaledHeight);
                    this.c.c();
                }
                this.c.a(canvas, colorFilter, this.k);
                canvas.restoreToCount(saveCount);
            }
        }
    }

    public int getAlpha() {
        if (this.a != null) {
            return bv.c(this.a);
        }
        return this.c.b.a();
    }

    public void setAlpha(int alpha) {
        if (this.a != null) {
            this.a.setAlpha(alpha);
        } else if (this.c.b.a() != alpha) {
            this.c.b.a(alpha);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter a(PorterDuffColorFilter tintFilter, ColorStateList tint, Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        return new PorterDuffColorFilter(tint.getColorForState(getState(), 0), tintMode);
    }

    public void setTint(int tint) {
        if (this.a != null) {
            bv.a(this.a, tint);
        } else {
            setTintList(ColorStateList.valueOf(tint));
        }
    }

    public void setTintList(ColorStateList tint) {
        if (this.a != null) {
            bv.a(this.a, tint);
            return;
        }
        ao$f state = this.c;
        if (state.c != tint) {
            state.c = tint;
            this.d = a(this.d, tint, state.d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode tintMode) {
        if (this.a != null) {
            bv.a(this.a, tintMode);
            return;
        }
        ao$f state = this.c;
        if (state.d != tintMode) {
            state.d = tintMode;
            this.d = a(this.d, state.c, tintMode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return super.isStateful() || !(this.c == null || this.c.c == null || !this.c.c.isStateful());
    }

    protected boolean onStateChange(int[] stateSet) {
        if (this.a != null) {
            return this.a.setState(stateSet);
        }
        ao$f state = this.c;
        if (state.c == null || state.d == null) {
            return false;
        }
        this.d = a(this.d, state.c, state.d);
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return (int) this.c.b.a;
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return (int) this.c.b.b;
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            bv.d(this.a);
        }
        return false;
    }

    public static ao a(Resources res, int resId, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            ao drawable = new ao();
            drawable.a = bs.a(res, resId, theme);
            drawable.h = new ao$g(drawable.a.getConstantState());
            return drawable;
        }
        try {
            int type;
            XmlPullParser parser = res.getXml(resId);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            do {
                type = parser.next();
                if (type == 2) {
                    break;
                }
            } while (type != 1);
            if (type == 2) {
                return ao.a(res, parser, attrs, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (XmlPullParserException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static ao a(Resources r, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        ao drawable = new ao();
        drawable.inflate(r, parser, attrs, theme);
        return drawable;
    }

    private static int b(int color, float alpha) {
        return (color & 16777215) | (((int) (((float) Color.alpha(color)) * alpha)) << 24);
    }

    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        if (this.a != null) {
            this.a.inflate(res, parser, attrs);
        } else {
            inflate(res, parser, attrs, null);
        }
    }

    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        if (this.a != null) {
            bv.a(this.a, res, parser, attrs, theme);
            return;
        }
        ao$f state = this.c;
        state.b = new ao$e();
        TypedArray a = an.b(res, theme, attrs, aj.a);
        a(a, parser);
        a.recycle();
        state.a = getChangingConfigurations();
        state.k = true;
        b(res, parser, attrs, theme);
        this.d = a(this.d, state.c, state.d);
    }

    private static Mode a(int value, Mode defaultMode) {
        switch (value) {
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return Mode.SRC_OVER;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                return Mode.SRC_IN;
            case um$h.CardView_contentPaddingLeft /*9*/:
                return Mode.SRC_ATOP;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                return Mode.MULTIPLY;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                return Mode.SCREEN;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                return Mode.ADD;
            default:
                return defaultMode;
        }
    }

    private void a(TypedArray a, XmlPullParser parser) throws XmlPullParserException {
        ao$f state = this.c;
        ao$e pathRenderer = state.b;
        state.d = ao.a(am.a(a, parser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList tint = a.getColorStateList(1);
        if (tint != null) {
            state.c = tint;
        }
        state.e = am.a(a, parser, "autoMirrored", 5, state.e);
        pathRenderer.c = am.a(a, parser, "viewportWidth", 7, pathRenderer.c);
        pathRenderer.d = am.a(a, parser, "viewportHeight", 8, pathRenderer.d);
        if (pathRenderer.c <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (pathRenderer.d <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            pathRenderer.a = a.getDimension(3, pathRenderer.a);
            pathRenderer.b = a.getDimension(2, pathRenderer.b);
            if (pathRenderer.a <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (pathRenderer.b <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                pathRenderer.a(am.a(a, parser, "alpha", 4, pathRenderer.b()));
                String name = a.getString(0);
                if (name != null) {
                    pathRenderer.f = name;
                    pathRenderer.g.put(name, pathRenderer);
                }
            }
        }
    }

    private void b(Resources res, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        ao$f state = this.c;
        ao$e pathRenderer = state.b;
        boolean noPathTag = true;
        Stack<ao$c> groupStack = new Stack();
        groupStack.push(pathRenderer.p);
        int eventType = parser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String tagName = parser.getName();
                ao$c currentGroup = (ao$c) groupStack.peek();
                if ("path".equals(tagName)) {
                    ao$b path = new ao$b();
                    path.a(res, attrs, theme, parser);
                    currentGroup.a.add(path);
                    if (path.b() != null) {
                        pathRenderer.g.put(path.b(), path);
                    }
                    noPathTag = false;
                    state.a |= path.o;
                } else if ("clip-path".equals(tagName)) {
                    ao$a path2 = new ao$a();
                    path2.a(res, attrs, theme, parser);
                    currentGroup.a.add(path2);
                    if (path2.b() != null) {
                        pathRenderer.g.put(path2.b(), path2);
                    }
                    state.a |= path2.o;
                } else if ("group".equals(tagName)) {
                    ao$c newChildGroup = new ao$c();
                    newChildGroup.a(res, attrs, theme, parser);
                    currentGroup.a.add(newChildGroup);
                    groupStack.push(newChildGroup);
                    if (newChildGroup.a() != null) {
                        pathRenderer.g.put(newChildGroup.a(), newChildGroup);
                    }
                    state.a |= newChildGroup.k;
                }
            } else if (eventType == 3) {
                if ("group".equals(parser.getName())) {
                    groupStack.pop();
                }
            }
            eventType = parser.next();
        }
        if (noPathTag) {
            StringBuffer tag = new StringBuffer();
            if (tag.length() > 0) {
                tag.append(" or ");
            }
            tag.append("path");
            throw new XmlPullParserException("no " + tag + " defined");
        }
    }

    void a(boolean allowCaching) {
        this.g = allowCaching;
    }

    private boolean a() {
        return false;
    }

    protected void onBoundsChange(Rect bounds) {
        if (this.a != null) {
            this.a.setBounds(bounds);
        }
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable what, long when) {
        if (this.a != null) {
            this.a.scheduleSelf(what, when);
        } else {
            super.scheduleSelf(what, when);
        }
    }

    public boolean setVisible(boolean visible, boolean restart) {
        if (this.a != null) {
            return this.a.setVisible(visible, restart);
        }
        return super.setVisible(visible, restart);
    }

    public void unscheduleSelf(Runnable what) {
        if (this.a != null) {
            this.a.unscheduleSelf(what);
        } else {
            super.unscheduleSelf(what);
        }
    }
}
