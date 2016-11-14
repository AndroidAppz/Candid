package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;

/* compiled from: DeviceShareDialog */
public class wh extends vd<ShareContent, wh$a> {
    private static final int b = RequestCodeOffset.DeviceShare.a();

    public wh(Activity activity) {
        super(activity, b);
    }

    public wh(Fragment fragment) {
        super(new vi(fragment), b);
    }

    public wh(android.support.v4.app.Fragment fragment) {
        super(new vi(fragment), b);
    }

    protected boolean a(ShareContent content, Object mode) {
        return (content instanceof ShareLinkContent) || (content instanceof ShareOpenGraphContent);
    }

    protected void b(ShareContent content, Object mode) {
        if (content == null) {
            throw new FacebookException("Must provide non-null content to share");
        } else if ((content instanceof ShareLinkContent) || (content instanceof ShareOpenGraphContent)) {
            Intent intent = new Intent();
            intent.setClass(ud.f(), FacebookActivity.class);
            intent.setAction("DeviceShareDialogFragment");
            intent.putExtra("content", content);
            a(intent, a());
        } else {
            throw new FacebookException(getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
        }
    }

    protected List<vd$a> c() {
        return null;
    }

    protected ux d() {
        return null;
    }

    protected void a(CallbackManagerImpl callbackManager, uc<wh$a> callback) {
        callbackManager.b(a(), new wh$1(this, callback));
    }
}
