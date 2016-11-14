package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: HttpUrlFetcher */
public class kp implements km<InputStream> {
    private static final kp$b a = new kp$a();
    private final mb b;
    private final kp$b c;
    private HttpURLConnection d;
    private InputStream e;
    private volatile boolean f;

    public /* synthetic */ Object b(Priority x0) throws Exception {
        return a(x0);
    }

    public kp(mb glideUrl) {
        this(glideUrl, a);
    }

    kp(mb glideUrl, kp$b connectionFactory) {
        this.b = glideUrl;
        this.c = connectionFactory;
    }

    public InputStream a(Priority priority) throws Exception {
        return a(this.b.a(), 0, null, this.b.c());
    }

    private InputStream a(URL url, int redirects, URL lastUrl, Map<String, String> headers) throws IOException {
        if (redirects >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (lastUrl != null) {
            try {
                if (url.toURI().equals(lastUrl.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException e) {
            }
        }
        this.d = this.c.a(url);
        for (Entry<String, String> headerEntry : headers.entrySet()) {
            this.d.addRequestProperty((String) headerEntry.getKey(), (String) headerEntry.getValue());
        }
        this.d.setConnectTimeout(2500);
        this.d.setReadTimeout(2500);
        this.d.setUseCaches(false);
        this.d.setDoInput(true);
        this.d.connect();
        if (this.f) {
            return null;
        }
        int statusCode = this.d.getResponseCode();
        if (statusCode / 100 == 2) {
            return a(this.d);
        }
        if (statusCode / 100 == 3) {
            String redirectUrlString = this.d.getHeaderField("Location");
            if (!TextUtils.isEmpty(redirectUrlString)) {
                return a(new URL(url, redirectUrlString), redirects + 1, url, headers);
            }
            throw new IOException("Received empty or null redirect url");
        } else if (statusCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        } else {
            throw new IOException("Request failed " + statusCode + ": " + this.d.getResponseMessage());
        }
    }

    private InputStream a(HttpURLConnection urlConnection) throws IOException {
        if (TextUtils.isEmpty(urlConnection.getContentEncoding())) {
            this.e = qu.a(urlConnection.getInputStream(), (long) urlConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + urlConnection.getContentEncoding());
            }
            this.e = urlConnection.getInputStream();
        }
        return this.e;
    }

    public void a() {
        if (this.e != null) {
            try {
                this.e.close();
            } catch (IOException e) {
            }
        }
        if (this.d != null) {
            this.d.disconnect();
        }
    }

    public String b() {
        return this.b.d();
    }

    public void c() {
        this.f = true;
    }
}
