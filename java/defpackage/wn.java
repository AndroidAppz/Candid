package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeDialogParameters */
public class wn {
    public static Bundle a(UUID callId, ShareContent shareContent, boolean shouldFailOnDataError) {
        vx.a((Object) shareContent, "shareContent");
        vx.a((Object) callId, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return wn.a((ShareLinkContent) shareContent, shouldFailOnDataError);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent photoContent = (SharePhotoContent) shareContent;
            return wn.a(photoContent, wr.a(photoContent, callId), shouldFailOnDataError);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent videoContent = (ShareVideoContent) shareContent;
            return wn.a(videoContent, wr.a(videoContent, callId), shouldFailOnDataError);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent openGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return wn.a(openGraphContent, wr.a(wr.a(callId, openGraphContent), false), shouldFailOnDataError);
            } catch (JSONException e) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
            }
        } else if (!(shareContent instanceof ShareMediaContent)) {
            return null;
        } else {
            ShareMediaContent mediaContent = (ShareMediaContent) shareContent;
            return wn.a(mediaContent, wr.a(mediaContent, callId), shouldFailOnDataError);
        }
    }

    private static Bundle a(ShareLinkContent linkContent, boolean dataErrorsFatal) {
        Bundle params = wn.a((ShareContent) linkContent, dataErrorsFatal);
        vw.a(params, "TITLE", linkContent.b());
        vw.a(params, "DESCRIPTION", linkContent.a());
        vw.a(params, "IMAGE", linkContent.c());
        vw.a(params, "QUOTE", linkContent.d());
        return params;
    }

    private static Bundle a(SharePhotoContent photoContent, List<String> imageUrls, boolean dataErrorsFatal) {
        Bundle params = wn.a((ShareContent) photoContent, dataErrorsFatal);
        params.putStringArrayList("PHOTOS", new ArrayList(imageUrls));
        return params;
    }

    private static Bundle a(ShareVideoContent videoContent, String videoUrl, boolean dataErrorsFatal) {
        Bundle params = wn.a((ShareContent) videoContent, dataErrorsFatal);
        vw.a(params, "TITLE", videoContent.b());
        vw.a(params, "DESCRIPTION", videoContent.a());
        vw.a(params, "VIDEO", videoUrl);
        return params;
    }

    private static Bundle a(ShareMediaContent mediaContent, List<Bundle> mediaInfos, boolean dataErrorsFatal) {
        Bundle params = wn.a((ShareContent) mediaContent, dataErrorsFatal);
        params.putParcelableArrayList("MEDIA", new ArrayList(mediaInfos));
        return params;
    }

    private static Bundle a(ShareOpenGraphContent openGraphContent, JSONObject openGraphActionJSON, boolean dataErrorsFatal) {
        Bundle params = wn.a((ShareContent) openGraphContent, dataErrorsFatal);
        vw.a(params, "PREVIEW_PROPERTY_NAME", wr.a(openGraphContent.b()).second);
        vw.a(params, "ACTION_TYPE", openGraphContent.a().a());
        vw.a(params, "ACTION", openGraphActionJSON.toString());
        return params;
    }

    private static Bundle a(ShareContent content, boolean dataErrorsFatal) {
        Bundle params = new Bundle();
        vw.a(params, "LINK", content.h());
        vw.a(params, "PLACE", content.j());
        vw.a(params, "REF", content.k());
        params.putBoolean("DATA_FAILURES_FATAL", dataErrorsFatal);
        Collection peopleIds = content.i();
        if (!vw.a(peopleIds)) {
            params.putStringArrayList("FRIENDS", new ArrayList(peopleIds));
        }
        ShareHashtag shareHashtag = content.l();
        if (shareHashtag != null) {
            vw.a(params, "HASHTAG", shareHashtag.a());
        }
        return params;
    }
}
