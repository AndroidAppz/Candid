package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: BlurUtils */
public class je {
    public static Bitmap a(String mBackgroundFilename) {
        Options localOptions = new Options();
        localOptions.inPurgeable = true;
        localOptions.inInputShareable = true;
        return BitmapFactory.decodeFile(mBackgroundFilename, localOptions);
    }

    public static String a(Activity context, Bitmap bitmap) {
        String filePath = "";
        try {
            File file = je.a(context);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(CompressFormat.JPEG, 50, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            return filePath;
        }
    }

    private static File a(Activity context) {
        String md5 = String.valueOf(aos.b(String.valueOf(System.currentTimeMillis())));
        File localFile = je.a((Context) context, "img_cache");
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return new File(localFile, md5);
    }

    private static File a(Context context, String dirName) {
        return new File(context.getCacheDir(), dirName);
    }

    public static Bitmap a(View view, int color) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            bgDrawable.draw(canvas);
        } else {
            canvas.drawColor(color);
        }
        view.draw(canvas);
        return returnedBitmap;
    }

    public static boolean b(String filename) {
        return new File(filename).delete();
    }
}
