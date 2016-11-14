package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class TextPostViewHolder$$ViewBinder<T extends TextPostViewHolder> extends BasePostViewHolder$$ViewBinder<T> {

    /* compiled from: TextPostViewHolder$$ViewBinder */
    public static class a<T extends TextPostViewHolder> extends com.becandid.candid.views.viewholders.BasePostViewHolder$.ViewBinder.a<T> {
        protected a(T target) {
            super(target);
        }

        protected void a(T target) {
            super.a(target);
            target.mPostCaption = null;
            target.mPostTextRow = null;
            target.mPostCaptionPlaceholder = null;
            target.mPostShareImage = null;
            target.mPostImageGroup = null;
            target.mPostImageCaption = null;
        }
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object obj, Object obj2) {
        return a(finder, (TextPostViewHolder) obj, obj2);
    }

    public Unbinder a(Finder finder, T target, Object source) {
        a unbinder = (a) super.a(finder, target, source);
        target.mPostCaption = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624115, "field 'mPostCaption'"), 2131624115, "field 'mPostCaption'");
        target.mPostTextRow = (View) finder.findRequiredView(source, 2131624385, "field 'mPostTextRow'");
        target.mPostCaptionPlaceholder = (LinearLayout) finder.castView((View) finder.findRequiredView(source, 2131624386, "field 'mPostCaptionPlaceholder'"), 2131624386, "field 'mPostCaptionPlaceholder'");
        target.mPostShareImage = (View) finder.findRequiredView(source, 2131624374, "field 'mPostShareImage'");
        target.mPostImageGroup = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624731, "field 'mPostImageGroup'"), 2131624731, "field 'mPostImageGroup'");
        target.mPostImageCaption = (TextView) finder.castView((View) finder.findRequiredView(source, 2131624377, "field 'mPostImageCaption'"), 2131624377, "field 'mPostImageCaption'");
        return unbinder;
    }

    protected a<T> a(T target) {
        return new a(target);
    }
}
