package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class ImagePostViewHolder$$ViewBinder<T extends ImagePostViewHolder> extends BasePostViewHolder$$ViewBinder<T> {

    /* compiled from: ImagePostViewHolder$$ViewBinder */
    public static class a<T extends ImagePostViewHolder> extends com.becandid.candid.views.viewholders.BasePostViewHolder$.ViewBinder.a<T> {
        protected a(T target) {
            super(target);
        }

        protected void a(T target) {
            super.a(target);
            target.mPostCaption = null;
            target.mPostImage = null;
            target.mPostImageRow = null;
            target.mPostImageImage = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (ImagePostViewHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = (a) super.a(finder, target, source);
        target.mPostCaption = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624115, "field 'mPostCaption'"), 2131624115, "field 'mPostCaption'");
        target.mPostImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624373, "field 'mPostImage'"), 2131624373, "field 'mPostImage'");
        target.mPostImageRow = (View) finder.findRequiredView(source, 2131624372, "field 'mPostImageRow'");
        target.mPostImageImage = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624378, "field 'mPostImageImage'"), 2131624378, "field 'mPostImageImage'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
