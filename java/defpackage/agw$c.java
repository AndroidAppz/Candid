package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

class agw$c implements Runnable {
    final /* synthetic */ agw a;
    private final URL b;
    private final byte[] c;
    private final agw$a d;
    private final String e;
    private final Map<String, String> f;

    public agw$c(agw agw, String str, URL url, byte[] bArr, Map<String, String> map, agw$a agw_a) {
        this.a = agw;
        xr.a(str);
        xr.a((Object) url);
        xr.a((Object) agw_a);
        this.b = url;
        this.c = bArr;
        this.d = agw_a;
        this.e = str;
        this.f = map;
    }

    public void run() {
        OutputStream outputStream;
        Throwable e;
        Map map;
        int i;
        HttpURLConnection httpURLConnection;
        Throwable th;
        Map map2;
        this.a.i();
        int i2 = 0;
        HttpURLConnection a;
        try {
            this.a.a(this.e);
            a = this.a.a(this.b);
            try {
                if (this.f != null) {
                    for (Entry entry : this.f.entrySet()) {
                        a.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.c != null) {
                    byte[] a2 = this.a.s().a(this.c);
                    this.a.w().E().a("Uploading data. size", Integer.valueOf(a2.length));
                    a.setDoOutput(true);
                    a.addRequestProperty("Content-Encoding", "gzip");
                    a.setFixedLengthStreamingMode(a2.length);
                    a.connect();
                    outputStream = a.getOutputStream();
                    try {
                        outputStream.write(a2);
                        outputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        map = null;
                        i = 0;
                        httpURLConnection = a;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.a.w().f().a("Error closing HTTP compressed POST connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.a.g();
                        this.a.v().a(new agw$b(this.e, this.d, i, e, null, map));
                    } catch (Throwable th2) {
                        th = th2;
                        map2 = null;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e32) {
                                this.a.w().f().a("Error closing HTTP compressed POST connection output stream", e32);
                            }
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        this.a.g();
                        this.a.v().a(new agw$b(this.e, this.d, i2, null, null, map2));
                        throw th;
                    }
                }
                i2 = a.getResponseCode();
                map2 = a.getHeaderFields();
                try {
                    byte[] a3 = this.a.a(a);
                    if (a != null) {
                        a.disconnect();
                    }
                    this.a.g();
                    this.a.v().a(new agw$b(this.e, this.d, i2, null, a3, map2));
                } catch (IOException e4) {
                    e = e4;
                    map = map2;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = a;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.a.g();
                    this.a.v().a(new agw$b(this.e, this.d, i, e, null, map));
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.a.g();
                    this.a.v().a(new agw$b(this.e, this.d, i2, null, null, map2));
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                map = null;
                i = i2;
                outputStream = null;
                httpURLConnection = a;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.a.g();
                this.a.v().a(new agw$b(this.e, this.d, i, e, null, map));
            } catch (Throwable th32) {
                th = th32;
                map2 = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.a.g();
                this.a.v().a(new agw$b(this.e, this.d, i2, null, null, map2));
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            map = null;
            i = 0;
            outputStream = null;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.a.g();
            this.a.v().a(new agw$b(this.e, this.d, i, e, null, map));
        } catch (Throwable th322) {
            th = th322;
            map2 = null;
            a = null;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            this.a.g();
            this.a.v().a(new agw$b(this.e, this.d, i2, null, null, map2));
            throw th;
        }
    }
}
