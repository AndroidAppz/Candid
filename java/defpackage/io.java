package defpackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: RecyclerItemClickListener */
public abstract class io implements OnItemTouchListener {
    GestureDetector b;

    public abstract void onItemClick(View view, int i);

    public io(Context context) {
        this.b = new GestureDetector(context, new io$1(this));
    }

    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && this.b.onTouchEvent(e)) {
            onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }

    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
