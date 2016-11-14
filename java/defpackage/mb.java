package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* compiled from: GlideUrl */
public class mb {
    private final URL a;
    private final mc b;
    private final String c;
    private String d;
    private URL e;

    public mb(URL url) {
        this(url, mc.b);
    }

    public mb(String url) {
        this(url, mc.b);
    }

    public mb(URL url, mc headers) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        } else if (headers == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.a = url;
            this.c = null;
            this.b = headers;
        }
    }

    public mb(String url, mc headers) {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + url);
        } else if (headers == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.c = url;
            this.a = null;
            this.b = headers;
        }
    }

    public URL a() throws MalformedURLException {
        return e();
    }

    private URL e() throws MalformedURLException {
        if (this.e == null) {
            this.e = new URL(f());
        }
        return this.e;
    }

    public String b() {
        return f();
    }

    private String f() {
        if (TextUtils.isEmpty(this.d)) {
            String unsafeStringUrl = this.c;
            if (TextUtils.isEmpty(unsafeStringUrl)) {
                unsafeStringUrl = this.a.toString();
            }
            this.d = Uri.encode(unsafeStringUrl, "@#&=*+-_.,:!?()/~'%");
        }
        return this.d;
    }

    public Map<String, String> c() {
        return this.b.a();
    }

    public String d() {
        return this.c != null ? this.c : this.a.toString();
    }

    public String toString() {
        return d() + '\n' + this.b.toString();
    }

    public boolean equals(Object o) {
        if (!(o instanceof mb)) {
            return false;
        }
        mb other = (mb) o;
        if (d().equals(other.d()) && this.b.equals(other.b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (d().hashCode() * 31) + this.b.hashCode();
    }
}
