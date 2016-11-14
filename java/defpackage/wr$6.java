package defpackage;

import android.os.Bundle;
import com.facebook.share.model.ShareMedia;
import java.util.List;
import java.util.UUID;

/* compiled from: ShareInternalUtility */
class wr$6 implements vw$d<ShareMedia, Bundle> {
    final /* synthetic */ UUID a;
    final /* synthetic */ List b;

    wr$6(UUID uuid, List list) {
        this.a = uuid;
        this.b = list;
    }

    public Bundle a(ShareMedia item) {
        vq$a attachment = wr.b(this.a, item);
        this.b.add(attachment);
        Bundle mediaInfo = new Bundle();
        mediaInfo.putString("type", item.b().name());
        mediaInfo.putString("uri", attachment.a());
        return mediaInfo;
    }
}
