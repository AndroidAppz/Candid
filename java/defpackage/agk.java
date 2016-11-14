package defpackage;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.zzamc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class agk extends afv {
    private static final Map<String, String> a = new dh(16);
    private final agk$c b = new agk$c(this, q(), B());
    private final agc c = new agc(p());

    static {
        a.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        a.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        a.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        a.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        a.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        a.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        a.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        a.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        a.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        a.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        a.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        a.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    agk(ahc ahc) {
        super(ahc);
    }

    private boolean J() {
        return q().getDatabasePath(B()).exists();
    }

    @TargetApi(11)
    static int a(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            w().f().a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            w().f().a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void a(String str, abq$a abq_a) {
        Object obj = null;
        c();
        j();
        xr.a(str);
        xr.a((Object) abq_a);
        xr.a(abq_a.d);
        xr.a(abq_a.c);
        if (abq_a.b == null) {
            w().z().a("Audience with no ID");
            return;
        }
        int intValue = abq_a.b.intValue();
        for (abq$b abq_b : abq_a.d) {
            if (abq_b.b == null) {
                w().z().a("Event filter with no ID. Audience definition ignored. appId, audienceId", str, abq_a.b);
                return;
            }
        }
        for (abq$e abq_e : abq_a.c) {
            if (abq_e.b == null) {
                w().z().a("Property filter with no ID. Audience definition ignored. appId, audienceId", str, abq_a.b);
                return;
            }
        }
        Object obj2 = 1;
        for (abq$b a : abq_a.d) {
            if (!a(str, intValue, a)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (abq$e a2 : abq_a.c) {
                if (!a(str, intValue, a2)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            b(str, intValue);
        }
    }

    private boolean a(String str, int i, abq$b abq_b) {
        c();
        j();
        xr.a(str);
        xr.a((Object) abq_b);
        if (TextUtils.isEmpty(abq_b.c)) {
            w().z().a("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(abq_b.b));
            return false;
        }
        try {
            byte[] bArr = new byte[abq_b.b()];
            zzamc a = zzamc.a(bArr);
            abq_b.a(a);
            a.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", abq_b.b);
            contentValues.put("event_name", abq_b.c);
            contentValues.put("data", bArr);
            try {
                if (A().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    w().f().a("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                w().f().a("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            w().f().a("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    private boolean a(String str, int i, abq$e abq_e) {
        c();
        j();
        xr.a(str);
        xr.a((Object) abq_e);
        if (TextUtils.isEmpty(abq_e.c)) {
            w().z().a("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(abq_e.b));
            return false;
        }
        try {
            byte[] bArr = new byte[abq_e.b()];
            zzamc a = zzamc.a(bArr);
            abq_e.a(a);
            a.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", abq_e.b);
            contentValues.put("property_name", abq_e.c);
            contentValues.put("data", bArr);
            try {
                if (A().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                w().f().a("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                w().f().a("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            w().f().a("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    SQLiteDatabase A() {
        j();
        try {
            return this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            w().z().a("Error opening database", e);
            throw e;
        }
    }

    String B() {
        if (!y().O()) {
            return y().L();
        }
        if (y().P()) {
            return y().L();
        }
        w().A().a("Using secondary database");
        return y().M();
    }

    public String C() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = A().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            w().f().a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void D() {
        j();
        c();
        if (J()) {
            long a = x().f.a();
            long b = p().b();
            if (Math.abs(b - a) > y().U()) {
                x().f.a(b);
                E();
            }
        }
    }

    void E() {
        j();
        c();
        if (J()) {
            int delete = A().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(p().a()), String.valueOf(y().T())});
            if (delete > 0) {
                w().E().a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public long F() {
        return a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long G() {
        return a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean H() {
        return a("select count(1) > 0 from raw_events", null) != 0;
    }

    public agk$a a(long j, String str, boolean z, boolean z2, boolean z3) {
        Object e;
        Throwable th;
        xr.a(str);
        j();
        c();
        String[] strArr = new String[]{str};
        agk$a agk_a = new agk$a();
        Cursor query;
        try {
            SQLiteDatabase A = A();
            query = A.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        agk_a.b = query.getLong(1);
                        agk_a.a = query.getLong(2);
                        agk_a.c = query.getLong(3);
                        agk_a.d = query.getLong(4);
                    }
                    agk_a.b++;
                    if (z) {
                        agk_a.a++;
                    }
                    if (z2) {
                        agk_a.c++;
                    }
                    if (z3) {
                        agk_a.d++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(agk_a.a));
                    contentValues.put("daily_events_count", Long.valueOf(agk_a.b));
                    contentValues.put("daily_conversions_count", Long.valueOf(agk_a.c));
                    contentValues.put("daily_error_events_count", Long.valueOf(agk_a.d));
                    A.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return agk_a;
                }
                w().z().a("Not updating daily counts, app is not known", str);
                if (query != null) {
                    query.close();
                }
                return agk_a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Error updating daily counts", e);
                    if (query != null) {
                        query.close();
                    }
                    return agk_a;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            w().f().a("Error updating daily counts", e);
            if (query != null) {
                query.close();
            }
            return agk_a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public ago a(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        xr.a(str);
        xr.a(str2);
        j();
        c();
        try {
            Cursor query = A().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    ago ago = new ago(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        w().f().a("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return ago;
                    }
                    query.close();
                    return ago;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    w().f().a("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            w().f().a("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<agf> a(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        xr.a(str);
        j();
        c();
        List<agf> arrayList = new ArrayList();
        try {
            Cursor query = A().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(y().G()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object b = b(query, 2);
                        if (b == null) {
                            w().f().a("Read invalid user property value, ignoring it");
                        } else {
                            arrayList.add(new agf(str, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                w().f().a("Error querying user properties", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<Pair<abs$e, Long>> a(String str, int i, int i2) {
        Cursor query;
        List<Pair<abs$e, Long>> emptyList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        j();
        c();
        xr.b(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        xr.b(z);
        xr.a(str);
        try {
            query = A().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    List<Pair<abs$e, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] b = s().b(query.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            aak a = aak.a(b);
                            abs$e abs_e = new abs$e();
                            try {
                                abs$e abs_e2 = (abs$e) abs_e.a(a);
                                length = b.length + i3;
                                arrayList.add(Pair.create(abs_e, Long.valueOf(j)));
                            } catch (IOException e2) {
                                w().f().a("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            w().f().a("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                emptyList = Collections.emptyList();
                if (query == null) {
                    return emptyList;
                }
                query.close();
                return emptyList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                w().f().a("Error querying bundles", str, e);
                emptyList = Collections.emptyList();
                if (cursor == null) {
                    return emptyList;
                }
                cursor.close();
                return emptyList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void a(long j) {
        j();
        c();
        if (A().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            w().f().a("Deleted fewer rows from queue than expected");
        }
    }

    public void a(abs$e abs_e) {
        j();
        c();
        xr.a((Object) abs_e);
        xr.a(abs_e.p);
        xr.a(abs_e.g);
        D();
        long a = p().a();
        if (abs_e.g.longValue() < a - y().T() || abs_e.g.longValue() > y().T() + a) {
            w().z().a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(a), abs_e.g);
        }
        try {
            byte[] bArr = new byte[abs_e.b()];
            zzamc a2 = zzamc.a(bArr);
            abs_e.a(a2);
            a2.b();
            bArr = s().a(bArr);
            w().E().a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", abs_e.p);
            contentValues.put("bundle_end_timestamp", abs_e.g);
            contentValues.put("data", bArr);
            try {
                if (A().insert("queue", null, contentValues) == -1) {
                    w().f().a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                w().f().a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            w().f().a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void a(afu afu) {
        xr.a((Object) afu);
        j();
        c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", afu.b());
        contentValues.put("app_instance_id", afu.c());
        contentValues.put("gmp_app_id", afu.d());
        contentValues.put("resettable_device_id_hash", afu.e());
        contentValues.put("last_bundle_index", Long.valueOf(afu.o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(afu.g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(afu.h()));
        contentValues.put("app_version", afu.i());
        contentValues.put("app_store", afu.k());
        contentValues.put("gmp_version", Long.valueOf(afu.l()));
        contentValues.put("dev_cert_hash", Long.valueOf(afu.m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(afu.n()));
        contentValues.put("day", Long.valueOf(afu.s()));
        contentValues.put("daily_public_events_count", Long.valueOf(afu.t()));
        contentValues.put("daily_events_count", Long.valueOf(afu.u()));
        contentValues.put("daily_conversions_count", Long.valueOf(afu.v()));
        contentValues.put("config_fetched_time", Long.valueOf(afu.p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(afu.q()));
        contentValues.put("app_version_int", Long.valueOf(afu.j()));
        contentValues.put("firebase_instance_id", afu.f());
        contentValues.put("daily_error_events_count", Long.valueOf(afu.w()));
        try {
            if (A().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                w().f().a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            w().f().a("Error storing app", e);
        }
    }

    public void a(agn agn, long j) {
        j();
        c();
        xr.a((Object) agn);
        xr.a(agn.a);
        abs$b abs_b = new abs$b();
        abs_b.e = Long.valueOf(agn.e);
        abs_b.b = new abs$c[agn.f.a()];
        Iterator it = agn.f.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            abs$c abs_c = new abs$c();
            int i2 = i + 1;
            abs_b.b[i] = abs_c;
            abs_c.b = str;
            s().a(abs_c, agn.f.a(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[abs_b.b()];
            zzamc a = zzamc.a(bArr);
            abs_b.a(a);
            a.b();
            w().E().a("Saving event, name, data size", agn.b, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", agn.a);
            contentValues.put("name", agn.b);
            contentValues.put("timestamp", Long.valueOf(agn.d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (A().insert("raw_events", null, contentValues) == -1) {
                    w().f().a("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                w().f().a("Error storing raw event", e);
            }
        } catch (IOException e2) {
            w().f().a("Data loss. Failed to serialize event params/data", e2);
        }
    }

    public void a(ago ago) {
        xr.a((Object) ago);
        j();
        c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", ago.a);
        contentValues.put("name", ago.b);
        contentValues.put("lifetime_count", Long.valueOf(ago.c));
        contentValues.put("current_bundle_count", Long.valueOf(ago.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(ago.e));
        try {
            if (A().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                w().f().a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            w().f().a("Error storing event aggregates", e);
        }
    }

    void a(ContentValues contentValues, String str, Object obj) {
        xr.a(str);
        xr.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void a(String str, int i) {
        xr.a(str);
        j();
        c();
        try {
            A().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            w().f().a("Error pruning currencies", str, e);
        }
    }

    void a(String str, int i, abs$f abs_f) {
        c();
        j();
        xr.a(str);
        xr.a((Object) abs_f);
        try {
            byte[] bArr = new byte[abs_f.b()];
            zzamc a = zzamc.a(bArr);
            abs_f.a(a);
            a.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (A().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    w().f().a("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                w().f().a("Error storing filter results", e);
            }
        } catch (IOException e2) {
            w().f().a("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    public void a(String str, long j, agk$b agk_b) {
        Object string;
        Cursor cursor;
        Object e;
        Throwable th;
        Cursor cursor2 = null;
        xr.a((Object) agk_b);
        j();
        c();
        try {
            String str2;
            SQLiteDatabase A = A();
            String string2;
            if (TextUtils.isEmpty(str)) {
                cursor2 = A.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (cursor2.moveToFirst()) {
                    string = cursor2.getString(0);
                    string2 = cursor2.getString(1);
                    cursor2.close();
                    str2 = string2;
                    cursor = cursor2;
                } else if (cursor2 != null) {
                    cursor2.close();
                    return;
                } else {
                    return;
                }
            }
            cursor2 = A.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
            if (cursor2.moveToFirst()) {
                string2 = cursor2.getString(0);
                cursor2.close();
                str2 = string2;
                cursor = cursor2;
            } else if (cursor2 != null) {
                cursor2.close();
                return;
            } else {
                return;
            }
            try {
                cursor = A.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", "2");
                if (cursor.moveToFirst()) {
                    aak a = aak.a(cursor.getBlob(0));
                    abs$e abs_e = new abs$e();
                    try {
                        abs$e abs_e2 = (abs$e) abs_e.a(a);
                        if (cursor.moveToNext()) {
                            w().z().a("Get multiple raw event metadata records, expected one");
                        }
                        cursor.close();
                        agk_b.a(abs_e);
                        cursor2 = A.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", null);
                        if (cursor2.moveToFirst()) {
                            do {
                                try {
                                    long j2 = cursor2.getLong(0);
                                    aak a2 = aak.a(cursor2.getBlob(3));
                                    abs$b abs_b = new abs$b();
                                    try {
                                        abs$b abs_b2 = (abs$b) abs_b.a(a2);
                                        abs_b.c = cursor2.getString(1);
                                        abs_b.d = Long.valueOf(cursor2.getLong(2));
                                        if (!agk_b.a(j2, abs_b)) {
                                            if (cursor2 != null) {
                                                cursor2.close();
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (IOException e2) {
                                        w().f().a("Data loss. Failed to merge raw event", string, e2);
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                }
                            } while (cursor2.moveToNext());
                            if (cursor2 != null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                        w().z().a("Raw event data disappeared while in transaction");
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (IOException e22) {
                        w().f().a("Data loss. Failed to merge raw event metadata", string, e22);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                w().f().a("Raw event metadata record is missing");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor2 = cursor;
                try {
                    w().f().a("Data loss. Error selecting raw event", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e32) {
            e = e32;
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void a(String str, byte[] bArr) {
        xr.a(str);
        j();
        c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) A().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                w().f().a("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            w().f().a("Error storing remote config", e);
        }
    }

    void a(String str, abq$a[] abq_aArr) {
        c();
        j();
        xr.a(str);
        xr.a((Object) abq_aArr);
        SQLiteDatabase A = A();
        A.beginTransaction();
        try {
            e(str);
            for (abq$a a : abq_aArr) {
                a(str, a);
            }
            A.setTransactionSuccessful();
        } finally {
            A.endTransaction();
        }
    }

    public void a(List<Long> list) {
        xr.a((Object) list);
        j();
        c();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = A().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            w().f().a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public boolean a(agf agf) {
        xr.a((Object) agf);
        j();
        c();
        if (c(agf.a, agf.b) == null) {
            if (agg.a(agf.b)) {
                if (a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{agf.a}) >= ((long) y().F())) {
                    return false;
                }
            }
            if (a("select count(1) from user_attributes where app_id=?", new String[]{agf.a}) >= ((long) y().G())) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", agf.a);
        contentValues.put("name", agf.b);
        contentValues.put("set_timestamp", Long.valueOf(agf.c));
        a(contentValues, "value", agf.d);
        try {
            if (A().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                w().f().a("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            w().f().a("Error storing user property", e);
        }
        return true;
    }

    public long b(abs$e abs_e) throws IOException {
        j();
        c();
        xr.a((Object) abs_e);
        xr.a(abs_e.p);
        try {
            byte[] bArr = new byte[abs_e.b()];
            zzamc a = zzamc.a(bArr);
            abs_e.a(a);
            a.b();
            long d = s().d(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", abs_e.p);
            contentValues.put("metadata_fingerprint", Long.valueOf(d));
            contentValues.put("metadata", bArr);
            try {
                A().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return d;
            } catch (SQLiteException e) {
                w().f().a("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            w().f().a("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    public afu b(String str) {
        Object e;
        Throwable th;
        xr.a(str);
        j();
        c();
        Cursor query;
        try {
            query = A().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    afu afu = new afu(this.n, str);
                    afu.a(query.getString(0));
                    afu.b(query.getString(1));
                    afu.c(query.getString(2));
                    afu.f(query.getLong(3));
                    afu.a(query.getLong(4));
                    afu.b(query.getLong(5));
                    afu.e(query.getString(6));
                    afu.f(query.getString(7));
                    afu.d(query.getLong(8));
                    afu.e(query.getLong(9));
                    afu.a((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    afu.i(query.getLong(11));
                    afu.j(query.getLong(12));
                    afu.k(query.getLong(13));
                    afu.l(query.getLong(14));
                    afu.g(query.getLong(15));
                    afu.h(query.getLong(16));
                    afu.c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    afu.d(query.getString(18));
                    afu.m(query.getLong(19));
                    afu.a();
                    if (query.moveToNext()) {
                        w().f().a("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return afu;
                    }
                    query.close();
                    return afu;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Error querying app", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            w().f().a("Error querying app", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Object b(Cursor cursor, int i) {
        int a = agk.a(cursor, i);
        switch (a) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                w().f().a("Loaded invalid null value from database");
                return null;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return Long.valueOf(cursor.getLong(i));
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return Double.valueOf(cursor.getDouble(i));
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return cursor.getString(i);
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                w().f().a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                w().f().a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    public String b(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        j();
        c();
        try {
            rawQuery = A().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    w().E().a("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            w().f().a("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void b(String str, int i) {
        c();
        j();
        xr.a(str);
        SQLiteDatabase A = A();
        A.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        A.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    public void b(String str, String str2) {
        xr.a(str);
        xr.a(str2);
        j();
        c();
        try {
            w().E().a("Deleted user attribute rows:", Integer.valueOf(A().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            w().f().a("Error deleting user attribute", str, str2, e);
        }
    }

    public long c(String str) {
        xr.a(str);
        j();
        c();
        try {
            SQLiteDatabase A = A();
            String valueOf = String.valueOf(y().f(str));
            return (long) A.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            w().f().a("Error deleting over the limit events", e);
            return 0;
        }
    }

    public agf c(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        xr.a(str);
        xr.a(str2);
        j();
        c();
        try {
            Cursor query = A().query("user_attributes", new String[]{"set_timestamp", "value"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    agf agf = new agf(str, str2, query.getLong(0), b(query, 1));
                    if (query.moveToNext()) {
                        w().f().a("Got multiple records for user property, expected one");
                    }
                    if (query == null) {
                        return agf;
                    }
                    query.close();
                    return agf;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    w().f().a("Error querying user property", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            w().f().a("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    Map<Integer, List<abq$b>> d(String str, String str2) {
        Object e;
        Throwable th;
        c();
        j();
        xr.a(str);
        xr.a(str2);
        Map<Integer, List<abq$b>> dhVar = new dh();
        Cursor query;
        try {
            query = A().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    aak a = aak.a(query.getBlob(1));
                    abq$b abq_b = new abq$b();
                    try {
                        abq$b abq_b2 = (abq$b) abq_b.a(a);
                        try {
                            int i = query.getInt(0);
                            List list = (List) dhVar.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                dhVar.put(Integer.valueOf(i), list);
                            }
                            list.add(abq_b);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        w().f().a("Failed to merge filter", str, e3);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return dhVar;
            }
            Map<Integer, List<abq$b>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                w().f().a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public byte[] d(String str) {
        Cursor query;
        Object e;
        Throwable th;
        xr.a(str);
        j();
        c();
        try {
            query = A().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        w().f().a("Got multiple records for app config, expected one");
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Error querying remote config", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            w().f().a("Error querying remote config", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Map<Integer, List<abq$e>> e(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        c();
        j();
        xr.a(str);
        xr.a(str2);
        Map<Integer, List<abq$e>> dhVar = new dh();
        try {
            query = A().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    aak a = aak.a(query.getBlob(1));
                    abq$e abq_e = new abq$e();
                    try {
                        abq$e abq_e2 = (abq$e) abq_e.a(a);
                        try {
                            int i = query.getInt(0);
                            List list = (List) dhVar.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                dhVar.put(Integer.valueOf(i), list);
                            }
                            list.add(abq_e);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        w().f().a("Failed to merge filter", str, e3);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return dhVar;
            }
            Map<Integer, List<abq$e>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                w().f().a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected void e() {
    }

    void e(String str) {
        c();
        j();
        xr.a(str);
        SQLiteDatabase A = A();
        A.delete("property_filters", "app_id=?", new String[]{str});
        A.delete("event_filters", "app_id=?", new String[]{str});
    }

    Map<Integer, abs$f> f(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        c();
        j();
        xr.a(str);
        Cursor query;
        try {
            query = A().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Map<Integer, abs$f> dhVar = new dh();
                    do {
                        int i = query.getInt(0);
                        aak a = aak.a(query.getBlob(1));
                        abs$f abs_f = new abs$f();
                        try {
                            abs$f abs_f2 = (abs$f) abs_f.a(a);
                            dhVar.put(Integer.valueOf(i), abs_f);
                        } catch (IOException e2) {
                            w().f().a("Failed to merge filter results. appId, audienceId, error", str, Integer.valueOf(i), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return dhVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                w().f().a("Database error querying filter results", e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void f() {
        c();
        A().beginTransaction();
    }

    public void g() {
        c();
        A().setTransactionSuccessful();
    }

    void g(String str) {
        c();
        j();
        xr.a(str);
        try {
            SQLiteDatabase A = A();
            String[] strArr = new String[]{str};
            int delete = A.delete("audience_filter_values", "app_id=?", strArr) + (((((((A.delete("events", "app_id=?", strArr) + 0) + A.delete("user_attributes", "app_id=?", strArr)) + A.delete("apps", "app_id=?", strArr)) + A.delete("raw_events", "app_id=?", strArr)) + A.delete("raw_events_metadata", "app_id=?", strArr)) + A.delete("event_filters", "app_id=?", strArr)) + A.delete("property_filters", "app_id=?", strArr));
            if (delete > 0) {
                w().E().a("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            w().f().a("Error deleting application data. appId, error", str, e);
        }
    }

    public void h(String str) {
        try {
            A().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            w().f().a("Failed to remove unused event metadata", e);
        }
    }

    public long i(String str) {
        xr.a(str);
        return a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public void z() {
        c();
        A().endTransaction();
    }
}
