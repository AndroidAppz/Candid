package com.becandid.candid.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class ResizableImageView extends ImageView {
    public ResizableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = getDrawable();
        if (d != null) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            setMeasuredDimension(width, (int) Math.ceil((double) ((((float) width) * ((float) d.getIntrinsicHeight())) / ((float) d.getIntrinsicWidth()))));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
