/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.util.Locale
 *  java.util.Map
 *  javax.net.ssl.HttpsURLConnection
 *  javax.net.ssl.SSLSocketFactory
 */
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class ams
implements amt {
    private final akx a;
    private amv b;
    private SSLSocketFactory c;
    private boolean d;

    public ams() {
        this(new ako());
    }

    public ams(akx akx2) {
        this.a = akx2;
    }

    private void a() {
        ams ams2 = this;
        synchronized (ams2) {
            this.d = false;
            this.c = null;
            return;
        }
    }

    private boolean a(String string2) {
        if (string2 != null && string2.toLowerCase(Locale.US).startsWith("https")) {
            return true;
        }
        return false;
    }

    private SSLSocketFactory b() {
        ams ams2 = this;
        synchronized (ams2) {
            if (this.c == null && !this.d) {
                this.c = this.c();
            }
            SSLSocketFactory sSLSocketFactory = this.c;
            return sSLSocketFactory;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private SSLSocketFactory c() {
        ams ams2 = this;
        synchronized (ams2) {
            this.d = true;
            try {
                SSLSocketFactory sSLSocketFactory = amu.a(this.b);
                this.a.a("Fabric", "Custom SSL pinning enabled");
                return sSLSocketFactory;
            }
            catch (Exception var2_3) {
                this.a.e("Fabric", "Exception while validating pinned certs", (Throwable)var2_3);
                return null;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public HttpRequest a(HttpMethod httpMethod, String string2, Map<String, String> map) {
        HttpRequest httpRequest;
        SSLSocketFactory sSLSocketFactory;
        switch (.a[httpMethod.ordinal()]) {
            default: {
                throw new IllegalArgumentException("Unsupported HTTP method!");
            }
            case 1: {
                httpRequest = HttpRequest.a((CharSequence)string2, map, (boolean)true);
                break;
            }
            case 2: {
                httpRequest = HttpRequest.b((CharSequence)string2, map, (boolean)true);
                break;
            }
            case 3: {
                httpRequest = HttpRequest.d((CharSequence)string2);
                break;
            }
            case 4: {
                httpRequest = HttpRequest.e((CharSequence)string2);
            }
        }
        if (super.a(string2) && this.b != null && (sSLSocketFactory = super.b()) != null) {
            ((HttpsURLConnection)httpRequest.a()).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpRequest;
    }

    @Override
    public void a(amv amv2) {
        if (this.b != amv2) {
            this.b = amv2;
            super.a();
        }
    }

}

