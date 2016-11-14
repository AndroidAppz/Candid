package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.CreatePostActivity;
import com.becandid.candid.activities.ImageCropActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.views.ChoosePhotoDialogView;
import com.becandid.candid.views.ChoosePhotoDialogView.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import rx.schedulers.Schedulers;

/* compiled from: PhotoHelper */
public class im implements a {
    static final char[] i = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public Bitmap f;
    final int g = 0;
    final int h = 1;
    private Activity j;
    private AlertDialog k;
    private Uri l;
    private Uri m;
    private Boolean n;
    private Boolean o = Boolean.valueOf(false);
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 100;
    private int u = 0;

    public im(BaseActivity activity) {
        this.j = activity;
        activity.setPhotoHelper(this);
    }

    public void clearPhoto() {
        if (this.l != null) {
            String realPath = b(this.l);
            File file = new File(b(this.l));
            if (!file.exists()) {
                return;
            }
            if (file.delete()) {
                Log.d("File Deleted", "file Deleted :" + realPath);
            } else {
                Log.d("File Not Deleted", "file not Deleted :" + realPath);
            }
        }
    }

    public void a() {
        if (this.a == null) {
            rb.a(new Exception("photoPath is NULL"));
        } else {
            ie.a().c(this.b, this.a).b(Schedulers.io()).a(apn.a()).b(new im$1(this));
        }
    }

    public void choosePhoto(String searchQuery) {
        Builder builder = new Builder(this.j);
        ChoosePhotoDialogView dialogView = new ChoosePhotoDialogView(this.j);
        dialogView.setQuery(searchQuery);
        dialogView.setDelegate(this);
        builder.setView(dialogView);
        this.k = builder.create();
        this.k.setOnCancelListener(new im$2(this));
        this.k.show();
    }

    public void choosePhoto() {
        choosePhoto(false);
    }

    public void choosePhoto(boolean cameraOnly) {
        if (cameraOnly) {
            b();
            return;
        }
        List<String> titles = new ArrayList();
        List<String> actions = new ArrayList();
        String cancelButtonTitle = this.j.getString(17039360);
        titles.add("Take a Photo");
        actions.add("photo");
        titles.add("Choose from Photos");
        actions.add("library");
        titles.add(cancelButtonTitle);
        actions.add("cancel");
        ArrayAdapter<String> adapter = new ArrayAdapter(this.j, 17367057, titles);
        Builder builder = new Builder(this.j);
        builder.setAdapter(adapter, new im$3(this, actions));
        this.k = builder.create();
        this.k.setOnCancelListener(new im$4(this));
        this.k.show();
    }

