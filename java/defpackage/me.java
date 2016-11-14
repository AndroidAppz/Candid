package defpackage;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: ImageVideoWrapper */
public class me {
    private final InputStream a;
    private final ParcelFileDescriptor b;

    public me(InputStream streamData, ParcelFileDescriptor fileDescriptor) {
        this.a = streamData;
        this.b = fileDescriptor;
    }

    public InputStream a() {
        return this.a;
    }

    public ParcelFileDescriptor b() {
        return this.b;
    }
}
