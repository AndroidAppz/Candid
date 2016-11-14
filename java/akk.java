/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  java.lang.Object
 */
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.venmo.view.TooltipView;

public class akk
implements akj {
    @Override
    public void a(TooltipView tooltipView, Canvas canvas) {
        tooltipView.setTooltipPath(new Path());
        RectF rectF = new RectF(canvas.getClipBounds());
        rectF.bottom -= (float)tooltipView.getArrowHeight();
        tooltipView.getTooltipPath().addRoundRect(rectF, (float)tooltipView.getCornerRadius(), (float)tooltipView.getCornerRadius(), Path.Direction.CW);
        float f2 = aki.a(tooltipView, rectF);
        tooltipView.getTooltipPath().moveTo(f2, (float)tooltipView.getHeight());
        int n2 = tooltipView.getArrowWidth() / 2;
        tooltipView.getTooltipPath().lineTo(f2 - (float)n2, rectF.bottom);
        tooltipView.getTooltipPath().lineTo(f2 + (float)n2, rectF.bottom);
        tooltipView.getTooltipPath().close();
        tooltipView.setPaint(new Paint(1));
        tooltipView.getTooltipPaint().setColor(tooltipView.getTooltipColor());
    }
}

