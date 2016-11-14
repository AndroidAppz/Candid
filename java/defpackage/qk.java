package defpackage;

import android.widget.ImageView;

/* compiled from: GlideDrawableImageViewTarget */
public class qk extends ql<nz> {
    private int a;
    private nz b;

    public /* synthetic */ void onResourceReady(Object x0, qc x1) {
        a((nz) x0, x1);
    }

    protected /* synthetic */ void setResource(Object x0) {
        a((nz) x0);
    }

    public qk(ImageView view) {
        this(view, -1);
    }

    public qk(ImageView view, int maxLoopCount) {
        super(view);
        this.a = maxLoopCount;
    }

    public void a(nz resource, qc<? super nz> animation) {
        if (!resource.a()) {
            float drawableRatio = ((float) resource.getIntrinsicWidth()) / ((float) resource.getIntrinsicHeight());
            if (Math.abs((((float) ((ImageView) this.view).getWidth()) / ((float) ((ImageView) this.view).getHeight())) - 1.0f) <= 0.05f && Math.abs(drawableRatio - 1.0f) <= 0.05f) {
                resource = new qp(resource, ((ImageView) this.view).getWidth());
            }
        }
        super.onResourceReady(resource, animation);
        this.b = resource;
        resource.a(this.a);
        resource.start();
    }

    protected void a(nz resource) {
        ((ImageView) this.view).setImageDrawable(resource);
    }

    public void onStart() {
        if (this.b != null) {
            this.b.start();
        }
    }

    public void onStop() {
        if (this.b != null) {
            this.b.stop();
        }
    }
}
