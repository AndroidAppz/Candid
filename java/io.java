/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  java.lang.Object
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public abstract class io
implements RecyclerView.OnItemTouchListener {
    GestureDetector b;

    public io(Context context) {
        this.b = new GestureDetector(context, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(){

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View view = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (view != null && this.b.onTouchEvent(motionEvent)) {
            this.onItemClick(view, recyclerView.getChildAdapterPosition(view));
        }
        return false;
    }

    public abstract void onItemClick(View var1, int var2);

    public void onRequestDisallowInterceptTouchEvent(boolean bl2) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

}

