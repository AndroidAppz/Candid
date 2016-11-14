package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LegacyNativeDialogParameters */
public class wj {
    public static Bundle a(UUID callId, ShareContent shareContent, boolean shouldFailOnDataError) {
        vx.a((Object) shareContent, "shareContent");
        vx.a((Object) callId, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return wj.a((ShareLinkContent) shareContent, shouldFailOnDataError);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent photoContent = (SharePhotoContent) shareContent;
            return wj.a(photoContent, wr.a(photoContent, callId), shouldFailOnDataError);
        } else if (shareContent instanceof ShareVideoContent) {
            return wj.a((ShareVideoContent) shareContent, shouldFailOnDataError);
        } else {
            if (!(shareContent instanceof ShareOpenGraphContent)) {
                return null;
            }
            ShareOpenGraphContent openGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return wj.a(openGraphContent, wr.a(callId, openGraphContent), shouldFailOnDataError);
            } catch (JSONException e) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
            }
        }
    }

    private static Bundle a(ShareLinkContent linkContent, boolean dataErrorsFatal) {
        Bundle params = wj.a((ShareContent) linkContent, dataErrorsFatal);
        vw.a(params, "com.facebook.platform.extra.TITLE", linkContent.b());
        vw.a(params, "com.facebook.platform.extra.DESCRIPTION", linkContent.a());
        vw.a(params, "com.facebook.platform.extra.IMAGE", linkContent.c());
        return params;
    }

    private static Bundle a(SharePhotoContent photoContent, List<String> imageUrls, boolean dataErrorsFatal) {
        Bundle params = wj.a((ShareContent) photoContent, dataErrorsFatal);
        params.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(imageUrls));
        return params;
    }

    private static Bundle a(ShareVideoContent videoContent, boolean dataErrorsFatal) {
        return null;
    }

    private static Bundle a(ShareOpenGraphContent openGraphContent, JSONObject openGraphActionJSON, boolean dataErrorsFatal) {
        Bundle params = wj.a((ShareContent) openGraphContent, dataErrorsFatal);
        vw.a(params, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", openGraphContent.b());
        vw.a(params, "com.facebook.platform.extra.ACTION_TYPE", openGraphContent.a().a());
        vw.a(params, "com.facebook.platform.extra.ACTION", openGraphActionJSON.toString());
        return params;
    }

    private static Bundle a(ShareContent content, boolean dataErrorsFatal) {
        Bundle params = new Bundle();
        vw.a(params, "com.facebook.platform.extra.LINK", content.h());
        vw.a(params, "com.facebook.platform.extra.PLACE", content.j());
        vw.a(params, "com.facebook.platform.extra.REF", content.k());
        params.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", dataErrorsFatal);
        Collection peopleIds = content.i();
        if (!vw.a(peopleIds)) {
            params.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(peopleIds));
        }
        return params;
    }
}
