package defpackage;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ImageVideoWrapperEncoder */
public class mf implements ke<me> {
    private final ke<InputStream> a;
    private final ke<ParcelFileDescriptor> b;
    private String c;

    public mf(ke<InputStream> streamEncoder, ke<ParcelFileDescriptor> fileDescriptorEncoder) {
        this.a = streamEncoder;
        this.b = fileDescriptorEncoder;
    }

    public boolean a(me data, OutputStream os) {
        if (data.a() != null) {
            return this.a.a(data.a(), os);
        }
        return this.b.a(data.b(), os);
    }

    public String a() {
        if (this.c == null) {
            this.c = this.a.a() + this.b.a();
        }
        return this.c;
    }
}
