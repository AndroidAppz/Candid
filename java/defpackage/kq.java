package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher */
public abstract class kq<T> implements km<T> {
    private final Uri a;
    private final Context b;
    private T c;

    protected abstract void a(T t) throws IOException;

    protected abstract T b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public kq(Context context, Uri uri) {
        this.b = context.getApplicationContext();
        this.a = uri;
    }

    public final T b(Priority priority) throws Exception {
        this.c = b(this.a, this.b.getContentResolver());
        return this.c;
    }

    public void a() {
        if (this.c != null) {
            try {
                a(this.c);
            } catch (IOException e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    public void c() {
    }

    public String b() {
        return this.a.toString();
    }
}
