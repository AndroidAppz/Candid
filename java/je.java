/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class je {
    /*
     * Enabled aggressive block sorting
     */
    public static Bitmap a(View view, int n2) {
        Bitmap bitmap = Bitmap.createBitmap((int)view.getWidth(), (int)view.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable drawable = view.getBackground();
        if (drawable != null) {
            drawable.draw(canvas);
        } else {
            canvas.drawColor(n2);
        }
        view.draw(canvas);
        return bitmap;
    }

    public static Bitmap a(String string2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)options);
    }

    private static File a(Activity activity) {
        String string2 = String.valueOf((Object)aos.b(String.valueOf((long)System.currentTimeMillis())));
        File file = je.a((Context)activity, "img_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, string2);
    }

    private static File a(Context context, String string2) {
        return new File(context.getCacheDir(), string2);
    }

    public static String a(Activity activity, Bitmap bitmap) {
        try {
            File file = je.a(activity);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            String string2 = file.getAbsolutePath();
            return string2;
        }
        catch (IOException var2_5) {
            return "";
        }
    }

    public static boolean b(String string2) {
        return new File(string2).delete();
    }
}

