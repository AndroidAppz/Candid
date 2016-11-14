package defpackage;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.OpenGraphMessageDialogFeature;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageDialog */
public final class wt extends vd<ShareContent, wi$a> implements wi {
    private static final int b = RequestCodeOffset.Message.a();
    private boolean c;

    public static boolean a(Class<? extends ShareContent> contentType) {
        vb feature = wt.c(contentType);
        return feature != null && vc.a(feature);
    }

    public wt(Activity activity, int requestCode) {
        super(activity, requestCode);
        this.c = false;
        wr.a(requestCode);
    }

    public wt(Fragment fragment, int requestCode) {
        this(new vi(fragment), requestCode);
    }

    public wt(android.app.Fragment fragment, int requestCode) {
        this(new vi(fragment), requestCode);
    }

    private wt(vi fragmentWrapper, int requestCode) {
        super(fragmentWrapper, requestCode);
        this.c = false;
        wr.a(requestCode);
    }

    protected void a(CallbackManagerImpl callbackManager, uc<wi$a> callback) {
        wr.a(a(), (ub) callbackManager, (uc) callback);
    }

    public boolean e() {
        return this.c;
    }

    protected ux d() {
        return new ux(a());
    }

    protected List<vd$a> c() {
        ArrayList<vd$a> handlers = new ArrayList();
        handlers.add(new wt$a(this, null));
        return handlers;
    }

    private static vb c(Class<? extends ShareContent> contentType) {
        if (ShareLinkContent.class.isAssignableFrom(contentType)) {
            return MessageDialogFeature.MESSAGE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(contentType)) {
            return MessageDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(contentType)) {
            return MessageDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(contentType)) {
            return OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG;
        }
        return null;
    }
}
