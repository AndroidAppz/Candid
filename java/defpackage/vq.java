package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* compiled from: NativeAppCallAttachmentStore */
public final class vq {
    private static final String a = vq.class.getName();
    private static File b;

    private vq() {
    }

    public static vq$a a(UUID callId, Bitmap attachmentBitmap) {
        vx.a((Object) callId, "callId");
        vx.a((Object) attachmentBitmap, "attachmentBitmap");
        return new vq$a(callId, attachmentBitmap, null, null);
    }

    public static vq$a a(UUID callId, Uri attachmentUri) {
        vx.a((Object) callId, "callId");
        vx.a((Object) attachmentUri, "attachmentUri");
        return new vq$a(callId, null, attachmentUri, null);
    }

    private static void a(Bitmap bitmap, File outputFile) throws IOException {
        Closeable outputStream = new FileOutputStream(outputFile);
        try {
            bitmap.compress(CompressFormat.JPEG, 100, outputStream);
        } finally {
            vw.a(outputStream);
        }
    }

    private static void a(Uri imageUri, boolean isContentUri, File outputFile) throws IOException {
        InputStream inputStream;
        Closeable outputStream = new FileOutputStream(outputFile);
        if (isContentUri) {
            inputStream = ud.f().getContentResolver().openInputStream(imageUri);
        } else {
            try {
                inputStream = new FileInputStream(imageUri.getPath());
            } catch (Throwable th) {
                vw.a(outputStream);
            }
        }
        vw.a(inputStream, (OutputStream) outputStream);
        vw.a(outputStream);
    }

    public static void a(Collection<vq$a> attachments) {
        if (attachments != null && attachments.size() != 0) {
            if (b == null) {
                vq.c();
            }
            vq.b();
            List<File> filesToCleanup = new ArrayList();
            File file;
            try {
                for (vq$a attachment : attachments) {
                    if (attachment.g) {
                        file = vq.a(attachment.a, attachment.c, true);
                        filesToCleanup.add(file);
                        if (attachment.d != null) {
                            vq.a(attachment.d, file);
                        } else if (attachment.e != null) {
                            vq.a(attachment.e, attachment.f, file);
                        }
                    }
                }
            } catch (Throwable exception) {
                Log.e(a, "Got unexpected exception:" + exception);
                for (File file2 : filesToCleanup) {
                    try {
                        file2.delete();
                    } catch (Exception e) {
                    }
                }
                throw new FacebookException(exception);
            }
        }
    }

    public static void a(UUID callId) {
        File dir = vq.a(callId, false);
        if (dir != null) {
            vw.a(dir);
        }
    }

    public static File a(UUID callId, String attachmentName) throws FileNotFoundException {
        if (vw.a(attachmentName) || callId == null) {
            throw new FileNotFoundException();
        }
        try {
            return vq.a(callId, attachmentName, false);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    static synchronized File a() {
        File file;
        synchronized (vq.class) {
            if (b == null) {
                b = new File(ud.f().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            file = b;
        }
        return file;
    }

    static File b() {
        File dir = vq.a();
        dir.mkdirs();
        return dir;
    }

    static File a(UUID callId, boolean create) {
        if (b == null) {
            return null;
        }
        File dir = new File(b, callId.toString());
        if (!create || dir.exists()) {
            return dir;
        }
        dir.mkdirs();
        return dir;
    }

    static File a(UUID callId, String attachmentName, boolean createDirs) throws IOException {
        File dir = vq.a(callId, createDirs);
        if (dir == null) {
            return null;
        }
        try {
            return new File(dir, URLEncoder.encode(attachmentName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static void c() {
        vw.a(vq.a());
    }
}
