package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import org.json.JSONObject;

/* compiled from: WebDialogParameters */
public class ws {
    public static Bundle a(ShareLinkContent shareLinkContent) {
        Bundle params = ws.a((ShareContent) shareLinkContent);
        vw.a(params, "href", shareLinkContent.h());
        vw.a(params, "quote", shareLinkContent.d());
        return params;
    }

    public static Bundle a(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle params = ws.a((ShareContent) shareOpenGraphContent);
        vw.a(params, "action_type", shareOpenGraphContent.a().a());
        try {
            JSONObject ogJSON = wr.a(wr.a(shareOpenGraphContent), false);
            if (ogJSON != null) {
                vw.a(params, "action_properties", ogJSON.toString());
            }
            return params;
        } catch (Throwable e) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e);
        }
    }

    public static Bundle a(ShareContent shareContent) {
        Bundle params = new Bundle();
        ShareHashtag shareHashtag = shareContent.l();
        if (shareHashtag != null) {
            vw.a(params, "hashtag", shareHashtag.a());
        }
        return params;
    }

    public static Bundle b(ShareLinkContent shareLinkContent) {
        Bundle webParams = new Bundle();
        vw.a(webParams, "name", shareLinkContent.b());
        vw.a(webParams, "description", shareLinkContent.a());
        vw.a(webParams, "link", vw.a(shareLinkContent.h()));
        vw.a(webParams, "picture", vw.a(shareLinkContent.c()));
        vw.a(webParams, "quote", shareLinkContent.d());
        if (shareLinkContent.l() != null) {
            vw.a(webParams, "hashtag", shareLinkContent.l().a());
        }
        return webParams;
    }

    public static Bundle a(ShareFeedContent shareFeedContent) {
        Bundle webParams = new Bundle();
        vw.a(webParams, "to", shareFeedContent.a());
        vw.a(webParams, "link", shareFeedContent.b());
        vw.a(webParams, "picture", shareFeedContent.f());
        vw.a(webParams, "source", shareFeedContent.g());
        vw.a(webParams, "name", shareFeedContent.c());
        vw.a(webParams, "caption", shareFeedContent.d());
        vw.a(webParams, "description", shareFeedContent.e());
        return webParams;
    }
}
