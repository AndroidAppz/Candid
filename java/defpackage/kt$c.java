package defpackage;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: DecodeJob */
class kt$c<DataType> implements lm$b {
    final /* synthetic */ kt a;
    private final ke<DataType> b;
    private final DataType c;

    public kt$c(kt ktVar, ke<DataType> encoder, DataType data) {
        this.a = ktVar;
        this.b = encoder;
        this.c = data;
    }

    public boolean a(File file) {
        boolean success = false;
        OutputStream os = null;
        try {
            os = this.a.l.a(file);
            success = this.b.a(this.c, os);
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "Failed to find file to write to disk cache", e2);
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e4) {
                }
            }
        }
        return success;
    }
}