    public void a(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == 0 && grantResults[1] == 0) {
                b();
            }
        } else if (requestCode == 0 && grantResults.length > 0 && grantResults[0] == 0) {
            c();
        }
    }

    public void b() {
        if (bb.checkSelfPermission(this.j, "android.permission.CAMERA") != 0 || bb.checkSelfPermission(this.j, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this.j, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        } else if (f()) {
            e();
            Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
            ContentValues values = new ContentValues(1);
            values.put("mime_type", "image/jpg");
            this.l = this.j.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, values);
            cameraIntent.addFlags(3);
            cameraIntent.putExtra("output", this.l);
            if (this.o.booleanValue()) {
                cameraIntent.putExtra("crop", "true");
                cameraIntent.putExtra("aspectX", this.r);
                cameraIntent.putExtra("aspectY", this.s);
            }
            if (cameraIntent.resolveActivity(this.j.getPackageManager()) == null) {
                Toast.makeText(this.j, "Cannot launch camera", 1).show();
                return;
            }
            try {
                Log.d("PhotoHelper", "startActivityForResult: camera into file: " + this.l);
                this.j.startActivityForResult(cameraIntent, 901);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this.j, "Cannot launch camera", 1).show();
            }
        } else {
            Toast.makeText(this.j, "Camera not available", 1).show();
        }
    }

    private void e() {
        this.p = 960;
        this.q = 960;
        this.t = 100;
        this.n = Boolean.valueOf(true);
        this.o = Boolean.valueOf(false);
        this.u = 0;
    }

    public void c() {
        if (bb.checkSelfPermission(this.j, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this.j, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
            return;
        }
        e();
        Intent libraryIntent = new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI);
        this.m = null;
        if (this.o.booleanValue()) {
            this.m = Uri.fromFile(a(true));
            libraryIntent.putExtra("output", this.m);
            libraryIntent.putExtra("crop", "true");
            libraryIntent.putExtra("aspectX", this.r);
            libraryIntent.putExtra("aspectY", this.s);
        }
        if (libraryIntent.resolveActivity(this.j.getPackageManager()) == null) {
            Toast.makeText(this.j, "Cannot open photo library", 1).show();
            return;
        }
        try {
            Log.d("PhotoHelper", "startActivityForResult: library");
            this.j.startActivityForResult(libraryIntent, 902);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this.j, "Cannot open photo library", 1).show();
        }
    }

    public void d() {
        if (this.k != null) {
            this.k.dismiss();
        }
    }

    public void choosePhoto(String sourceUrl, int width, int height) {
        this.f = null;
        Log.d("PhotoHelper", "Got photo: " + sourceUrl + " size: " + width + " x " + height);
        this.b = sourceUrl;
        this.d = width;
        this.e = height;
        ((BaseActivity) this.j).onPhotoChosen(sourceUrl, width, height);
    }

    private File a(boolean forcePictureDirectory) {
        String filename = "image-" + UUID.randomUUID().toString() + ".jpg";
        if (this.n.booleanValue() && !forcePictureDirectory) {
            return new File(this.j.getCacheDir(), filename);
        }
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File f = new File(path, filename);
        try {
            path.mkdirs();
            f.createNewFile();
            return f;
        } catch (IOException e) {
            e.printStackTrace();
            return f;
        }
    }

    private boolean f() {
        return this.j.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public void a(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            Uri uri;
            switch (requestCode) {
                case 901:
                    uri = this.l;
                    break;
                case 902:
                    if (this.m == null) {
                        uri = data.getData();
                        break;
                    }
                    uri = this.m;
                    Uri uriTmp = data.getData();
                    if (uriTmp != null) {
                        uri = uriTmp;
                        break;
                    }
                    break;
                case 903:
                case 904:
                case 905:
                    if (!data.getBooleanExtra(ImageCropActivity.USE_FULL_IMAGE, false)) {
                        String croppedPath = data.getStringExtra(ImageCropActivity.IMAGE_PATH);
                        if (croppedPath != null) {
                            uri = Uri.parse(croppedPath);
                            String realPath = b(uri);
                            if (realPath != null) {
                                Options options = new Options();
                                this.f = BitmapFactory.decodeFile(realPath, options);
                                a(realPath, uri, options.outWidth, options.outHeight);
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    iq.a().a(new ih$y());
                    return;
                default:
                    return;
            }
            a(uri, requestCode);
        }
    }

    public void a(Uri uri, int requestCode) {
        String realPath = b(uri);
        boolean isUrl = false;
        if (realPath != null) {
            try {
                URL url = new URL(realPath);
                isUrl = true;
            } catch (MalformedURLException e) {
                rb.a(e);
            }
        }
        if (realPath == null || isUrl) {
            try {
                File file = a(uri);
                realPath = file.getAbsolutePath();
                uri = Uri.fromFile(file);
            } catch (Exception e2) {
                Toast.makeText(this.j, "Could not read photo", 1).show();
                return;
            }
        }
        a(realPath, uri, requestCode);
    }

    public void a(String realPath, Uri uri, int requestCode) {
        Options options;
        Options options2 = new Options();
        this.f = BitmapFactory.decodeFile(realPath, options2);
        int initialWidth = options2.outWidth;
        int initialHeight = options2.outHeight;
        Display display = ((WindowManager) this.j.getSystemService("window")).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int orientation;
        if (initialHeight > size.y - iu.a(200, this.j)) {
            try {
                orientation = new ExifInterface(realPath).getAttributeInt("Orientation", 1);
                Bitmap scaledBitmap;
                String filePath;
                if (!(this.j instanceof CreatePostActivity) && !(this.j instanceof MessageActivity)) {
                    scaledBitmap = iu.a(realPath);
                    filePath = Environment.getExternalStorageDirectory() + "/crop_test.jpg";
                    a(scaledBitmap, new File(filePath), 100);
                    if (filePath != null) {
                        uri = Uri.parse(filePath);
                        realPath = b(uri);
                        if (realPath != null) {
                            options = new Options();
                            this.f = BitmapFactory.decodeFile(realPath, options);
                            a(realPath, uri, options.outWidth, options.outHeight);
                            iu.b(filePath, new ExifInterface(filePath).getAttributeInt("Orientation", 1));
                            iq.a().a(new ih$y());
                            options2 = options;
                            return;
                        }
                        return;
                    }
                    return;
                } else if (orientation == 6 || orientation == 8 || (orientation == 0 && initialHeight > initialWidth)) {
                    a(realPath, 5, 5, requestCode);
                    return;
                } else {
                    scaledBitmap = iu.a(realPath);
                    filePath = Environment.getExternalStorageDirectory() + "/crop_test.jpg";
                    a(scaledBitmap, new File(filePath), 100);
                    if (filePath != null) {
                        uri = Uri.parse(filePath);
                        realPath = b(uri);
                        if (realPath != null) {
                            options = new Options();
                            try {
                                this.f = BitmapFactory.decodeFile(realPath, options);
                                a(realPath, uri, options.outWidth, options.outHeight);
                                iu.b(filePath, new ExifInterface(filePath).getAttributeInt("Orientation", 1));
                                iq.a().a(new ih$y());
                                options2 = options;
                                return;
                            } catch (IOException e) {
                                IOException e2 = e;
                                options2 = options;
                                rb.a(e2);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            } catch (IOException e3) {
                e2 = e3;
                rb.a(e2);
                return;
            }
        }
        a(realPath, uri, initialWidth, initialHeight);
        try {
            ExifInterface exif = new ExifInterface(realPath);
            try {
                orientation = exif.getAttributeInt("Orientation", 1);
                if (realPath.endsWith(".jpg")) {
                    iu.a(realPath, orientation, Environment.getExternalStorageDirectory() + "/wipe_exif.jpg");
                } else {
                    iu.a(realPath, orientation, Environment.getExternalStorageDirectory() + "/wipe_exif.png");
                }
                iq.a().a(new ih$y());
            } catch (IOException e4) {
                e2 = e4;
                ExifInterface exifInterface = exif;
                e2.printStackTrace();
                Toast.makeText(this.j, "Could not read photo information", 1).show();
            }
        } catch (IOException e5) {
            e2 = e5;
            e2.printStackTrace();
            Toast.makeText(this.j, "Could not read photo information", 1).show();
        }
    }

    private void a(String realPath, Uri uri, int imgWidth, int imgHeight) {
        this.d = imgWidth;
        this.e = imgHeight;
        if (this.f != null) {
            this.c = a(this.f);
        }
        this.b = uri.toString();
        this.a = realPath;
    }

    private String b(Uri uri) {
        Cursor cursor = this.j.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (cursor == null) {
            return uri.getPath();
        }
        try {
            Bitmap orgImage = BitmapFactory.decodeStream(this.j.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
        }
        if (!cursor.moveToFirst()) {
            return null;
        }
        String result = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        cursor.close();
        return result;
    }

    public File a(Uri uri) throws Exception {
        File file = new File(this.j.getCacheDir(), "photo-" + uri.getLastPathSegment());
        InputStream input = this.j.getContentResolver().openInputStream(uri);
        OutputStream output = new FileOutputStream(file);
        try {
            byte[] buffer = new byte[4096];
            while (true) {
                int read = input.read(buffer);
                if (read == -1) {
                    break;
                }
                output.write(buffer, 0, read);
            }
            output.flush();
            return file;
        } finally {
            output.close();
            input.close();
        }
    }

    public Bitmap a(Bitmap bmpOriginal, int width, int height) {
        int origHeight = bmpOriginal.getHeight();
        int origWidth = bmpOriginal.getWidth();
        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(cm));
        c.drawBitmap(bmpOriginal, new Rect(0, 0, origWidth, origHeight), new Rect(0, 0, width, height), paint);
        return bmpGrayscale;
    }

    public String a(Bitmap orig) {
        return a(orig, 16);
    }

    String a(Bitmap orig, int size) {
        Bitmap gray = a(orig, size + 1, size);
        int b = 0;
        int offset = 0;
        StringBuilder output = new StringBuilder((size * size) / 4);
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                b = (b << 1) + ((gray.getPixel(x + 1, y) & 65280) > (gray.getPixel(x, y) & 65280) ? 1 : 0);
                offset++;
                if (offset == 4) {
                    output.append(i[b]);
                    b = 0;
                    offset = 0;
                }
            }
        }
        gray.recycle();
        return output.toString();
    }

    private void a(String path, int aspectX, int aspectY, int prevRequestCode) {
        if (path != null) {
            Intent intent = new Intent(this.j, ImageCropActivity.class);
            intent.putExtra(ImageCropActivity.IMAGE_PATH, path);
            intent.putExtra(ImageCropActivity.ASPECT_X, aspectX);
            intent.putExtra(ImageCropActivity.ASPECT_Y, aspectY);
            if (prevRequestCode == 901) {
                this.j.startActivityForResult(intent, 904);
            } else if (prevRequestCode == 902) {
                this.j.startActivityForResult(intent, 905);
            } else {
                this.j.startActivityForResult(intent, 903);
            }
        }
    }

    private void a(Bitmap bm, File file, int quality) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        bm.compress(CompressFormat.JPEG, quality, fos);
        fos.flush();
        fos.close();
    }
}
