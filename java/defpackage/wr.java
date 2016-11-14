package defpackage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView.ObjectType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareInternalUtility */
public final class wr {
    public static String a(Bundle result) {
        if (result.containsKey("completionGesture")) {
            return result.getString("completionGesture");
        }
        return result.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
    }

    public static String b(Bundle result) {
        if (result.containsKey("postId")) {
            return result.getString("postId");
        }
        if (result.containsKey("com.facebook.platform.extra.POST_ID")) {
            return result.getString("com.facebook.platform.extra.POST_ID");
        }
        return result.getString("post_id");
    }

    public static boolean a(int requestCode, int resultCode, Intent data, wp resultProcessor) {
        ux appCall = wr.a(requestCode, resultCode, data);
        if (appCall == null) {
            return false;
        }
        vq.a(appCall.c());
        if (resultProcessor == null) {
            return true;
        }
        FacebookException exception = vr.a(vr.g(data));
        if (exception == null) {
            resultProcessor.a(appCall, vr.e(data));
            return true;
        } else if (exception instanceof FacebookOperationCanceledException) {
            resultProcessor.a(appCall);
            return true;
        } else {
            resultProcessor.a(appCall, exception);
            return true;
        }
    }

    public static wp a(uc<wi$a> callback) {
        return new wr$1(callback, callback);
    }

    private static ux a(int requestCode, int resultCode, Intent data) {
        UUID callId = vr.b(data);
        if (callId == null) {
            return null;
        }
        return ux.a(callId, requestCode);
    }

    public static void a(int requestCode) {
        CallbackManagerImpl.a(requestCode, new wr$2(requestCode));
    }

    public static void a(int requestCode, ub callbackManager, uc<wi$a> callback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).b(requestCode, new wr$3(requestCode, callback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public static List<String> a(SharePhotoContent photoContent, UUID appCallId) {
        if (photoContent != null) {
            List photos = photoContent.a();
            if (photos != null) {
                Collection attachments = vw.a(photos, new wr$4(appCallId));
                List<String> attachmentUrls = vw.a((List) attachments, new wr$5());
                vq.a(attachments);
                return attachmentUrls;
            }
        }
        return null;
    }

    public static String a(ShareVideoContent videoContent, UUID appCallId) {
        if (videoContent == null || videoContent.d() == null) {
            return null;
        }
        vq$a attachment = vq.a(appCallId, videoContent.d().c());
        Collection attachments = new ArrayList(1);
        attachments.add(attachment);
        vq.a(attachments);
        return attachment.a();
    }

    public static List<Bundle> a(ShareMediaContent mediaContent, UUID appCallId) {
        if (mediaContent != null) {
            List media = mediaContent.a();
            if (media != null) {
                Collection attachments = new ArrayList();
                List<Bundle> mediaInfos = vw.a(media, new wr$6(appCallId, attachments));
                vq.a(attachments);
                return mediaInfos;
            }
        }
        return null;
    }

    public static JSONObject a(UUID callId, ShareOpenGraphContent content) throws JSONException {
        ShareOpenGraphAction action = content.a();
        Collection attachments = new ArrayList();
        JSONObject actionJSON = wo.a(action, new wr$7(callId, attachments));
        vq.a(attachments);
        if (content.j() != null && vw.a(actionJSON.optString("place"))) {
            actionJSON.put("place", content.j());
        }
        if (content.i() != null) {
            Set<String> peopleIdSet;
            JSONArray peopleTags = actionJSON.optJSONArray("tags");
            if (peopleTags == null) {
                peopleIdSet = new HashSet();
            } else {
                peopleIdSet = vw.b(peopleTags);
            }
            for (String peopleId : content.i()) {
                peopleIdSet.add(peopleId);
            }
            actionJSON.put("tags", new ArrayList(peopleIdSet));
        }
        return actionJSON;
    }

    public static JSONObject a(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        return wo.a(shareOpenGraphContent.a(), new wr$8());
    }

    public static JSONArray a(JSONArray jsonArray, boolean requireNamespace) throws JSONException {
        JSONArray newArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);
            if (value instanceof JSONArray) {
                value = wr.a((JSONArray) value, requireNamespace);
            } else if (value instanceof JSONObject) {
                value = wr.a((JSONObject) value, requireNamespace);
            }
            newArray.put(value);
        }
        return newArray;
    }

