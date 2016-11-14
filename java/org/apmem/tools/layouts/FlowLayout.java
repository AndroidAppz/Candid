package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewDebug.IntToString;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import defpackage.aoy;
import defpackage.aoz$a;
import defpackage.zu;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    List<aoy> a = new ArrayList();
    private final LayoutConfiguration b;

    public static class LayoutParams extends MarginLayoutParams {
        @ExportedProperty(mapping = {@IntToString(from = 0, to = "NONE"), @IntToString(from = 48, to = "TOP"), @IntToString(from = 80, to = "BOTTOM"), @IntToString(from = 3, to = "LEFT"), @IntToString(from = 5, to = "RIGHT"), @IntToString(from = 16, to = "CENTER_VERTICAL"), @IntToString(from = 112, to = "FILL_VERTICAL"), @IntToString(from = 1, to = "CENTER_HORIZONTAL"), @IntToString(from = 7, to = "FILL_HORIZONTAL"), @IntToString(from = 17, to = "CENTER"), @IntToString(from = 119, to = "FILL")})
        private boolean a = false;
        private int b = 0;
        private float c = -1.0f;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            a(context, attributeSet);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean a() {
            return this.b != 0;
        }

        public boolean b() {
            return this.c >= 0.0f;
        }

        private void a(Context context, AttributeSet attributeSet) {
            TypedArray a = context.obtainStyledAttributes(attributeSet, aoz$a.FlowLayout_LayoutParams);
            try {
                this.a = a.getBoolean(aoz$a.FlowLayout_LayoutParams_layout_newLine, false);
                this.b = a.getInt(aoz$a.FlowLayout_LayoutParams_android_layout_gravity, 0);
                this.c = a.getFloat(aoz$a.FlowLayout_LayoutParams_layout_weight, -1.0f);
            } finally {
                a.recycle();
            }
        }

        void a(int x, int y) {
            this.h = x;
            this.i = y;
        }

        int c() {
            return this.d;
        }

        void a(int inlineStartLength) {
            this.d = inlineStartLength;
        }

        public int d() {
            return this.e;
        }

        void b(int length) {
            this.e = length;
        }

        public int e() {
            return this.f;
        }

        void c(int thickness) {
            this.f = thickness;
        }

        int f() {
            return this.g;
        }

        void d(int inlineStartThickness) {
            this.g = inlineStartThickness;
        }

        public int g() {
            if (this.j == 0) {
                return this.leftMargin + this.rightMargin;
            }
            return this.topMargin + this.bottomMargin;
        }

        public int h() {
            if (this.j == 0) {
                return this.topMargin + this.bottomMargin;
            }
            return this.leftMargin + this.rightMargin;
        }

        public int i() {
            return this.b;
        }

        public float j() {
            return this.c;
        }

        public boolean k() {
            return this.a;
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet x0) {
        return a(x0);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams x0) {
        return a(x0);
    }

    public FlowLayout(Context context) {
        super(context);
        this.b = new LayoutConfiguration(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new LayoutConfiguration(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        this.b = new LayoutConfiguration(context, attributeSet);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int controlMaxLength;
        int controlMaxThickness;
        int modeLength;
        int i;
        int sizeWidth = (MeasureSpec.getSize(widthMeasureSpec) - getPaddingRight()) - getPaddingLeft();
        int sizeHeight = (MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom();
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        if (this.b.a() == 0) {
            controlMaxLength = sizeWidth;
        } else {
            controlMaxLength = sizeHeight;
        }
        if (this.b.a() == 0) {
            controlMaxThickness = sizeHeight;
        } else {
            controlMaxThickness = sizeWidth;
        }
        if (this.b.a() == 0) {
            modeLength = modeWidth;
        } else {
            modeLength = modeHeight;
        }
        int modeThickness;
        if (this.b.a() == 0) {
            modeThickness = modeHeight;
        } else {
            modeThickness = modeWidth;
        }
        this.a.clear();
        aoy currentLine = new aoy(controlMaxLength);
        this.a.add(currentLine);
        int count = getChildCount();
        for (i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                child.measure(getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), lp.width), getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), lp.height));
                lp.j = this.b.a();
                if (this.b.a() == 0) {
                    lp.b(child.getMeasuredWidth());
                    lp.c(child.getMeasuredHeight());
                } else {
                    lp.b(child.getMeasuredHeight());
                    lp.c(child.getMeasuredWidth());
                }
                boolean newLine = lp.k() || !(modeLength == 0 || currentLine.b(child));
                if (newLine) {
                    currentLine = new aoy(controlMaxLength);
                    if (this.b.a() == 1 && this.b.e() == 1) {
                        this.a.add(0, currentLine);
                    } else {
                        this.a.add(currentLine);
                    }
                }
                if (this.b.a() == 0 && this.b.e() == 1) {
                    currentLine.a(0, child);
                } else {
                    currentLine.a(child);
                }
            }
        }
        a(this.a);
        int contentLength = 0;
        int linesCount = this.a.size();
        for (i = 0; i < linesCount; i++) {
            contentLength = Math.max(contentLength, ((aoy) this.a.get(i)).c());
        }
        int contentThickness = currentLine.a() + currentLine.b();
        a(this.a, a(modeLength, controlMaxLength, contentLength), a(modeHeight, controlMaxThickness, contentThickness));
        for (i = 0; i < linesCount; i++) {
            aoy line = (aoy) this.a.get(i);
            b(line);
            a(line);
        }
        int totalControlWidth = getPaddingLeft() + getPaddingRight();
        int totalControlHeight = getPaddingBottom() + getPaddingTop();
        if (this.b.a() == 0) {
            totalControlWidth += contentLength;
            totalControlHeight += contentThickness;
        } else {
            totalControlWidth += contentThickness;
            totalControlHeight += contentLength;
        }
        setMeasuredDimension(resolveSize(totalControlWidth, widthMeasureSpec), resolveSize(totalControlHeight, heightMeasureSpec));
    }

    private int a(int modeSize, int controlMaxSize, int contentSize) {
        switch (modeSize) {
            case Integer.MIN_VALUE:
                return Math.min(contentSize, controlMaxSize);
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return contentSize;
            case 1073741824:
                return controlMaxSize;
            default:
                return contentSize;
        }
    }

    private void a(List<aoy> lines) {
        int prevLinesThickness = 0;
        int linesCount = lines.size();
        for (int i = 0; i < linesCount; i++) {
            aoy line = (aoy) lines.get(i);
            line.a(prevLinesThickness);
            prevLinesThickness += line.b();
            int prevChildThickness = 0;
            List<View> childViews = line.e();
            int childCount = childViews.size();
            for (int j = 0; j < childCount; j++) {
                LayoutParams lp = (LayoutParams) ((View) childViews.get(j)).getLayoutParams();
                lp.a(prevChildThickness);
                prevChildThickness += lp.d() + lp.g();
            }
        }
    }

    private void a(aoy line) {
        List<View> childViews = line.e();
        int childCount = childViews.size();
        for (int i = 0; i < childCount; i++) {
            View child = (View) childViews.get(i);
            LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
            if (this.b.a() == 0) {
                layoutParams.a((getPaddingLeft() + line.d()) + layoutParams.c(), (getPaddingTop() + line.a()) + layoutParams.f());
                child.measure(MeasureSpec.makeMeasureSpec(layoutParams.d(), 1073741824), MeasureSpec.makeMeasureSpec(layoutParams.e(), 1073741824));
            } else {
                layoutParams.a((getPaddingLeft() + line.a()) + layoutParams.f(), (getPaddingTop() + line.d()) + layoutParams.c());
                child.measure(MeasureSpec.makeMeasureSpec(layoutParams.e(), 1073741824), MeasureSpec.makeMeasureSpec(layoutParams.d(), 1073741824));
            }
        }
    }

    private void a(List<aoy> lines, int realControlLength, int realControlThickness) {
        int linesCount = lines.size();
        if (linesCount > 0) {
            int totalWeight = linesCount;
            aoy lastLine = (aoy) lines.get(linesCount - 1);
            int excessThickness = realControlThickness - (lastLine.b() + lastLine.a());
            if (excessThickness < 0) {
                excessThickness = 0;
            }
            int excessOffset = 0;
            for (int i = 0; i < linesCount; i++) {
                aoy child = (aoy) lines.get(i);
                int gravity = a(null);
                int extraThickness = Math.round((float) ((excessThickness * 1) / totalWeight));
                int childLength = child.c();
                int childThickness = child.b();
                Rect container = new Rect();
                container.top = excessOffset;
                container.left = 0;
                container.right = realControlLength;
                container.bottom = (childThickness + extraThickness) + excessOffset;
                Rect result = new Rect();
                Gravity.apply(gravity, childLength, childThickness, container, result);
                excessOffset += extraThickness;
                child.b(child.d() + result.left);
                child.a(child.a() + result.top);
                child.d(result.width());
                child.c(result.height());
            }
        }
    }

    private void b(aoy line) {
        List<View> views = line.e();
        int viewCount = views.size();
        if (viewCount > 0) {
            int i;
            float totalWeight = 0.0f;
            for (i = 0; i < viewCount; i++) {
                totalWeight += b((LayoutParams) ((View) views.get(i)).getLayoutParams());
            }
            LayoutParams lastChildLayoutParams = (LayoutParams) ((View) views.get(viewCount - 1)).getLayoutParams();
            int excessLength = line.c() - ((lastChildLayoutParams.d() + lastChildLayoutParams.g()) + lastChildLayoutParams.c());
            int excessOffset = 0;
            for (i = 0; i < viewCount; i++) {
                int extraLength;
                LayoutParams layoutParams = (LayoutParams) ((View) views.get(i)).getLayoutParams();
                float weight = b(layoutParams);
                int gravity = a(layoutParams);
                if (totalWeight == 0.0f) {
                    extraLength = excessLength / viewCount;
                } else {
                    extraLength = Math.round((((float) excessLength) * weight) / totalWeight);
                }
                int childLength = layoutParams.d() + layoutParams.g();
                int childThickness = layoutParams.e() + layoutParams.h();
                Rect container = new Rect();
                container.top = 0;
                container.left = excessOffset;
                container.right = (childLength + extraLength) + excessOffset;
                container.bottom = line.b();
                Rect result = new Rect();
                Gravity.apply(gravity, childLength, childThickness, container, result);
                excessOffset += extraLength;
                layoutParams.a(result.left + layoutParams.c());
                layoutParams.d(result.top);
                layoutParams.b(result.width() - layoutParams.g());
                layoutParams.c(result.height() - layoutParams.h());
            }
        }
    }

    private int a(LayoutParams lp) {
        int childGravity;
        int parentGravity = this.b.d();
        if (lp == null || !lp.a()) {
            childGravity = parentGravity;
        } else {
            childGravity = lp.i();
        }
        childGravity = a(childGravity);
        parentGravity = a(parentGravity);
        if ((childGravity & 7) == 0) {
            childGravity |= parentGravity & 7;
        }
        if ((childGravity & 112) == 0) {
            childGravity |= parentGravity & 112;
        }
        if ((childGravity & 7) == 0) {
            childGravity |= 3;
        }
        if ((childGravity & 112) == 0) {
            return childGravity | 48;
        }
        return childGravity;
    }

    private int a(int childGravity) {
        int i = 3;
        if (this.b.a() == 1 && (childGravity & 8388608) == 0) {
            int horizontalGravity = childGravity;
            childGravity = (0 | (((horizontalGravity & 7) >> 0) << 4)) | (((horizontalGravity & 112) >> 4) << 0);
        }
        if (this.b.e() != 1 || (childGravity & 8388608) == 0) {
            return childGravity;
        }
        int i2;
        int ltrGravity = childGravity;
        if ((ltrGravity & 3) == 3) {
            i2 = 5;
        } else {
            i2 = 0;
        }
        childGravity = 0 | i2;
        if ((ltrGravity & 5) != 5) {
            i = 0;
        }
        return childGravity | i;
    }

    private float b(LayoutParams lp) {
        return lp.b() ? lp.j() : this.b.c();
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            child.layout(lp.h + lp.leftMargin, lp.i + lp.topMargin, (lp.h + lp.leftMargin) + child.getMeasuredWidth(), (lp.i + lp.topMargin) + child.getMeasuredHeight());
        }
    }

    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean more = super.drawChild(canvas, child, drawingTime);
        a(canvas, child);
        return more;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    protected LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams a(android.view.ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    private void a(Canvas canvas, View child) {
        if (b()) {
            float x;
            float y;
            Paint childPaint = b(-256);
            Paint newLinePaint = b(-65536);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (lp.rightMargin > 0) {
                x = (float) child.getRight();
                y = ((float) child.getTop()) + (((float) child.getHeight()) / 2.0f);
                canvas.drawLine(x, y, x + ((float) lp.rightMargin), y, childPaint);
                canvas.drawLine((((float) lp.rightMargin) + x) - 4.0f, y - 4.0f, x + ((float) lp.rightMargin), y, childPaint);
                canvas.drawLine((((float) lp.rightMargin) + x) - 4.0f, y + 4.0f, x + ((float) lp.rightMargin), y, childPaint);
            }
            if (lp.leftMargin > 0) {
                x = (float) child.getLeft();
                y = ((float) child.getTop()) + (((float) child.getHeight()) / 2.0f);
                canvas.drawLine(x, y, x - ((float) lp.leftMargin), y, childPaint);
                canvas.drawLine((x - ((float) lp.leftMargin)) + 4.0f, y - 4.0f, x - ((float) lp.leftMargin), y, childPaint);
                canvas.drawLine((x - ((float) lp.leftMargin)) + 4.0f, y + 4.0f, x - ((float) lp.leftMargin), y, childPaint);
            }
            if (lp.bottomMargin > 0) {
                x = ((float) child.getLeft()) + (((float) child.getWidth()) / 2.0f);
                y = (float) child.getBottom();
                canvas.drawLine(x, y, x, y + ((float) lp.bottomMargin), childPaint);
                canvas.drawLine(x - 4.0f, (((float) lp.bottomMargin) + y) - 4.0f, x, y + ((float) lp.bottomMargin), childPaint);
                canvas.drawLine(x + 4.0f, (((float) lp.bottomMargin) + y) - 4.0f, x, y + ((float) lp.bottomMargin), childPaint);
            }
            if (lp.topMargin > 0) {
                x = ((float) child.getLeft()) + (((float) child.getWidth()) / 2.0f);
                y = (float) child.getTop();
                canvas.drawLine(x, y, x, y - ((float) lp.topMargin), childPaint);
                canvas.drawLine(x - 4.0f, (y - ((float) lp.topMargin)) + 4.0f, x, y - ((float) lp.topMargin), childPaint);
                canvas.drawLine(x + 4.0f, (y - ((float) lp.topMargin)) + 4.0f, x, y - ((float) lp.topMargin), childPaint);
            }
            if (!lp.k()) {
                return;
            }
            if (this.b.a() == 0) {
                x = (float) child.getLeft();
                y = ((float) child.getTop()) + (((float) child.getHeight()) / 2.0f);
                canvas.drawLine(x, y - 6.0f, x, y + 6.0f, newLinePaint);
                return;
            }
            x = ((float) child.getLeft()) + (((float) child.getWidth()) / 2.0f);
            y = (float) child.getTop();
            canvas.drawLine(x - 6.0f, y, x + 6.0f, y, newLinePaint);
        }
    }

    private Paint b(int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    public int getOrientation() {
        return this.b.a();
    }

    public void setOrientation(int orientation) {
        this.b.a(orientation);
        requestLayout();
    }

    public boolean b() {
        return this.b.b() || c();
    }

    public void setDebugDraw(boolean debugDraw) {
        this.b.a(debugDraw);
        invalidate();
    }

    private boolean c() {
        try {
            Method m = ViewGroup.class.getDeclaredMethod("debugDraw", (Class[]) null);
            m.setAccessible(true);
            return ((Boolean) m.invoke(this, new Object[]{null})).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public float getWeightDefault() {
        return this.b.c();
    }

    public void setWeightDefault(float weightDefault) {
        this.b.a(weightDefault);
        requestLayout();
    }

    public int getGravity() {
        return this.b.d();
    }

    public void setGravity(int gravity) {
        this.b.b(gravity);
        requestLayout();
    }

    public int getLayoutDirection() {
        if (this.b == null) {
            return 0;
        }
        return this.b.e();
    }

    public void setLayoutDirection(int layoutDirection) {
        this.b.c(layoutDirection);
        requestLayout();
    }
}
