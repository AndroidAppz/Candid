package com.becandid.candid.views;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

public class AlwaysOnAutoCompleteView extends AppCompatAutoCompleteTextView {
    public AlwaysOnAutoCompleteView(Context context) {
        super(context);
    }

    public AlwaysOnAutoCompleteView(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
    }

    public AlwaysOnAutoCompleteView(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
    }

    public boolean enoughToFilter() {
        return true;
    }

    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused && getAdapter() != null) {
            performFiltering(getText(), 0);
        }
    }

    public void performCompletion() {
        if (isPopupShowing()) {
            ArrayAdapter<?> adapter = (ArrayAdapter) getAdapter();
            getOnItemClickListener().onItemClick(null, null, 0, 0);
        }
    }
}
