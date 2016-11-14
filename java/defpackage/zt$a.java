package defpackage;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zt$a extends yn$a {
    private int a;

    protected zt$a(byte[] bArr) {
        xr.b(bArr.length == 25, "cert hash data has incorrect length. length=" + bArr.length);
        this.a = Arrays.hashCode(bArr);
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public zy a() {
        return zz.a(c());
    }

    public int b() {
        return hashCode();
    }

    abstract byte[] c();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof yn)) {
            return false;
        }
        try {
            yn ynVar = (yn) obj;
            if (ynVar.b() != hashCode()) {
                return false;
            }
            zy a = ynVar.a();
            if (a == null) {
                return false;
            }
            return Arrays.equals(c(), (byte[]) zz.a(a));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
            return false;
        }
    }

    public int hashCode() {
        return this.a;
    }
}
