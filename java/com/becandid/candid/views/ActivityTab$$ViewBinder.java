package com.becandid.candid.views;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;

public class ActivityTab$$ViewBinder<T extends ActivityTab> implements ViewBinder<T> {

    /* compiled from: ActivityTab$$ViewBinder */
    public static class a<T extends ActivityTab> implements Unbinder {
        private T a;

        protected a(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            a(this.a);
            this.a = null;
        }

        protected void a(T target) {
            target.mSwipeRefresh = null;
            target.mRecyclerView = null;
            target.mEmptyView = null;
            target.mSettingView = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (ActivityTab) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = a(target);
        target.mSwipeRefresh = (SwipeRefreshLayout) finder.castView((View) finder.findRequiredView(source, 2131624278, "field 'mSwipeRefresh'"), 2131624278, "field 'mSwipeRefresh'");
        target.mRecyclerView = (RecyclerView) finder.castView((View) finder.findRequiredView(source, 2131624279, "field 'mRecyclerView'"), 2131624279, "field 'mRecyclerView'");
        target.mEmptyView = (View) finder.findRequiredView(source, 2131624280, "field 'mEmptyView'");
        target.mSettingView = (View) finder.findRequiredView(source, 2131624277, "field 'mSettingView'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
