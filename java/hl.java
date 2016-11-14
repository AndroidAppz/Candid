/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.support.v7.widget.StaggeredGridLayoutManager
 *  java.lang.Math
 *  java.lang.String
 */
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public abstract class hl
extends RecyclerView.OnScrollListener {
    public static final int BACKWARDS = 1;
    public static final int FORWARD;
    private int a;
    private int b;
    private boolean c;
    private int d;
    private LinearLayoutManager e;
    private StaggeredGridLayoutManager f;
    private hd g;

    public hl(LinearLayoutManager linearLayoutManager, hd hd2) {
        this.a = 10;
        this.b = 0;
        this.c = true;
        this.d = 0;
        this.g = hd2;
        this.e = linearLayoutManager;
    }

    public hl(LinearLayoutManager linearLayoutManager, hd hd2, int n2) {
        this.a = 10;
        this.b = 0;
        this.c = true;
        this.d = 0;
        this.g = hd2;
        this.e = linearLayoutManager;
        this.d = n2;
    }

    public hl(LinearLayoutManager linearLayoutManager, hd hd2, int n2, int n3) {
        this.a = 10;
        this.b = 0;
        this.c = true;
        this.d = 0;
        this.g = hd2;
        this.e = linearLayoutManager;
        this.d = n2;
        this.a = n3;
    }

    public hl(StaggeredGridLayoutManager staggeredGridLayoutManager, hd hd2) {
        this.a = 10;
        this.b = 0;
        this.c = true;
        this.d = 0;
        this.g = hd2;
        this.f = staggeredGridLayoutManager;
    }

    public abstract void onLoadMore(String var1);

    /*
     * Enabled aggressive block sorting
     */
    public void onScrolled(RecyclerView recyclerView, int n2, int n3) {
        int n4 = recyclerView.getChildCount();
        int n5 = this.e != null ? this.e.getItemCount() : this.f.getItemCount();
        if (n5 < this.b) {
            this.b = 0;
            if (n5 == 0) {
                this.c = true;
            }
        }
        if (this.c && n5 > this.b) {
            this.c = false;
            this.b = n5;
        }
        if (this.e != null) {
            int n6 = this.e.findFirstVisibleItemPosition();
            switch (this.d) {
                case 0: {
                    if (this.c || n5 - n4 > n6 + this.a) return;
                    {
                        this.onLoadMore(this.g.a());
                        this.c = true;
                        return;
                    }
                }
                default: {
                    return;
                }
                case 1: 
            }
            if (this.c || n6 - this.a > 2) return;
            {
                this.onLoadMore(this.g.a());
                this.c = true;
                return;
            }
        }
        int[] arrn = this.f.findFirstVisibleItemPositions(null);
        int n7 = Math.min((int)arrn[0], (int)arrn[1]);
        if (this.c || n5 - n4 > n7 + this.a) return;
        {
            this.onLoadMore(this.g.a());
            this.c = true;
            return;
        }
    }
}

