package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.internal.LikeDialogFeature;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LikeDialog */
public class wl extends vd<LikeContent, wl$b> {
    private static final int b = RequestCodeOffset.Like.a();

    public static boolean e() {
        return vc.a(wl.h());
    }

    public static boolean f() {
        return vc.b(wl.h());
    }

    public wl(Activity activity) {
        super(activity, b);
    }

    public wl(vi fragmentWrapper) {
        super(fragmentWrapper, b);
    }

    protected ux d() {
        return new ux(a());
    }

    protected List<vd$a> c() {
        ArrayList<vd$a> handlers = new ArrayList();
        handlers.add(new wl$a(this, null));
        handlers.add(new wl$c());
        return handlers;
    }

    protected void a(CallbackManagerImpl callbackManager, uc<wl$b> callback) {
        callbackManager.b(a(), new wl$2(this, callback == null ? null : new wl$1(this, callback, callback)));
    }

    private static vb h() {
        return LikeDialogFeature.LIKE_DIALOG;
    }

    private static Bundle b(LikeContent likeContent) {
        Bundle params = new Bundle();
        params.putString("object_id", likeContent.a());
        params.putString("object_type", likeContent.b());
        return params;
    }
}
