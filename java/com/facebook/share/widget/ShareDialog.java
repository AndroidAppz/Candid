package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import defpackage.ub;
import defpackage.uc;
import defpackage.um$h;
import defpackage.ux;
import defpackage.vb;
import defpackage.vc;
import defpackage.vc$a;
import defpackage.vd;
import defpackage.vd$a;
import defpackage.vi;
import defpackage.vw;
import defpackage.wi;
import defpackage.wi$a;
import defpackage.wj;
import defpackage.wn;
import defpackage.wq;
import defpackage.wr;
import defpackage.ws;
import java.util.ArrayList;
import java.util.List;

public final class ShareDialog extends vd<ShareContent, wi$a> implements wi {
    private static final int b = RequestCodeOffset.Share.a();
    private boolean c;
    private boolean d;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Mode.values().length];

        static {
            try {
                a[Mode.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Mode.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Mode.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    class a extends vd$a {
        final /* synthetic */ ShareDialog b;

        private a(ShareDialog shareDialog) {
            this.b = shareDialog;
            super(shareDialog);
        }

        public Object a() {
            return Mode.FEED;
        }

        public boolean a(ShareContent content, boolean isBestEffort) {
            return (content instanceof ShareLinkContent) || (content instanceof ShareFeedContent);
        }

        public ux a(ShareContent content) {
            Bundle params;
            this.b.a(this.b.b(), content, Mode.FEED);
            ux appCall = this.b.d();
            if (content instanceof ShareLinkContent) {
                ShareLinkContent linkContent = (ShareLinkContent) content;
                wq.c(linkContent);
                params = ws.b(linkContent);
            } else {
                params = ws.a((ShareFeedContent) content);
            }
            vc.a(appCall, "feed", params);
            return appCall;
        }
    }

    class b extends vd$a {
        final /* synthetic */ ShareDialog b;

        private b(ShareDialog shareDialog) {
            this.b = shareDialog;
            super(shareDialog);
        }

        public Object a() {
            return Mode.NATIVE;
        }

        public boolean a(ShareContent content, boolean isBestEffort) {
            if (content == null) {
                return false;
            }
            boolean canShowResult = true;
            if (!isBestEffort) {
                if (content.l() != null) {
                    canShowResult = vc.a(ShareDialogFeature.HASHTAG);
                }
                if ((content instanceof ShareLinkContent) && !vw.a(((ShareLinkContent) content).d())) {
                    canShowResult &= vc.a(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            }
            boolean z = canShowResult && ShareDialog.e(content.getClass());
            return z;
        }

        public ux a(final ShareContent content) {
            this.b.a(this.b.b(), content, Mode.NATIVE);
            wq.b(content);
            final ux appCall = this.b.d();
            final boolean shouldFailOnDataError = this.b.e();
            vc.a(appCall, new vc$a(this) {
                final /* synthetic */ b d;

                public Bundle a() {
                    return wn.a(appCall.c(), content, shouldFailOnDataError);
                }

                public Bundle b() {
                    return wj.a(appCall.c(), content, shouldFailOnDataError);
                }
            }, ShareDialog.g(content.getClass()));
            return appCall;
        }
    }

    class c extends vd$a {
        final /* synthetic */ ShareDialog b;

        private c(ShareDialog shareDialog) {
            this.b = shareDialog;
            super(shareDialog);
        }

        public Object a() {
            return Mode.WEB;
        }

        public boolean a(ShareContent content, boolean isBestEffort) {
            return content != null && ShareDialog.f(content.getClass());
        }

        public ux a(ShareContent content) {
            Bundle params;
            this.b.a(this.b.b(), content, Mode.WEB);
            ux appCall = this.b.d();
            wq.c(content);
            if (content instanceof ShareLinkContent) {
                params = ws.a((ShareLinkContent) content);
            } else {
                params = ws.a((ShareOpenGraphContent) content);
            }
            vc.a(appCall, b(content), params);
            return appCall;
        }

        private String b(ShareContent shareContent) {
            if (shareContent instanceof ShareLinkContent) {
                return "share";
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return "share_open_graph";
            }
            return null;
        }
    }

    public static boolean a(Class<? extends ShareContent> contentType) {
        return f(contentType) || e(contentType);
    }

    private static boolean e(Class<? extends ShareContent> contentType) {
        vb feature = g(contentType);
        return feature != null && vc.a(feature);
    }

    private static boolean f(Class<? extends ShareContent> contentType) {
        return ShareLinkContent.class.isAssignableFrom(contentType) || ShareOpenGraphContent.class.isAssignableFrom(contentType);
    }

    public ShareDialog(Activity activity) {
        super(activity, b);
        this.c = false;
        this.d = true;
        wr.a(b);
    }

    ShareDialog(Activity activity, int requestCode) {
        super(activity, requestCode);
        this.c = false;
        this.d = true;
        wr.a(requestCode);
    }

    ShareDialog(Fragment fragment, int requestCode) {
        this(new vi(fragment), requestCode);
    }

    ShareDialog(android.app.Fragment fragment, int requestCode) {
        this(new vi(fragment), requestCode);
    }

    private ShareDialog(vi fragmentWrapper, int requestCode) {
        super(fragmentWrapper, requestCode);
        this.c = false;
        this.d = true;
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
        handlers.add(new b());
        handlers.add(new a());
        handlers.add(new c());
        return handlers;
    }

    private static vb g(Class<? extends ShareContent> contentType) {
        if (ShareLinkContent.class.isAssignableFrom(contentType)) {
            return ShareDialogFeature.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(contentType)) {
            return ShareDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(contentType)) {
            return ShareDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(contentType)) {
            return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(contentType)) {
            return ShareDialogFeature.MULTIMEDIA;
        }
        return null;
    }

    private void a(Context context, ShareContent content, Mode mode) {
        String displayType;
        String contentType;
        if (this.d) {
            mode = Mode.AUTOMATIC;
        }
        switch (AnonymousClass1.a[mode.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                displayType = "automatic";
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                displayType = "web";
                break;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                displayType = "native";
                break;
            default:
                displayType = "unknown";
                break;
        }
        vb dialogFeature = g(content.getClass());
        if (dialogFeature == ShareDialogFeature.SHARE_DIALOG) {
            contentType = "status";
        } else if (dialogFeature == ShareDialogFeature.PHOTOS) {
            contentType = "photo";
        } else if (dialogFeature == ShareDialogFeature.VIDEO) {
            contentType = "video";
        } else if (dialogFeature == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            contentType = "open_graph";
        } else {
            contentType = "unknown";
        }
        AppEventsLogger logger = AppEventsLogger.a(context);
        Bundle parameters = new Bundle();
        parameters.putString("fb_share_dialog_show", displayType);
        parameters.putString("fb_share_dialog_content_type", contentType);
        logger.a("fb_share_dialog_show", null, parameters);
    }
}
