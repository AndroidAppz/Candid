package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: StreamEncoder */
public class mm implements ke<InputStream> {
    public boolean a(InputStream data, OutputStream os) {
        byte[] buffer = qt.a().b();
        while (true) {
            try {
                int read = data.read(buffer);
                if (read != -1) {
                    os.write(buffer, 0, read);
                } else {
                    qt.a().a(buffer);
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                qt.a().a(buffer);
                return false;
            } catch (Throwable th) {
                qt.a().a(buffer);
            }
        }
    }

    public String a() {
        return "";
    }
}
