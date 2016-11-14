package com.becandid.candid.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import defpackage.je;

public abstract class BlurLayout extends RelativeLayout {
    protected String a;
    @BindView(2131624073)
    View mBackgroundContainer;
    @BindView(2131624080)
    ImageView mBlurImage;

    public BlurLayout(Context context) {
        super(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    protected void a() {
        if (!TextUtils.isEmpty(this.a)) {
            this.mBackgroundContainer.setVisibility(0);
            Bitmap background = je.a(this.a);
            if (background != null) {
                this.mBlurImage.setImageBitmap(background);
                this.mBlurImage.setAlpha(0.075f);
            }
        }
    }

    private void b() {
        if (!TextUtils.isEmpty(this.a)) {
            new AsyncTask<Void, Void, Void>(this) {
                final /* synthetic */ BlurLayout a;

                {
                    this.a = this$0;
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return a((Void[]) objArr);
                }

                protected Void a(Void... params) {
                    je.b(this.a.a);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }
}
