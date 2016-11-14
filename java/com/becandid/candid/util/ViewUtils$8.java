package com.becandid.candid.util;

import android.text.TextPaint;
import android.text.style.StyleSpan;

public class ViewUtils$8 extends StyleSpan {
    public ViewUtils$8(int x0) {
        super(x0);
    }

    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(true);
    }
}
