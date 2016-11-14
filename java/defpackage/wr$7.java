package defpackage;

import com.facebook.FacebookException;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: ShareInternalUtility */
class wr$7 implements wo$a {
    final /* synthetic */ UUID a;
    final /* synthetic */ ArrayList b;

    wr$7(UUID uuid, ArrayList arrayList) {
        this.a = uuid;
        this.b = arrayList;
    }

    public JSONObject a(SharePhoto photo) {
        vq$a attachment = wr.b(this.a, photo);
        if (attachment == null) {
            return null;
        }
        this.b.add(attachment);
        JSONObject photoJSONObject = new JSONObject();
        try {
            photoJSONObject.put("url", attachment.a());
            if (!photo.e()) {
                return photoJSONObject;
            }
            photoJSONObject.put("user_generated", true);
            return photoJSONObject;
        } catch (Throwable e) {
            throw new FacebookException("Unable to attach images", e);
        }
    }
}
