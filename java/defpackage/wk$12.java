package defpackage;

/* compiled from: LikeActionController */
class wk$12 implements wk$m {
    final /* synthetic */ wk a;

    wk$12(wk this$0) {
        this.a = this$0;
    }

    public void a() {
        wk$i likeRequestWrapper;
        switch (wk$4.a[this.a.l.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                likeRequestWrapper = new wk$h(this.a, this.a.s);
                break;
            default:
                likeRequestWrapper = new wk$f(this.a, this.a.s, this.a.l);
                break;
        }
        wk$d engagementRequest = new wk$d(this.a, this.a.s, this.a.l);
        uf requestBatch = new uf();
        likeRequestWrapper.a(requestBatch);
        engagementRequest.a(requestBatch);
        requestBatch.a(new wk$12$1(this, likeRequestWrapper, engagementRequest));
        requestBatch.h();
    }
}
