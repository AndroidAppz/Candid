package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.a;
import com.facebook.share.widget.ShareDialog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: ShareUtils */
class ir$a extends AsyncTask<String, Void, Bitmap> {
    Context a;
    String b;
    ShareDialog c;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Bitmap) obj);
    }

    public ir$a(Context context, String shareUrl, ShareDialog shareDialog) {
        this.a = context;
        this.b = shareUrl;
        this.c = shareDialog;
    }

    protected Bitmap a(String... params) {
        MalformedURLException e;
        IOException e2;
        try {
            URL url = new URL(params[0]);
            URL url2;
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                url2 = url;
                return BitmapFactory.decodeStream(connection.getInputStream()).copy(Config.ARGB_8888, true);
            } catch (MalformedURLException e3) {
                e = e3;
                url2 = url;
                e.printStackTrace();
                return null;
            } catch (IOException e4) {
                e2 = e4;
                url2 = url;
                e2.printStackTrace();
                return null;
            }
        } catch (MalformedURLException e5) {
            e = e5;
            e.printStackTrace();
            return null;
        } catch (IOException e6) {
            e2 = e6;
            e2.printStackTrace();
            return null;
        }
    }

    protected void a(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.c != null) {
                SharePhotoContent content = new a().a(new SharePhoto.a().a(bitmap).c()).a();
                ShareDialog shareDialog = this.c;
                if (ShareDialog.a(SharePhotoContent.class)) {
                    this.c.b(content);
                    return;
                }
                return;
            }
            Intent tweetIntent = new Intent("android.intent.action.SEND");
            tweetIntent.putExtra("android.intent.extra.TEXT", this.b);
            tweetIntent.setType("text/plain");
            boolean resolved = false;
            for (ResolveInfo resolveInfo : this.a.getPackageManager().queryIntentActivities(tweetIntent, 65536)) {
                if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                    tweetIntent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                    resolved = true;
                    break;
                }
            }
            if (resolved) {
                new View(this.a).draw(new Canvas(bitmap));
                Uri shareUri = Uri.parse(Media.insertImage(this.a.getContentResolver(), bitmap, "Nur", null));
                if (shareUri != null) {
                    tweetIntent.putExtra("android.intent.extra.STREAM", shareUri);
                    tweetIntent.setType("image/*");
                    this.a.startActivity(tweetIntent);
                }
            }
        }
    }
}
