package defpackage;

import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.share.model.SharePhoto;
import org.json.JSONObject;

/* compiled from: ShareInternalUtility */
class wr$8 implements wo$a {
    wr$8() {
    }

    public JSONObject a(SharePhoto photo) {
        Uri photoUri = photo.d();
        JSONObject photoJSONObject = new JSONObject();
        try {
            photoJSONObject.put("url", photoUri.toString());
            return photoJSONObject;
        } catch (Throwable e) {
            throw new FacebookException("Unable to attach images", e);
        }
    }
}
