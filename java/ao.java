/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.VectorDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Stack
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(value=21)
public class ao
extends an {
    static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    private f c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    private ao() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new f();
    }

    /* synthetic */ ao( var1) {
    }

    private ao(f f2) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = f2;
        this.d = this.a(this.d, f2.c, f2.d);
    }

    /* synthetic */ ao(f f2,  var2_2) {
        super(f2);
    }

    private static PorterDuff.Mode a(int n2, PorterDuff.Mode mode) {
        switch (n2) {
            default: {
                return mode;
            }
            case 3: {
                return PorterDuff.Mode.SRC_OVER;
            }
            case 5: {
                return PorterDuff.Mode.SRC_IN;
            }
            case 9: {
                return PorterDuff.Mode.SRC_ATOP;
            }
            case 14: {
                return PorterDuff.Mode.MULTIPLY;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 16: 
        }
        return PorterDuff.Mode.ADD;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ao a(Resources resources, int n2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            ao ao2 = new ao();
            ao2.a = bs.a(resources, n2, theme);
            ao2.h = new g(ao2.a.getConstantState());
            return ao2;
        }
        try {
            int n3;
            XmlResourceParser xmlResourceParser = resources.getXml(n2);
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
            while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
            }
            if (n3 == 2) return ao.a(resources, (XmlPullParser)xmlResourceParser, attributeSet, theme);
            throw new XmlPullParserException("No start tag found");
        }
        catch (XmlPullParserException var6_7) {
            Log.e((String)"VectorDrawableCompat", (String)"parser error", (Throwable)var6_7);
            return null;
        }
        catch (IOException var4_9) {
            Log.e((String)"VectorDrawableCompat", (String)"parser error", (Throwable)var4_9);
            return null;
        }
    }

    public static ao a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ao ao2 = new ao();
        ao2.inflate(resources, xmlPullParser, attributeSet, theme);
        return ao2;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        f f2 = this.c;
        e e2 = f2.b;
        f2.d = ao.a(am.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            f2.c = colorStateList;
        }
        f2.e = am.a(typedArray, xmlPullParser, "autoMirrored", 5, f2.e);
        e2.c = am.a(typedArray, xmlPullParser, "viewportWidth", 7, e2.c);
        e2.d = am.a(typedArray, xmlPullParser, "viewportHeight", 8, e2.d);
        if (e2.c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (e2.d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        e2.a = typedArray.getDimension(3, e2.a);
        e2.b = typedArray.getDimension(2, e2.b);
        if (e2.a <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (e2.b <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        e2.a(am.a(typedArray, xmlPullParser, "alpha", 4, e2.b()));
        String string2 = typedArray.getString(0);
        if (string2 != null) {
            e2.f = string2;
            e2.g.put(string2, e2);
        }
    }

    private boolean a() {
        return false;
    }

    private static int b(int n2, float f2) {
        int n3 = Color.alpha((int)n2);
        return n2 & 16777215 | (int)(f2 * (float)n3) << 24;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        f f2 = this.c;
        e e2 = f2.b;
        boolean bl2 = true;
        Stack stack = new Stack();
        stack.push((Object)e2.p);
        int n2 = xmlPullParser.getEventType();
        while (n2 != 1) {
            if (n2 == 2) {
                String string2 = xmlPullParser.getName();
                c c2 = (c)stack.peek();
                if ("path".equals((Object)string2)) {
                    b b2 = new b();
                    b2.a(resources, attributeSet, theme, xmlPullParser);
                    c2.a.add((Object)b2);
                    if (b2.b() != null) {
                        e2.g.put(b2.b(), b2);
                    }
                    bl2 = false;
                    f2.a |= b2.o;
                } else if ("clip-path".equals((Object)string2)) {
                    a a2 = new a();
                    a2.a(resources, attributeSet, theme, xmlPullParser);
                    c2.a.add((Object)a2);
                    if (a2.b() != null) {
                        e2.g.put(a2.b(), a2);
                    }
                    f2.a |= a2.o;
                } else if ("group".equals((Object)string2)) {
                    c c3 = new c();
                    c3.a(resources, attributeSet, theme, xmlPullParser);
                    c2.a.add((Object)c3);
                    stack.push((Object)c3);
                    if (c3.a() != null) {
                        e2.g.put(c3.a(), c3);
                    }
                    f2.a |= c3.k;
                }
            } else if (n2 == 3 && "group".equals((Object)xmlPullParser.getName())) {
                stack.pop();
            }
            n2 = xmlPullParser.next();
        }
        if (!bl2) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (stringBuffer.length() > 0) {
            stringBuffer.append(" or ");
        }
        stringBuffer.append("path");
        throw new XmlPullParserException("no " + (Object)stringBuffer + " defined");
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
    }

    Object a(String string2) {
        return this.c.b.g.get(string2);
    }

    void a(boolean bl2) {
        this.g = bl2;
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            bv.d(this.a);
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
        }
        this.copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) return;
        PorterDuffColorFilter porterDuffColorFilter = this.e == null ? this.d : this.e;
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float f2 = Math.abs((float)this.i[0]);
        float f3 = Math.abs((float)this.i[4]);
        float f4 = Math.abs((float)this.i[1]);
        float f5 = Math.abs((float)this.i[3]);
        if (f4 != 0.0f || f5 != 0.0f) {
            f2 = 1.0f;
            f3 = 1.0f;
        }
        int n2 = (int)(f2 * (float)this.k.width());
        int n3 = (int)(f3 * (float)this.k.height());
        int n4 = Math.min((int)2048, (int)n2);
        int n5 = Math.min((int)2048, (int)n3);
        if (n4 <= 0 || n5 <= 0) return;
        int n6 = canvas.save();
        canvas.translate((float)this.k.left, (float)this.k.top);
        if (super.a()) {
            canvas.translate((float)this.k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.c.b(n4, n5);
        if (!this.g) {
            this.c.a(n4, n5);
        } else if (!this.c.b()) {
            this.c.a(n4, n5);
            this.c.c();
        }
        this.c.a(canvas, (ColorFilter)porterDuffColorFilter, this.k);
        canvas.restoreToCount(n6);
    }

    public int getAlpha() {
        if (this.a != null) {
            return bv.c(this.a);
        }
        return this.c.b.a();
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.a != null) {
            return new g(this.a.getConstantState());
        }
        this.c.a = this.getChangingConfigurations();
        return this.c;
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return (int)this.c.b.b;
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return (int)this.c.b.a;
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
            return;
        }
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.a != null) {
            bv.a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f f2 = this.c;
        f2.b = new e();
        TypedArray typedArray = ao.b(resources, theme, attributeSet, aj.a);
        super.a(typedArray, xmlPullParser);
        typedArray.recycle();
        f2.a = this.getChangingConfigurations();
        f2.k = true;
        super.b(resources, xmlPullParser, attributeSet, theme);
        this.d = this.a(this.d, f2.c, f2.d);
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
            return;
        }
        super.invalidateSelf();
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        if (super.isStateful() || this.c != null && this.c.c != null && this.c.c.isStateful()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        } else {
            if (this.f || super.mutate() != this) return this;
            {
                this.c = new f(this.c);
                this.f = true;
                return this;
            }
        }
    }

    @Override
    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] arrn) {
        if (this.a != null) {
            return this.a.setState(arrn);
        }
        f f2 = this.c;
        if (f2.c != null && f2.d != null) {
            this.d = this.a(this.d, f2.c, f2.d);
            this.invalidateSelf();
            return true;
        }
        return false;
    }

    public void scheduleSelf(Runnable runnable, long l2) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, l2);
            return;
        }
        super.scheduleSelf(runnable, l2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setAlpha(int n2) {
        if (this.a != null) {
            this.a.setAlpha(n2);
            return;
        } else {
            if (this.c.b.a() == n2) return;
            {
                this.c.b.a(n2);
                this.invalidateSelf();
                return;
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        this.invalidateSelf();
    }

    @Override
    public void setTint(int n2) {
        if (this.a != null) {
            bv.a(this.a, n2);
            return;
        }
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            bv.a(this.a, colorStateList);
            return;
        } else {
            f f2 = this.c;
            if (f2.c == colorStateList) return;
            {
                f2.c = colorStateList;
                this.d = this.a(this.d, colorStateList, f2.d);
                this.invalidateSelf();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            bv.a(this.a, mode);
            return;
        } else {
            f f2 = this.c;
            if (f2.d == mode) return;
            {
                f2.d = mode;
                this.d = this.a(this.d, f2.c, mode);
                this.invalidateSelf();
                return;
            }
        }
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        if (this.a != null) {
            return this.a.setVisible(bl2, bl3);
        }
        return super.setVisible(bl2, bl3);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
            return;
        }
        super.unscheduleSelf(runnable);
    }

    static class a
    extends d {
        public a() {
        }

        public a(a a2) {
            super(a2);
        }

        private void a(TypedArray typedArray) {
            String string2;
            String string3 = typedArray.getString(0);
            if (string3 != null) {
                this.n = string3;
            }
            if ((string2 = typedArray.getString(1)) != null) {
                this.m = al.a(string2);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!am.a(xmlPullParser, "pathData")) {
                return;
            }
            TypedArray typedArray = an.b(resources, theme, attributeSet, aj.d);
            super.a(typedArray);
            typedArray.recycle();
        }

        @Override
        public boolean a() {
            return true;
        }
    }

    static class b
    extends d {
        int a;
        float b;
        int c;
        float d;
        int e;
        float f;
        float g;
        float h;
        float i;
        Paint.Cap j;
        Paint.Join k;
        float l;
        private int[] p;

        public b() {
            this.a = 0;
            this.b = 0.0f;
            this.c = 0;
            this.d = 1.0f;
            this.f = 1.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = Paint.Cap.BUTT;
            this.k = Paint.Join.MITER;
            this.l = 4.0f;
        }

        public b(b b2) {
            super(b2);
            this.a = 0;
            this.b = 0.0f;
            this.c = 0;
            this.d = 1.0f;
            this.f = 1.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = Paint.Cap.BUTT;
            this.k = Paint.Join.MITER;
            this.l = 4.0f;
            this.p = b2.p;
            this.a = b2.a;
            this.b = b2.b;
            this.d = b2.d;
            this.c = b2.c;
            this.e = b2.e;
            this.f = b2.f;
            this.g = b2.g;
            this.h = b2.h;
            this.i = b2.i;
            this.j = b2.j;
            this.k = b2.k;
            this.l = b2.l;
        }

        private Paint.Cap a(int n2, Paint.Cap cap) {
            switch (n2) {
                default: {
                    return cap;
                }
                case 0: {
                    return Paint.Cap.BUTT;
                }
                case 1: {
                    return Paint.Cap.ROUND;
                }
                case 2: 
            }
            return Paint.Cap.SQUARE;
        }

        private Paint.Join a(int n2, Paint.Join join) {
            switch (n2) {
                default: {
                    return join;
                }
                case 0: {
                    return Paint.Join.MITER;
                }
                case 1: {
                    return Paint.Join.ROUND;
                }
                case 2: 
            }
            return Paint.Join.BEVEL;
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string2;
            this.p = null;
            if (!am.a(xmlPullParser, "pathData")) {
                return;
            }
            String string3 = typedArray.getString(0);
            if (string3 != null) {
                this.n = string3;
            }
            if ((string2 = typedArray.getString(2)) != null) {
                this.m = al.a(string2);
            }
            this.c = am.b(typedArray, xmlPullParser, "fillColor", 1, this.c);
            this.f = am.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
            this.j = super.a(am.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
            this.k = super.a(am.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
            this.l = am.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
            this.a = am.b(typedArray, xmlPullParser, "strokeColor", 3, this.a);
            this.d = am.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
            this.b = am.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
            this.h = am.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
            this.i = am.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
            this.g = am.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArray = an.b(resources, theme, attributeSet, aj.c);
            super.a(typedArray, xmlPullParser);
            typedArray.recycle();
        }
    }

    static class c {
        final ArrayList<Object> a;
        private final Matrix b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private final Matrix j;
        private int k;
        private int[] l;
        private String m;

        public c() {
            this.b = new Matrix();
            this.a = new ArrayList();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        /*
         * Enabled aggressive block sorting
         */
        public c(c c2, dh<String, Object> dh2) {
            this.b = new Matrix();
            this.a = new ArrayList();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.c = c2.c;
            this.d = c2.d;
            this.e = c2.e;
            this.f = c2.f;
            this.g = c2.g;
            this.h = c2.h;
            this.i = c2.i;
            this.l = c2.l;
            this.m = c2.m;
            this.k = c2.k;
            if (this.m != null) {
                dh2.put(this.m, this);
            }
            this.j.set(c2.j);
            ArrayList<Object> arrayList = c2.a;
            int n2 = 0;
            while (n2 < arrayList.size()) {
                Object object = arrayList.get(n2);
                if (object instanceof c) {
                    c c3 = (c)object;
                    this.a.add((Object)new c(c3, dh2));
                } else {
                    void var6_7;
                    if (object instanceof b) {
                        b b2 = new b((b)object);
                    } else {
                        if (!(object instanceof a)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        a a2 = new a((a)object);
                    }
                    this.a.add((Object)var6_7);
                    if (var6_7.n != null) {
                        dh2.put(var6_7.n, var6_7);
                    }
                }
                ++n2;
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = am.a(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = am.a(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = am.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = am.a(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = am.a(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string2 = typedArray.getString(0);
            if (string2 != null) {
                this.m = string2;
            }
            super.b();
        }

        private void b() {
            this.j.reset();
            this.j.postTranslate(- this.d, - this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public String a() {
            return this.m;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArray = an.b(resources, theme, attributeSet, aj.b);
            super.a(typedArray, xmlPullParser);
            typedArray.recycle();
        }
    }

    static class d {
        protected al.b[] m;
        String n;
        int o;

        public d() {
            this.m = null;
        }

        public d(d d2) {
            this.m = null;
            this.n = d2.n;
            this.o = d2.o;
            this.m = al.a(d2.m);
        }

        public void a(Path path) {
            path.reset();
            if (this.m != null) {
                al.b.a(this.m, path);
            }
        }

        public boolean a() {
            return false;
        }

        public String b() {
            return this.n;
        }
    }

    static class e {
        private static final Matrix j = new Matrix();
        float a;
        float b;
        float c;
        float d;
        int e;
        String f;
        final dh<String, Object> g;
        private final Path h;
        private final Path i;
        private final Matrix k;
        private Paint l;
        private Paint m;
        private PathMeasure n;
        private int o;
        private final c p;

        public e() {
            this.k = new Matrix();
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 255;
            this.f = null;
            this.g = new dh();
            this.p = new c();
            this.h = new Path();
            this.i = new Path();
        }

        public e(e e2) {
            this.k = new Matrix();
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 255;
            this.f = null;
            this.g = new dh();
            this.p = new c(e2.p, this.g);
            this.h = new Path(e2.h);
            this.i = new Path(e2.i);
            this.a = e2.a;
            this.b = e2.b;
            this.c = e2.c;
            this.d = e2.d;
            this.o = e2.o;
            this.e = e2.e;
            this.f = e2.f;
            if (e2.f != null) {
                this.g.put(e2.f, this);
            }
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return f2 * f5 - f3 * f4;
        }

        private float a(Matrix matrix) {
            float[] arrf = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(arrf);
            float f2 = (float)Math.hypot((double)arrf[0], (double)arrf[1]);
            float f3 = (float)Math.hypot((double)arrf[2], (double)arrf[3]);
            float f4 = e.a(arrf[0], arrf[1], arrf[2], arrf[3]);
            float f5 = Math.max((float)f2, (float)f3);
            float f6 = f5 FCMPL 0.0f;
            float f7 = 0.0f;
            if (f6 > 0) {
                f7 = Math.abs((float)f4) / f5;
            }
            return f7;
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(c c2, Matrix matrix, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
            c2.b.set(matrix);
            c2.b.preConcat(c2.j);
            int n4 = 0;
            while (n4 < c2.a.size()) {
                Object object = c2.a.get(n4);
                if (object instanceof c) {
                    this.a((c)object, c2.b, canvas, n2, n3, colorFilter);
                } else if (object instanceof d) {
                    this.a(c2, (d)object, canvas, n2, n3, colorFilter);
                }
                ++n4;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private void a(c c2, d d2, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
            float f2 = (float)n2 / this.c;
            float f3 = (float)n3 / this.d;
            float f4 = Math.min((float)f2, (float)f3);
            Matrix matrix = c2.b;
            this.k.set(matrix);
            this.k.postScale(f2, f3);
            float f5 = this.a(matrix);
            if (f5 == 0.0f) {
                return;
            }
            d2.a(this.h);
            Path path = this.h;
            this.i.reset();
            if (d2.a()) {
                this.i.addPath(path, this.k);
                canvas.clipPath(this.i, Region.Op.REPLACE);
                return;
            }
            b b2 = (b)d2;
            if (b2.g != 0.0f || b2.h != 1.0f) {
                float f6 = (b2.g + b2.i) % 1.0f;
                float f7 = (b2.h + b2.i) % 1.0f;
                if (this.n == null) {
                    this.n = new PathMeasure();
                }
                this.n.setPath(this.h, false);
                float f8 = this.n.getLength();
                float f9 = f6 * f8;
                float f10 = f7 * f8;
                path.reset();
                if (f9 > f10) {
                    this.n.getSegment(f9, f8, path, true);
                    this.n.getSegment(0.0f, f10, path, true);
                } else {
                    this.n.getSegment(f9, f10, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.i.addPath(path, this.k);
            if (b2.c != 0) {
                if (this.m == null) {
                    this.m = new Paint();
                    this.m.setStyle(Paint.Style.FILL);
                    this.m.setAntiAlias(true);
                }
                Paint paint = this.m;
                paint.setColor(ao.b(b2.c, b2.f));
                paint.setColorFilter(colorFilter);
                canvas.drawPath(this.i, paint);
            }
            if (b2.a == 0) return;
            if (this.l == null) {
                this.l = new Paint();
                this.l.setStyle(Paint.Style.STROKE);
                this.l.setAntiAlias(true);
            }
            Paint paint = this.l;
            if (b2.k != null) {
                paint.setStrokeJoin(b2.k);
            }
            if (b2.j != null) {
                paint.setStrokeCap(b2.j);
            }
            paint.setStrokeMiter(b2.l);
            paint.setColor(ao.b(b2.a, b2.d));
            paint.setColorFilter(colorFilter);
            paint.setStrokeWidth(f4 * f5 * b2.b);
            canvas.drawPath(this.i, paint);
        }

        public int a() {
            return this.e;
        }

        public void a(float f2) {
            this.a((int)(255.0f * f2));
        }

        public void a(int n2) {
            this.e = n2;
        }

        public void a(Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
            super.a(this.p, j, canvas, n2, n3, colorFilter);
        }

        public float b() {
            return (float)this.a() / 255.0f;
        }
    }

    static class f
    extends Drawable.ConstantState {
        int a;
        e b;
        ColorStateList c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public f() {
            this.c = null;
            this.d = ao.b;
            this.b = new e();
        }

        public f(f f2) {
            this.c = null;
            this.d = ao.b;
            if (f2 != null) {
                this.a = f2.a;
                this.b = new e(f2.b);
                if (f2.b.m != null) {
                    this.b.m = new Paint(f2.b.m);
                }
                if (f2.b.l != null) {
                    this.b.l = new Paint(f2.b.l);
                }
                this.c = f2.c;
                this.d = f2.d;
                this.e = f2.e;
            }
        }

        public Paint a(ColorFilter colorFilter) {
            if (!this.a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.a());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int n2, int n3) {
            this.f.eraseColor(0);
            Canvas canvas = new Canvas(this.f);
            this.b.a(canvas, n2, n3, null);
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            Paint paint = this.a(colorFilter);
            canvas.drawBitmap(this.f, null, rect, paint);
        }

        public boolean a() {
            if (this.b.a() < 255) {
                return true;
            }
            return false;
        }

        public void b(int n2, int n3) {
            if (this.f == null || !this.c(n2, n3)) {
                this.f = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean b() {
            if (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.a()) {
                return true;
            }
            return false;
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.a();
            this.j = this.e;
            this.k = false;
        }

        public boolean c(int n2, int n3) {
            if (n2 == this.f.getWidth() && n3 == this.f.getHeight()) {
                return true;
            }
            return false;
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            return new ao(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new ao((f)this, null);
        }
    }

    static class g
    extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public g(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            ao ao2 = new ao(null);
            ao2.a = (VectorDrawable)this.a.newDrawable();
            return ao2;
        }

        public Drawable newDrawable(Resources resources) {
            ao ao2 = new ao(null);
            ao2.a = (VectorDrawable)this.a.newDrawable(resources);
            return ao2;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            ao ao2 = new ao(null);
            ao2.a = (VectorDrawable)this.a.newDrawable(resources, theme);
            return ao2;
        }
    }

}

