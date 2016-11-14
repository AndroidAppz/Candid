package defpackage;

import android.net.Uri;
import com.facebook.login.LoginClient.Request;
import java.util.Collection;

/* compiled from: DeviceLoginManager */
public class wa extends we {
    private static volatile wa b;
    private Uri a;

    public static wa a() {
        if (b == null) {
            synchronized (wa.class) {
                if (b == null) {
                    b = new wa();
                }
            }
        }
        return b;
    }

    public void a(Uri uri) {
        this.a = uri;
    }

    public Uri b() {
        return this.a;
    }

    protected Request a(Collection<String> permissions) {
        Request request = super.a((Collection) permissions);
        Uri redirectUri = b();
        if (redirectUri != null) {
            request.a(redirectUri.toString());
        }
        return request;
    }
}
