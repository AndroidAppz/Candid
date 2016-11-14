package defpackage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: ImageResponseCache */
class vm$a extends BufferedInputStream {
    HttpURLConnection a;

    vm$a(InputStream stream, HttpURLConnection connection) {
        super(stream, 8192);
        this.a = connection;
    }

    public void close() throws IOException {
        super.close();
        vw.a(this.a);
    }
}
