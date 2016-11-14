package com.becandid.candid.activities;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.thirdparty.nocropper.CropperView;
import defpackage.um$d;

public class ImageCropActivity$$ViewBinder<T extends ImageCropActivity> implements ViewBinder<T> {

    /* compiled from: ImageCropActivity$$ViewBinder */
    public static class InnerUnbinder<T extends ImageCropActivity> implements Unbinder {
        private T a;

        protected InnerUnbinder(T target) {
            this.a = target;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            unbind(this.a);
            this.a = null;
        }

        protected void unbind(T target) {
            target.mImageView = null;
            target.mCropButton = null;
            target.mProgressBar = null;
            target.mCropContainer = null;
            target.mCropperFrameLayout = null;
        }
    }

    public Unbinder bind(Finder finder, T target, Object source) {
        InnerUnbinder unbinder = createUnbinder(target);
        target.mImageView = (CropperView) finder.castView((View) finder.findRequiredView(source, 2131624183, "field 'mImageView'"), 2131624183, "field 'mImageView'");
        target.mCropButton = (ImageView) finder.castView((View) finder.findRequiredView(source, 2131624184, "field 'mCropButton'"), 2131624184, "field 'mCropButton'");
        target.mProgressBar = (ProgressBar) finder.castView((View) finder.findRequiredView(source, um$d.progress_bar, "field 'mProgressBar'"), um$d.progress_bar, "field 'mProgressBar'");
        target.mCropContainer = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, 2131624181, "field 'mCropContainer'"), 2131624181, "field 'mCropContainer'");
        target.mCropperFrameLayout = (FrameLayout) finder.castView((View) finder.findRequiredView(source, 2131624182, "field 'mCropperFrameLayout'"), 2131624182, "field 'mCropperFrameLayout'");
        return unbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T target) {
        return new InnerUnbinder(target);
    }
}
