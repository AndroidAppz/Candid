package defpackage;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: ImageResponseCache */
class vm {
    static final String a = vm.class.getSimpleName();
    private static volatile vh b;

    vm() {
    }

    static synchronized vh a(Context context) throws IOException {
        vh vhVar;
        synchronized (vm.class) {
            if (b == null) {
                b = new vh(a, new vh$d());
            }
            vhVar = b;
        }
        return vhVar;
    }

    static InputStream a(Uri uri, Context context) {
        InputStream imageStream = null;
        if (uri != null && vm.a(uri)) {
            try {
                imageStream = vm.a(context).a(uri.toString());
            } catch (IOException e) {
                vp.a(LoggingBehavior.CACHE, 5, a, e.toString());
            }
        }
        return imageStream;
    }

    static InputStream a(Context context, HttpURLConnection connection) throws IOException {
        InputStream stream = null;
        if (connection.getResponseCode() == 200) {
            Uri uri = Uri.parse(connection.getURL().toString());
            stream = connection.getInputStream();
            try {
                if (vm.a(uri)) {
                    stream = vm.a(context).a(uri.toString(), new vm$a(stream, connection));
                }
            } catch (IOException e) {
            }
        }
        return stream;
    }

    private static boolean a(Uri uri) {
        if (uri != null) {
            String uriHost = uri.getHost();
            if (uriHost.endsWith("fbcdn.net")) {
                return true;
            }
            if (uriHost.startsWith("fbcdn") && uriHost.endsWith("akamaihd.net")) {
                return true;
            }
        }
        return false;
    }
}
