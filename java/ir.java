/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Parcelable
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.util.Log
 *  android.view.View
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.net.HttpURLConnection
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.net.URLEncoder
 *  java.util.Iterator
 *  java.util.List
 */
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public class ir {
    public static int a = 1;
    private static volatile ir b;
    private Context c;
    private String d;
    private Bitmap e;

    private static Intent a(String string2, Intent intent) {
        Intent intent2 = Intent.createChooser((Intent)intent, (CharSequence)string2);
        intent2.setFlags(268435456);
        return intent2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ir a() {
        if (b != null) return b;
        reference var1 = ir.class;
        // MONITORENTER : ir.class
        if (b == null) {
            b = new ir();
        }
        // MONITOREXIT : var1
        return b;
    }

    public static void a(Context context, String string2, String string3) {
        Intent intent = ir.a(string3, ir.b(string2));
        try {
            context.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException var4_4) {
            Log.d((String)"ShareUtils", (String)"Exception loading activity");
            var4_4.printStackTrace();
            return;
        }
    }

    public static void a(Context context, String string2, String string3, ShareDialog shareDialog) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (string3 != null && networkInfo.isConnected()) {
            new a(context, string2, shareDialog).execute((Object[])new String[]{string3});
        }
    }

    private static Intent b(String string2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", string2);
        return intent;
    }

    public static void b(Context context, String string2, String string3) {
        ub ub2 = ub.a.a();
        ShareDialog shareDialog = new ShareDialog((Activity)context);
        shareDialog.a(ub2, new uc<wi.a>(){

            public void a(wi.a a2) {
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException facebookException) {
            }

            @Override
            public /* synthetic */ void onSuccess(Object object) {
                this.a((wi.a)object);
            }
        });
        if (AppState.config.getInt("android_share_post_as_link", 0) == 1) {
            if (ShareDialog.a(ShareLinkContent.class)) {
                shareDialog.b(((ShareLinkContent.a)new ShareLinkContent.a().a(Uri.parse((String)string2))).a());
            }
            return;
        }
        ir.a(context, string2, string3, shareDialog);
    }

    private static String c(String string2) {
        try {
            String string3 = URLEncoder.encode((String)string2, (String)"UTF-8");
            return string3;
        }
        catch (UnsupportedEncodingException var1_2) {
            return "";
        }
    }

    public void a(Context context) {
        this.c = context;
    }

    public void a(Bitmap bitmap) {
        this.e = bitmap;
    }

    public void a(String string2) {
        this.d = string2;
    }

    /*
     * Exception decompiling
     */
    public void b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
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

    static class a
    extends AsyncTask<String, Void, Bitmap> {
        Context a;
        String b;
        ShareDialog c;

        public a(Context context, String string2, ShareDialog shareDialog) {
            this.a = context;
            this.b = string2;
            this.c = shareDialog;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        protected /* varargs */ Bitmap a(String ... var1_1) {
            var2_2 = new URL(var1_1[0]);
            var5_3 = (HttpURLConnection)var2_2.openConnection();
            var5_3.setDoInput(true);
            var5_3.connect();
            return BitmapFactory.decodeStream((InputStream)var5_3.getInputStream()).copy(Bitmap.Config.ARGB_8888, true);
            catch (MalformedURLException var3_5) {}
            ** GOTO lbl-1000
            catch (IOException var4_8) {}
            ** GOTO lbl-1000
            catch (IOException var4_10) {}
lbl-1000: // 2 sources:
            {
                var4_9.printStackTrace();
                return null;
            }
            catch (MalformedURLException var3_7) {}
lbl-1000: // 2 sources:
            {
                var3_6.printStackTrace();
                return null;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        protected void a(Bitmap bitmap) {
            boolean bl2;
            if (bitmap == null) return;
            if (this.c != null) {
                SharePhoto sharePhoto = new SharePhoto.a().a(bitmap).c();
                SharePhotoContent sharePhotoContent = new SharePhotoContent.a().a(sharePhoto).a();
                if (!ShareDialog.a(SharePhotoContent.class)) return;
                {
                    this.c.b(sharePhotoContent);
                    return;
                }
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", this.b);
            intent.setType("text/plain");
            Iterator iterator = this.a.getPackageManager().queryIntentActivities(intent, 65536).iterator();
            do {
                boolean bl3 = iterator.hasNext();
                bl2 = false;
                if (!bl3) return;
                ResolveInfo resolveInfo = (ResolveInfo)iterator.next();
            } while (!resolveInfo.activityInfo.packageName.startsWith("com.twitter.android"));
            intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            bl2 = true;
            if (!bl2) return;
            new View(this.a).draw(new Canvas(bitmap));
            Uri uri = Uri.parse((String)MediaStore.Images.Media.insertImage((ContentResolver)this.a.getContentResolver(), (Bitmap)bitmap, (String)"Nur", (String)null));
            if (uri == null) {
                return;
            }
            intent.putExtra("android.intent.extra.STREAM", (Parcelable)uri);
            intent.setType("image/*");
            this.a.startActivity(intent);
        }

        protected /* synthetic */ Object doInBackground(Object[] arrobject) {
            return this.a((String[])arrobject);
        }

        protected /* synthetic */ void onPostExecute(Object object) {
            this.a((Bitmap)object);
        }
    }

}

