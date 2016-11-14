package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* compiled from: FabricContext */
class akq extends ContextWrapper {
    private final String a;
    private final String b;

    public akq(Context base, String componentName, String componentPath) {
        super(base);
        this.b = componentName;
        this.a = componentPath;
    }

    public File getDatabasePath(String name) {
        File dir = new File(super.getDatabasePath(name).getParentFile(), this.a);
        dir.mkdirs();
        return new File(dir, name);
    }

    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);
    }

    @TargetApi(11)
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name).getPath(), factory, errorHandler);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.a);
    }

    @TargetApi(8)
    public File getExternalFilesDir(String type) {
        return new File(super.getExternalFilesDir(type), this.a);
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.a);
    }

    @TargetApi(8)
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.a);
    }

    public SharedPreferences getSharedPreferences(String name, int mode) {
        return super.getSharedPreferences(this.b + ":" + name, mode);
    }
}
