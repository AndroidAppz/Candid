package defpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: HttpUrlFetcher */
class kp$a implements kp$b {
    private kp$a() {
    }

    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
