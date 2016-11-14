package defpackage;

import com.facebook.FacebookException;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;

/* compiled from: ShareContentValidation */
class wq$b extends wq$a {
    private wq$b() {
        super(null);
    }

    public void a(SharePhotoContent photoContent) {
        throw new FacebookException("Cannot share SharePhotoContent via web sharing dialogs");
    }

    public void a(ShareVideoContent videoContent) {
        throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
    }

    public void a(ShareMediaContent mediaContent) {
        throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
    }

    public void a(SharePhoto photo) {
        wq.e(photo, this);
    }
}
