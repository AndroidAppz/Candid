package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: MessageViewHolder */
class iz$2$1 implements px<String, Bitmap> {
    final /* synthetic */ iz$2 a;

    iz$2$1(iz$2 this$0) {
        this.a = this$0;
    }

    public /* synthetic */ boolean onException(Exception exception, Object obj, qq qqVar, boolean z) {
        return a(exception, (String) obj, qqVar, z);
    }

    public /* synthetic */ boolean onResourceReady(Object obj, Object obj2, qq qqVar, boolean z, boolean z2) {
        return a((Bitmap) obj, (String) obj2, qqVar, z, z2);
    }

    public boolean a(Exception e, String model, qq<Bitmap> qqVar, boolean isFirstResource) {
        return false;
    }

    public boolean a(Bitmap resource, String model, qq<Bitmap> qqVar, boolean isFromMemoryCache, boolean isFirstResource) {
        File candidDirectory = new File(Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Candid" + File.separator);
        if (!candidDirectory.exists()) {
            candidDirectory.mkdir();
        }
        try {
            OutputStream fOut = new FileOutputStream(new File(candidDirectory, new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png"));
            resource.compress(CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            Toast.makeText(this.a.b, "Image saved", 1).show();
        } catch (Exception e) {
            Log.d("FullscreenImage", e.toString());
            Toast.makeText(this.a.b, "An error occured. Please try again later.", 1).show();
        }
        return false;
    }
}