    public static JSONObject a(JSONObject jsonObject, boolean requireNamespace) {
        if (jsonObject == null) {
            return null;
        }
        try {
            JSONObject newJsonObject = new JSONObject();
            JSONObject data = new JSONObject();
            JSONArray names = jsonObject.names();
            for (int i = 0; i < names.length(); i++) {
                String key = names.getString(i);
                Object value = jsonObject.get(key);
                if (value instanceof JSONObject) {
                    value = wr.a((JSONObject) value, true);
                } else if (value instanceof JSONArray) {
                    value = wr.a((JSONArray) value, true);
                }
                Pair<String, String> fieldNameAndNamespace = wr.a(key);
                String namespace = fieldNameAndNamespace.first;
                String fieldName = fieldNameAndNamespace.second;
                if (requireNamespace) {
                    if (namespace != null && namespace.equals("fbsdk")) {
                        newJsonObject.put(key, value);
                    } else if (namespace == null || namespace.equals("og")) {
                        newJsonObject.put(fieldName, value);
                    } else {
                        data.put(fieldName, value);
                    }
                } else if (namespace == null || !namespace.equals("fb")) {
                    newJsonObject.put(fieldName, value);
                } else {
                    newJsonObject.put(key, value);
                }
            }
            if (data.length() <= 0) {
                return newJsonObject;
            }
            newJsonObject.put("data", data);
            return newJsonObject;
        } catch (JSONException e) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    public static Pair<String, String> a(String fullName) {
        String fieldName;
        String namespace = null;
        int index = fullName.indexOf(58);
        if (index == -1 || fullName.length() <= index + 1) {
            fieldName = fullName;
        } else {
            namespace = fullName.substring(0, index);
            fieldName = fullName.substring(index + 1);
        }
        return new Pair(namespace, fieldName);
    }

    private static vq$a b(UUID callId, ShareMedia medium) {
        Bitmap bitmap = null;
        Uri uri = null;
        if (medium instanceof SharePhoto) {
            SharePhoto photo = (SharePhoto) medium;
            bitmap = photo.c();
            uri = photo.d();
        } else if (medium instanceof ShareVideo) {
            uri = ((ShareVideo) medium).c();
        }
        if (bitmap != null) {
            return vq.a(callId, bitmap);
        }
        if (uri != null) {
            return vq.a(callId, uri);
        }
        return null;
    }

    static void b(uc<wi$a> callback) {
        wr.a("cancelled", null);
        if (callback != null) {
            callback.onCancel();
        }
    }

    static void a(uc<wi$a> callback, String postId) {
        wr.a("succeeded", null);
        if (callback != null) {
            callback.onSuccess(new wi$a(postId));
        }
    }

    static void a(uc<wi$a> callback, FacebookException ex) {
        wr.a("error", ex.getMessage());
        if (callback != null) {
            callback.onError(ex);
        }
    }

    private static void a(String shareOutcome, String errorMessage) {
        AppEventsLogger logger = AppEventsLogger.a(ud.f());
        Bundle parameters = new Bundle();
        parameters.putString("fb_share_dialog_outcome", shareOutcome);
        if (errorMessage != null) {
            parameters.putString("error_message", errorMessage);
        }
        logger.a("fb_share_dialog_result", null, parameters);
    }

    public static ObjectType a(ObjectType objectType1, ObjectType objectType2) {
        if (objectType1 == objectType2) {
            return objectType1;
        }
        if (objectType1 == ObjectType.UNKNOWN) {
            return objectType2;
        }
        return objectType2 != ObjectType.UNKNOWN ? null : objectType1;
    }
}
