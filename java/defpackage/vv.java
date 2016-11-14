package defpackage;

import android.net.Uri;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: UrlRedirectCache */
class vv {
    static final String a = vv.class.getSimpleName();
    private static final String b = (a + "_Redirect");
    private static volatile vh c;

    vv() {
    }

    static synchronized vh a() throws IOException {
        vh vhVar;
        synchronized (vv.class) {
            if (c == null) {
                c = new vh(a, new vh$d());
            }
            vhVar = c;
        }
        return vhVar;
    }

    static Uri a(Uri uri) {
        Closeable closeable;
        Throwable th;
        Uri uri2 = null;
        if (uri != null) {
            String uriString = uri.toString();
            closeable = null;
            try {
                vh cache = vv.a();
                boolean redirectExists = false;
                Closeable reader = null;
                while (true) {
                    try {
                        InputStream stream = cache.a(uriString, b);
                        if (stream == null) {
                            break;
                        }
                        redirectExists = true;
                        closeable = new InputStreamReader(stream);
                        char[] buffer = new char[128];
                        StringBuilder urlBuilder = new StringBuilder();
                        while (true) {
                            int bufferLength = closeable.read(buffer, 0, buffer.length);
                            if (bufferLength <= 0) {
                                break;
                            }
                            urlBuilder.append(buffer, 0, bufferLength);
                        }
                        vw.a(closeable);
                        uriString = urlBuilder.toString();
                        reader = closeable;
                    } catch (IOException e) {
                        closeable = reader;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = reader;
                    }
                }
                if (redirectExists) {
                    uri2 = Uri.parse(uriString);
                    vw.a(reader);
                } else {
                    vw.a(reader);
                    closeable = reader;
                }
            } catch (IOException e2) {
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return uri2;
        vw.a(closeable);
        return uri2;
        vw.a(closeable);
        throw th;
    }

    static void a(Uri fromUri, Uri toUri) {
        if (fromUri != null && toUri != null) {
            Closeable redirectStream = null;
            try {
                redirectStream = vv.a().b(fromUri.toString(), b);
                redirectStream.write(toUri.toString().getBytes());
            } catch (IOException e) {
            } finally {
                vw.a(redirectStream);
            }
        }
    }
}
