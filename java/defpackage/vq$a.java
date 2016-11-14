package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import java.util.UUID;

/* compiled from: NativeAppCallAttachmentStore */
public final class vq$a {
    private final UUID a;
    private final String b;
    private final String c;
    private Bitmap d;
    private Uri e;
    private boolean f;
    private boolean g;

    private vq$a(UUID callId, Bitmap bitmap, Uri uri) {
        String a;
        boolean z = true;
        this.a = callId;
        this.d = bitmap;
        this.e = uri;
        if (uri != null) {
            String scheme = uri.getScheme();
            if ("content".equalsIgnoreCase(scheme)) {
                this.f = true;
                if (uri.getAuthority() == null || uri.getAuthority().startsWith("media")) {
                    z = false;
                }
                this.g = z;
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                this.g = true;
            } else if (!vw.b(uri)) {
                throw new FacebookException("Unsupported scheme for media Uri : " + scheme);
            }
        } else if (bitmap != null) {
            this.g = true;
        } else {
            throw new FacebookException("Cannot share media without a bitmap or Uri set");
        }
        this.c = !this.g ? null : UUID.randomUUID().toString();
        if (this.g) {
            a = FacebookContentProvider.a(ud.i(), callId, this.c);
        } else {
            a = this.e.toString();
        }
        this.b = a;
    }

    public String a() {
        return this.b;
    }
}
