package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import defpackage.vq;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider extends ContentProvider {
    private static final String a = FacebookContentProvider.class.getName();

    public static String a(String applicationId, UUID callId, String attachmentName) {
        return String.format("%s%s/%s/%s", new Object[]{"content://com.facebook.app.FacebookContentProvider", applicationId, callId.toString(), attachmentName});
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        Pair<UUID, String> callIdAndAttachmentName = a(uri);
        if (callIdAndAttachmentName == null) {
            throw new FileNotFoundException();
        }
        try {
            return ParcelFileDescriptor.open(vq.a((UUID) callIdAndAttachmentName.first, (String) callIdAndAttachmentName.second), 268435456);
        } catch (FileNotFoundException exception) {
            Log.e(a, "Got unexpected exception:" + exception);
            throw exception;
        }
    }

    Pair<UUID, String> a(Uri uri) {
        try {
            String[] parts = uri.getPath().substring(1).split("/");
            String callIdString = parts[0];
            return new Pair(UUID.fromString(callIdString), parts[1]);
        } catch (Exception e) {
            return null;
        }
    }
}
