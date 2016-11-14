/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.database.Cursor
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.net.Uri
 *  android.os.Environment
 *  android.os.Parcelable
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.support.v4.app.ActivityCompat
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.util.Log
 *  android.view.View
 *  android.widget.ArrayAdapter
 *  android.widget.ListAdapter
 *  android.widget.Toast
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.UUID
 *  rx.schedulers.Schedulers
 */
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.ImageCropActivity;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.ChoosePhotoDialogView;
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

public class im
implements ChoosePhotoDialogView.a {
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
    private Boolean o = false;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 100;
    private int u = 0;

    public im(BaseActivity baseActivity) {
        this.j = baseActivity;
        baseActivity.setPhotoHelper((im)this);
    }

    private File a(boolean bl2) {
        String string2 = "image-" + UUID.randomUUID().toString() + ".jpg";
        if (this.n.booleanValue() && !bl2) {
            return new File(this.j.getCacheDir(), string2);
        }
        File file = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_PICTURES);
        File file2 = new File(file, string2);
        try {
            file.mkdirs();
            file2.createNewFile();
            return file2;
        }
        catch (IOException var5_5) {
            var5_5.printStackTrace();
            return file2;
        }
    }

    private void a(Bitmap bitmap, File file, int n2) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, n2, (OutputStream)fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private void a(String string2, int n2, int n3, int n4) {
        if (string2 == null) {
            return;
        }
        Intent intent = new Intent((Context)this.j, (Class)ImageCropActivity.class);
        intent.putExtra(ImageCropActivity.IMAGE_PATH, string2);
        intent.putExtra(ImageCropActivity.ASPECT_X, n2);
        intent.putExtra(ImageCropActivity.ASPECT_Y, n3);
        if (n4 == 901) {
            this.j.startActivityForResult(intent, 904);
            return;
        }
        if (n4 == 902) {
            this.j.startActivityForResult(intent, 905);
            return;
        }
        this.j.startActivityForResult(intent, 903);
    }

    private void a(String string2, Uri uri, int n2, int n3) {
        this.d = n2;
        this.e = n3;
        if (this.f != null) {
            this.c = this.a(this.f);
        }
        this.b = uri.toString();
        this.a = string2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private String b(Uri var1) {
        var2_2 = new String[]{"_data"};
        var3_3 = this.j.getContentResolver().query(var1, var2_2, null, null, null);
        if (var3_3 == null) {
            var6_4 = var1.getPath();
            do {
                return var6_4;
                break;
            } while (true);
        }
        try {
            BitmapFactory.decodeStream((InputStream)this.j.getContentResolver().openInputStream(var1));
        }
        catch (FileNotFoundException var4_7) {
            ** continue;
        }
lbl11: // 2 sources:
        do {
            var5_5 = var3_3.moveToFirst();
            var6_4 = null;
            if (!var5_5) ** continue;
            var7_6 = var3_3.getString(var3_3.getColumnIndexOrThrow("_data"));
            var3_3.close();
            return var7_6;
            break;
        } while (true);
    }

    private void e() {
        this.p = 960;
        this.q = 960;
        this.t = 100;
        this.n = true;
        this.o = false;
        this.u = 0;
    }

    private boolean f() {
        return this.j.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public Bitmap a(Bitmap bitmap, int n2, int n3) {
        int n4 = bitmap.getHeight();
        int n5 = bitmap.getWidth();
        Bitmap bitmap2 = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, new Rect(0, 0, n5, n4), new Rect(0, 0, n2, n3), paint);
        return bitmap2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public File a(Uri uri) throws Exception {
        File file = new File(this.j.getCacheDir(), "photo-" + uri.getLastPathSegment());
        InputStream inputStream = this.j.getContentResolver().openInputStream(uri);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            int n2;
            byte[] arrby = new byte[4096];
            while ((n2 = inputStream.read(arrby)) != -1) {
                fileOutputStream.write(arrby, 0, n2);
            }
            fileOutputStream.flush();
            return file;
        }
        finally {
            fileOutputStream.close();
            inputStream.close();
        }
    }

    public String a(Bitmap bitmap) {
        return this.a(bitmap, 16);
    }

    /*
     * Enabled aggressive block sorting
     */
    String a(Bitmap bitmap, int n2) {
        Bitmap bitmap2 = this.a(bitmap, n2 + 1, n2);
        int n3 = 0;
        int n4 = 0;
        StringBuilder stringBuilder = new StringBuilder(n2 * n2 / 4);
        int n5 = 0;
        do {
            if (n5 >= n2) {
                bitmap2.recycle();
                return stringBuilder.toString();
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                int n6 = 65280 & bitmap2.getPixel(i2, n5);
                int n7 = (65280 & bitmap2.getPixel(i2 + 1, n5)) > n6 ? 1 : 0;
                n3 = n7 + (n3 << 1);
                if (++n4 != 4) continue;
                stringBuilder.append(i[n3]);
                n3 = 0;
                n4 = 0;
            }
            ++n5;
        } while (true);
    }

    public void a() {
        if (this.a == null) {
            rb.a((Throwable)new Exception("photoPath is NULL"));
            return;
        }
        ie.a().c(this.b, this.a).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData.UploadResponse>(){

            public void a(NetworkData.UploadResponse uploadResponse) {
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                iq.a().a(new ih.ag(null, false, throwable.toString()));
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData.UploadResponse)object);
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a(int var1, int var2_3, Intent var3_2) {
        if (var2_3 != -1) {
            return;
        }
        switch (var1) {
            default: {
                return;
            }
            case 901: {
                var8_4 = this.l;
                ** GOTO lbl17
            }
            case 902: {
                if (this.m != null) {
                    var8_4 = this.m;
                    var9_5 = var3_2.getData();
                    if (var9_5 != null) {
                        var8_4 = var9_5;
                    }
                } else {
                    var8_4 = var3_2.getData();
                }
lbl17: // 3 sources:
                this.a(var8_4, var1);
                return;
            }
            case 903: 
            case 904: 
            case 905: 
        }
        if (!var3_2.getBooleanExtra(ImageCropActivity.USE_FULL_IMAGE, false)) {
            var4_6 = var3_2.getStringExtra(ImageCropActivity.IMAGE_PATH);
            if (var4_6 == null) return;
            var5_7 = Uri.parse((String)var4_6);
            var6_8 = super.b(var5_7);
            if (var6_8 == null) return;
            var7_9 = new BitmapFactory.Options();
            this.f = BitmapFactory.decodeFile((String)var6_8, (BitmapFactory.Options)var7_9);
            super.a(var6_8, var5_7, var7_9.outWidth, var7_9.outHeight);
        }
        iq.a().a(new ih.y());
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2, String[] arrstring, int[] arrn) {
        if (n2 == 1) {
            if (arrn.length <= 0 || arrn[0] != 0 || arrn[1] != 0) return;
            {
                this.b();
                return;
            }
        } else {
            if (n2 != 0 || arrn.length <= 0 || arrn[0] != 0) return;
            {
                this.c();
                return;
            }
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(Uri uri, int n2) {
        String string2 = super.b(uri);
        boolean bl2 = false;
        if (string2 != null) {
            try {
                new URL(string2);
                bl2 = true;
            }
            catch (MalformedURLException var9_7) {
                rb.a((Throwable)var9_7);
                bl2 = false;
            }
        }
        if (string2 == null || bl2) {
            Uri uri2;
            File file = this.a(uri);
            string2 = file.getAbsolutePath();
            uri = uri2 = Uri.fromFile((File)file);
        }
        this.a(string2, uri, n2);
        return;
        catch (Exception exception) {
            Toast.makeText((Context)this.j, (CharSequence)"Could not read photo", (int)1).show();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public void a(String var1, Uri var2_3, int var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 14[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void b() {
        if (bb.checkSelfPermission((Context)this.j, "android.permission.CAMERA") != 0 || bb.checkSelfPermission((Context)this.j, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions((Activity)this.j, (String[])new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, (int)1);
            return;
        }
        if (!this.f()) {
            Toast.makeText((Context)this.j, (CharSequence)"Camera not available", (int)1).show();
            return;
        }
        this.e();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("mime_type", "image/jpg");
        this.l = this.j.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        intent.addFlags(3);
        intent.putExtra("output", (Parcelable)this.l);
        if (this.o.booleanValue()) {
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", this.r);
            intent.putExtra("aspectY", this.s);
        }
        if (intent.resolveActivity(this.j.getPackageManager()) == null) {
            Toast.makeText((Context)this.j, (CharSequence)"Cannot launch camera", (int)1).show();
            return;
        }
        try {
            Log.d((String)"PhotoHelper", (String)("startActivityForResult: camera into file: " + (Object)this.l));
            this.j.startActivityForResult(intent, 901);
            return;
        }
        catch (ActivityNotFoundException var5_3) {
            var5_3.printStackTrace();
            Toast.makeText((Context)this.j, (CharSequence)"Cannot launch camera", (int)1).show();
            return;
        }
    }

    @Override
    public void c() {
        if (bb.checkSelfPermission((Context)this.j, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions((Activity)this.j, (String[])new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, (int)0);
            return;
        }
        this.e();
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        this.m = null;
        if (this.o.booleanValue()) {
            this.m = Uri.fromFile((File)this.a(true));
            intent.putExtra("output", (Parcelable)this.m);
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", this.r);
            intent.putExtra("aspectY", this.s);
        }
        if (intent.resolveActivity(this.j.getPackageManager()) == null) {
            Toast.makeText((Context)this.j, (CharSequence)"Cannot open photo library", (int)1).show();
            return;
        }
        try {
            Log.d((String)"PhotoHelper", (String)"startActivityForResult: library");
            this.j.startActivityForResult(intent, 902);
            return;
        }
        catch (ActivityNotFoundException var2_2) {
            var2_2.printStackTrace();
            Toast.makeText((Context)this.j, (CharSequence)"Cannot open photo library", (int)1).show();
            return;
        }
    }

    public void choosePhoto() {
        this.choosePhoto(false);
    }

    public void choosePhoto(String string2) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.j);
        ChoosePhotoDialogView choosePhotoDialogView = new ChoosePhotoDialogView((Context)this.j);
        choosePhotoDialogView.setQuery(string2);
        choosePhotoDialogView.setDelegate((ChoosePhotoDialogView.a)this);
        builder.setView((View)choosePhotoDialogView);
        this.k = builder.create();
        this.k.setOnCancelListener(new DialogInterface.OnCancelListener(){

            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        this.k.show();
    }

    @Override
    public void choosePhoto(String string2, int n2, int n3) {
        this.f = null;
        Log.d((String)"PhotoHelper", (String)("Got photo: " + string2 + " size: " + n2 + " x " + n3));
        this.b = string2;
        this.d = n2;
        this.e = n3;
        ((BaseActivity)this.j).onPhotoChosen(string2, n2, n3);
    }

    public void choosePhoto(boolean bl2) {
        if (bl2) {
            this.b();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String string2 = this.j.getString(17039360);
        arrayList.add((Object)"Take a Photo");
        arrayList2.add((Object)"photo");
        arrayList.add((Object)"Choose from Photos");
        arrayList2.add((Object)"library");
        arrayList.add((Object)string2);
        arrayList2.add((Object)"cancel");
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context)this.j, 17367057, (List)arrayList);
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.j);
        builder.setAdapter((ListAdapter)arrayAdapter, new DialogInterface.OnClickListener((List)arrayList2){
            final /* synthetic */ List a;

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public void onClick(DialogInterface var1, int var2_2) {
                var3_3 = (String)this.a.get(var2_2);
                var4_4 = -1;
                switch (var3_3.hashCode()) {
                    case 106642994: {
                        if (var3_3.equals((Object)"photo")) {
                            var4_4 = 0;
                            ** break;
                        }
                        ** GOTO lbl12
                    }
                    case 166208699: {
                        if (var3_3.equals((Object)"library")) {
                            var4_4 = 1;
                        }
                    }
lbl12: // 6 sources:
                    default: {
                        ** GOTO lbl17
                    }
                    case -1367724422: 
                }
                if (var3_3.equals((Object)"cancel")) {
                    var4_4 = 2;
                }
lbl17: // 4 sources:
                switch (var4_4) {
                    default: {
                        return;
                    }
                    case 0: {
                        im.this.b();
                        return;
                    }
                    case 1: 
                }
                im.this.c();
            }
        });
        this.k = builder.create();
        this.k.setOnCancelListener(new DialogInterface.OnCancelListener(){

            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        this.k.show();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void clearPhoto() {
        if (this.l == null) {
            return;
        }
        String string2 = this.b(this.l);
        File file = new File(this.b(this.l));
        if (!file.exists()) return;
        if (file.delete()) {
            Log.d((String)"File Deleted", (String)("file Deleted :" + string2));
            return;
        }
        Log.d((String)"File Not Deleted", (String)("file not Deleted :" + string2));
    }

    @Override
    public void d() {
        if (this.k != null) {
            this.k.dismiss();
        }
    }

}

