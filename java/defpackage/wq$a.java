package defpackage;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;

/* compiled from: ShareContentValidation */
class wq$a {
    private boolean a;

    private wq$a() {
        this.a = false;
    }

    public void a(ShareLinkContent linkContent) {
        wq.b(linkContent, this);
    }

    public void a(SharePhotoContent photoContent) {
        wq.b(photoContent, this);
    }

    public void a(ShareVideoContent videoContent) {
        wq.b(videoContent, this);
    }

    public void a(ShareMediaContent mediaContent) {
        wq.b(mediaContent, this);
    }

    public void a(ShareOpenGraphContent openGraphContent) {
        this.a = true;
        wq.b(openGraphContent, this);
    }

    public void a(ShareOpenGraphAction openGraphAction) {
        wq.b(openGraphAction, this);
    }

    public void a(ShareOpenGraphObject openGraphObject) {
        wq.b(openGraphObject, this);
    }

    public void a(ShareOpenGraphValueContainer openGraphValueContainer, boolean requireNamespace) {
        wq.b(openGraphValueContainer, this, requireNamespace);
    }

    public void a(SharePhoto photo) {
        wq.d(photo, this);
    }

    public void a(ShareVideo video) {
        wq.b(video, this);
    }

    public void a(ShareMedia medium) {
        wq.a(medium, this);
    }

    public boolean a() {
        return this.a;
    }
}
