/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.CursorWindow
 *  android.database.sqlite.SQLiteCursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Pair
 *  com.google.android.gms.internal.zzamc
 *  com.google.android.gms.measurement.internal.EventParams
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.measurement.internal.EventParams;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class agk
extends afv {
    private static final Map<String, String> a = new dh<String, String>(16);
    private final c b;
    private final agc c;

    static {
        a.put((Object)"app_version", (Object)"ALTER TABLE apps ADD COLUMN app_version TEXT;");
        a.put((Object)"app_store", (Object)"ALTER TABLE apps ADD COLUMN app_store TEXT;");
        a.put((Object)"gmp_version", (Object)"ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        a.put((Object)"dev_cert_hash", (Object)"ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        a.put((Object)"measurement_enabled", (Object)"ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        a.put((Object)"last_bundle_start_timestamp", (Object)"ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        a.put((Object)"day", (Object)"ALTER TABLE apps ADD COLUMN day INTEGER;");
        a.put((Object)"daily_public_events_count", (Object)"ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        a.put((Object)"daily_events_count", (Object)"ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        a.put((Object)"daily_conversions_count", (Object)"ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        a.put((Object)"remote_config", (Object)"ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        a.put((Object)"config_fetched_time", (Object)"ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        a.put((Object)"failed_config_fetch_time", (Object)"ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        a.put((Object)"app_version_int", (Object)"ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        a.put((Object)"firebase_instance_id", (Object)"ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        a.put((Object)"daily_error_events_count", (Object)"ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    agk(ahc ahc2) {
        super(ahc2);
        this.c = new agc(this.p());
        String string2 = this.B();
        this.b = (agk)this.new c(this.q(), string2);
    }

    private boolean J() {
        return this.q().getDatabasePath(this.B()).exists();
    }

    @TargetApi(value=11)
    static int a(Cursor cursor, int n2) {
        int n3;
        if (Build.VERSION.SDK_INT >= 11) {
            return cursor.getType(n2);
        }
        CursorWindow cursorWindow = ((SQLiteCursor)cursor).getWindow();
        if (cursorWindow.isNull(n3 = cursor.getPosition(), n2)) {
            return 0;
        }
        if (cursorWindow.isLong(n3, n2)) {
            return 1;
        }
        if (cursorWindow.isFloat(n3, n2)) {
            return 2;
        }
        if (cursorWindow.isString(n3, n2)) {
            return 3;
        }
        if (cursorWindow.isBlob(n3, n2)) {
            return 4;
        }
        return -1;
    }

    private long a(String string2, String[] arrstring) {
        SQLiteDatabase sQLiteDatabase = this.A();
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery(string2, arrstring);
            if (cursor.moveToFirst()) {
                long l2 = cursor.getLong(0);
                return l2;
            }
            throw new SQLiteException("Database returned empty set");
        }
        catch (SQLiteException var6_6) {
            this.w().f().a("Database error", string2, (Object)var6_6);
            throw var6_6;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /*
     * Exception decompiling
     */
    private long a(String var1, String[] var2_3, long var3_2) {
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

    /*
     * Exception decompiling
     */
    private void a(String var1, abq.a var2_2) {
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

    private boolean a(String string2, int n2, abq.b b2) {
        byte[] arrby;
        this.c();
        this.j();
        xr.a(string2);
        xr.a(b2);
        if (TextUtils.isEmpty((CharSequence)b2.c)) {
            this.w().z().a("Event filter had no event name. Audience definition ignored. audienceId, filterId", n2, String.valueOf((Object)b2.b));
            return false;
        }
        try {
            arrby = new byte[b2.b()];
            zzamc zzamc2 = zzamc.a((byte[])arrby);
            b2.a(zzamc2);
            zzamc2.b();
        }
        catch (IOException var6_7) {
            this.w().f().a("Configuration loss. Failed to serialize event filter", (Object)var6_7);
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string2);
        contentValues.put("audience_id", Integer.valueOf((int)n2));
        contentValues.put("filter_id", b2.b);
        contentValues.put("event_name", b2.c);
        contentValues.put("data", arrby);
        try {
            if (this.A().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                this.w().f().a("Failed to insert event filter (got -1)");
            }
            return true;
        }
        catch (SQLiteException var10_8) {
            this.w().f().a("Error storing event filter", (Object)var10_8);
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(String string2, int n2, abq.e e2) {
        byte[] arrby;
        this.c();
        this.j();
        xr.a(string2);
        xr.a(e2);
        if (TextUtils.isEmpty((CharSequence)e2.c)) {
            this.w().z().a("Property filter had no property name. Audience definition ignored. audienceId, filterId", n2, String.valueOf((Object)e2.b));
            return false;
        }
        try {
            arrby = new byte[e2.b()];
            zzamc zzamc2 = zzamc.a((byte[])arrby);
            e2.a(zzamc2);
            zzamc2.b();
        }
        catch (IOException var6_8) {
            this.w().f().a("Configuration loss. Failed to serialize property filter", (Object)var6_8);
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string2);
        contentValues.put("audience_id", Integer.valueOf((int)n2));
        contentValues.put("filter_id", e2.b);
        contentValues.put("property_name", e2.c);
        contentValues.put("data", arrby);
        try {
            if (this.A().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) return true;
            this.w().f().a("Failed to insert property filter (got -1)");
            return false;
        }
        catch (SQLiteException var10_7) {
            this.w().f().a("Error storing property filter", (Object)var10_7);
            return false;
        }
    }

    SQLiteDatabase A() {
        this.j();
        try {
            SQLiteDatabase sQLiteDatabase = this.b.getWritableDatabase();
            return sQLiteDatabase;
        }
        catch (SQLiteException var1_2) {
            this.w().z().a("Error opening database", (Object)var1_2);
            throw var1_2;
        }
    }

    String B() {
        if (!this.y().O()) {
            return this.y().L();
        }
        if (this.y().P()) {
            return this.y().L();
        }
        this.w().A().a("Using secondary database");
        return this.y().M();
    }

    /*
     * Exception decompiling
     */
    public String C() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 7[UNCONDITIONALDOLOOP]
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

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void D() {
        this.j();
        this.c();
        if (!this.J()) {
            return;
        }
        long l2 = this.x().f.a();
        long l3 = this.p().b();
        if (Math.abs((long)(l3 - l2)) <= this.y().U()) return;
        this.x().f.a(l3);
        this.E();
    }

    /*
     * Enabled aggressive block sorting
     */
    void E() {
        String[] arrstring;
        int n2;
        SQLiteDatabase sQLiteDatabase;
        this.j();
        this.c();
        if (!this.J() || (n2 = (sQLiteDatabase = this.A()).delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", arrstring = new String[]{String.valueOf((long)this.p().a()), String.valueOf((long)this.y().T())})) <= 0) {
            return;
        }
        this.w().E().a("Deleted stale rows. rowsDeleted", n2);
    }

    public long F() {
        return this.a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long G() {
        return this.a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean H() {
        if (this.a("select count(1) > 0 from raw_events", (String[])null) != 0) {
            return true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public a a(long var1_4, String var3_2, boolean var4_3, boolean var5_1, boolean var6_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[CATCHBLOCK]], but top level block is 8[UNCONDITIONALDOLOOP]
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

    /*
     * Exception decompiling
     */
    public ago a(String var1, String var2_2) {
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

    /*
     * Exception decompiling
     */
    public List<agf> a(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 12[SIMPLE_IF_TAKEN]
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

    /*
     * Exception decompiling
     */
    public List<Pair<abs.e, Long>> a(String var1, int var2_3, int var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 4[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    public void a(long l2) {
        this.j();
        this.c();
        SQLiteDatabase sQLiteDatabase = this.A();
        String[] arrstring = new String[]{String.valueOf((long)l2)};
        if (sQLiteDatabase.delete("queue", "rowid=?", arrstring) != 1) {
            this.w().f().a("Deleted fewer rows from queue than expected");
        }
    }

    public void a(abs.e e2) {
        byte[] arrby;
        this.j();
        this.c();
        xr.a(e2);
        xr.a(e2.p);
        xr.a(e2.g);
        this.D();
        long l2 = this.p().a();
        if (e2.g < l2 - this.y().T() || e2.g > l2 + this.y().T()) {
            this.w().z().a("Storing bundle outside of the max uploading time span. now, timestamp", l2, (Object)e2.g);
        }
        try {
            byte[] arrby2 = new byte[e2.b()];
            zzamc zzamc2 = zzamc.a((byte[])arrby2);
            e2.a(zzamc2);
            zzamc2.b();
            arrby = this.s().a(arrby2);
        }
        catch (IOException var7_7) {
            this.w().f().a("Data loss. Failed to serialize bundle", (Object)var7_7);
            return;
        }
        this.w().E().a("Saving bundle, size", arrby.length);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", e2.p);
        contentValues.put("bundle_end_timestamp", e2.g);
        contentValues.put("data", arrby);
        try {
            if (this.A().insert("queue", null, contentValues) == -1) {
                this.w().f().a("Failed to insert bundle (got -1)");
            }
            return;
        }
        catch (SQLiteException var12_8) {
            this.w().f().a("Error storing bundle", (Object)var12_8);
            return;
        }
    }

    public void a(afu afu2) {
        xr.a(afu2);
        this.j();
        this.c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", afu2.b());
        contentValues.put("app_instance_id", afu2.c());
        contentValues.put("gmp_app_id", afu2.d());
        contentValues.put("resettable_device_id_hash", afu2.e());
        contentValues.put("last_bundle_index", Long.valueOf((long)afu2.o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf((long)afu2.g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf((long)afu2.h()));
        contentValues.put("app_version", afu2.i());
        contentValues.put("app_store", afu2.k());
        contentValues.put("gmp_version", Long.valueOf((long)afu2.l()));
        contentValues.put("dev_cert_hash", Long.valueOf((long)afu2.m()));
        contentValues.put("measurement_enabled", Boolean.valueOf((boolean)afu2.n()));
        contentValues.put("day", Long.valueOf((long)afu2.s()));
        contentValues.put("daily_public_events_count", Long.valueOf((long)afu2.t()));
        contentValues.put("daily_events_count", Long.valueOf((long)afu2.u()));
        contentValues.put("daily_conversions_count", Long.valueOf((long)afu2.v()));
        contentValues.put("config_fetched_time", Long.valueOf((long)afu2.p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf((long)afu2.q()));
        contentValues.put("app_version_int", Long.valueOf((long)afu2.j()));
        contentValues.put("firebase_instance_id", afu2.f());
        contentValues.put("daily_error_events_count", Long.valueOf((long)afu2.w()));
        try {
            if (this.A().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.w().f().a("Failed to insert/update app (got -1)");
            }
            return;
        }
        catch (SQLiteException var4_3) {
            this.w().f().a("Error storing app", (Object)var4_3);
            return;
        }
    }

    public void a(agn agn2, long l2) {
        byte[] arrby;
        this.j();
        this.c();
        xr.a(agn2);
        xr.a(agn2.a);
        abs.b b2 = new abs.b();
        b2.e = agn2.e;
        b2.b = new abs.c[agn2.f.a()];
        Iterator iterator = agn2.f.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            abs.c c2 = new abs.c();
            abs.c[] arrc = b2.b;
            int n3 = n2 + 1;
            arrc[n2] = c2;
            c2.b = string2;
            Object object = agn2.f.a(string2);
            this.s().a(c2, object);
            n2 = n3;
        }
        try {
            arrby = new byte[b2.b()];
            zzamc zzamc2 = zzamc.a((byte[])arrby);
            b2.a(zzamc2);
            zzamc2.b();
        }
        catch (IOException var9_14) {
            this.w().f().a("Data loss. Failed to serialize event params/data", (Object)var9_14);
            return;
        }
        this.w().E().a("Saving event, name, data size", agn2.b, arrby.length);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", agn2.a);
        contentValues.put("name", agn2.b);
        contentValues.put("timestamp", Long.valueOf((long)agn2.d));
        contentValues.put("metadata_fingerprint", Long.valueOf((long)l2));
        contentValues.put("data", arrby);
        try {
            if (this.A().insert("raw_events", null, contentValues) == -1) {
                this.w().f().a("Failed to insert raw event (got -1)");
            }
            return;
        }
        catch (SQLiteException var13_15) {
            this.w().f().a("Error storing raw event", (Object)var13_15);
            return;
        }
    }

    public void a(ago ago2) {
        xr.a(ago2);
        this.j();
        this.c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", ago2.a);
        contentValues.put("name", ago2.b);
        contentValues.put("lifetime_count", Long.valueOf((long)ago2.c));
        contentValues.put("current_bundle_count", Long.valueOf((long)ago2.d));
        contentValues.put("last_fire_timestamp", Long.valueOf((long)ago2.e));
        try {
            if (this.A().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.w().f().a("Failed to insert/update event aggregates (got -1)");
            }
            return;
        }
        catch (SQLiteException var4_3) {
            this.w().f().a("Error storing event aggregates", (Object)var4_3);
            return;
        }
    }

    void a(ContentValues contentValues, String string2, Object object) {
        xr.a(string2);
        xr.a(object);
        if (object instanceof String) {
            contentValues.put(string2, (String)object);
            return;
        }
        if (object instanceof Long) {
            contentValues.put(string2, (Long)object);
            return;
        }
        if (object instanceof Double) {
            contentValues.put(string2, (Double)object);
            return;
        }
        throw new IllegalArgumentException("Invalid value type");
    }

    public void a(String string2, int n2) {
        xr.a(string2);
        this.j();
        this.c();
        try {
            SQLiteDatabase sQLiteDatabase = this.A();
            Object[] arrobject = new String[]{string2, string2, String.valueOf((int)n2)};
            sQLiteDatabase.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", arrobject);
            return;
        }
        catch (SQLiteException var4_5) {
            this.w().f().a("Error pruning currencies", string2, (Object)var4_5);
            return;
        }
    }

    void a(String string2, int n2, abs.f f2) {
        byte[] arrby;
        this.c();
        this.j();
        xr.a(string2);
        xr.a(f2);
        try {
            arrby = new byte[f2.b()];
            zzamc zzamc2 = zzamc.a((byte[])arrby);
            f2.a(zzamc2);
            zzamc2.b();
        }
        catch (IOException var6_7) {
            this.w().f().a("Configuration loss. Failed to serialize filter results", (Object)var6_7);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string2);
        contentValues.put("audience_id", Integer.valueOf((int)n2));
        contentValues.put("current_results", arrby);
        try {
            if (this.A().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                this.w().f().a("Failed to insert filter results (got -1)");
            }
            return;
        }
        catch (SQLiteException var10_8) {
            this.w().f().a("Error storing filter results", (Object)var10_8);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public void a(String var1_1, long var2_3, b var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[TRYBLOCK]], but top level block is 26[SIMPLE_IF_TAKEN]
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

    public void a(String string2, byte[] arrby) {
        xr.a(string2);
        this.j();
        this.c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", arrby);
        try {
            if ((long)this.A().update("apps", contentValues, "app_id = ?", new String[]{string2}) == 0) {
                this.w().f().a("Failed to update remote config (got 0)");
            }
            return;
        }
        catch (SQLiteException var5_4) {
            this.w().f().a("Error storing remote config", (Object)var5_4);
            return;
        }
    }

    void a(String string2, abq.a[] arra) {
        this.c();
        this.j();
        xr.a(string2);
        xr.a(arra);
        SQLiteDatabase sQLiteDatabase = this.A();
        sQLiteDatabase.beginTransaction();
        this.e(string2);
        int n2 = arra.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            super.a(string2, arra[i2]);
        }
        try {
            sQLiteDatabase.setTransactionSuccessful();
            return;
        }
        catch (Throwable var6_6) {
            throw var6_6;
        }
        finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void a(List<Long> list) {
        xr.a(list);
        this.j();
        this.c();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (i2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long)list.get(i2)).longValue());
        }
        stringBuilder.append(")");
        int n2 = this.A().delete("raw_events", stringBuilder.toString(), null);
        if (n2 != list.size()) {
            this.w().f().a("Deleted fewer rows from raw events table than expected", n2, list.size());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(agf agf2) {
        xr.a(agf2);
        this.j();
        this.c();
        if (this.c(agf2.a, agf2.b) == null) {
            if (agg.a(agf2.b)) {
                String[] arrstring = new String[]{agf2.a};
                if (super.a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", arrstring) >= (long)this.y().F()) {
                    return false;
                }
            } else {
                String[] arrstring = new String[]{agf2.a};
                if (super.a("select count(1) from user_attributes where app_id=?", arrstring) >= (long)this.y().G()) return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", agf2.a);
        contentValues.put("name", agf2.b);
        contentValues.put("set_timestamp", Long.valueOf((long)agf2.c));
        this.a(contentValues, "value", agf2.d);
        try {
            if (this.A().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) return true;
            this.w().f().a("Failed to insert/update user property (got -1)");
            return true;
        }
        catch (SQLiteException var4_5) {
            this.w().f().a("Error storing user property", (Object)var4_5);
            return true;
        }
    }

    public long b(abs.e e2) throws IOException {
        byte[] arrby;
        this.j();
        this.c();
        xr.a(e2);
        xr.a(e2.p);
        try {
            arrby = new byte[e2.b()];
            zzamc zzamc2 = zzamc.a((byte[])arrby);
            e2.a(zzamc2);
            zzamc2.b();
        }
        catch (IOException var4_6) {
            this.w().f().a("Data loss. Failed to serialize event metadata", (Object)var4_6);
            throw var4_6;
        }
        long l2 = this.s().d(arrby);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", e2.p);
        contentValues.put("metadata_fingerprint", Long.valueOf((long)l2));
        contentValues.put("metadata", arrby);
        try {
            this.A().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return l2;
        }
        catch (SQLiteException var10_7) {
            this.w().f().a("Error storing raw event metadata", (Object)var10_7);
            throw var10_7;
        }
    }

    /*
     * Exception decompiling
     */
    public afu b(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[CATCHBLOCK]
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

    Object b(Cursor cursor, int n2) {
        int n3 = agk.a(cursor, n2);
        switch (n3) {
            default: {
                this.w().f().a("Loaded invalid unknown value type, ignoring it", n3);
                return null;
            }
            case 0: {
                this.w().f().a("Loaded invalid null value from database");
                return null;
            }
            case 1: {
                return cursor.getLong(n2);
            }
            case 2: {
                return cursor.getDouble(n2);
            }
            case 3: {
                return cursor.getString(n2);
            }
            case 4: 
        }
        this.w().f().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /*
     * Exception decompiling
     */
    public String b(long var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[CATCHBLOCK]], but top level block is 8[UNCONDITIONALDOLOOP]
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

    void b(String string2, int n2) {
        this.c();
        this.j();
        xr.a(string2);
        SQLiteDatabase sQLiteDatabase = this.A();
        String[] arrstring = new String[]{string2, String.valueOf((int)n2)};
        sQLiteDatabase.delete("property_filters", "app_id=? and audience_id=?", arrstring);
        String[] arrstring2 = new String[]{string2, String.valueOf((int)n2)};
        sQLiteDatabase.delete("event_filters", "app_id=? and audience_id=?", arrstring2);
    }

    public void b(String string2, String string3) {
        xr.a(string2);
        xr.a(string3);
        this.j();
        this.c();
        try {
            int n2 = this.A().delete("user_attributes", "app_id=? and name=?", new String[]{string2, string3});
            this.w().E().a("Deleted user attribute rows:", n2);
            return;
        }
        catch (SQLiteException var5_4) {
            this.w().f().a("Error deleting user attribute", string2, string3, (Object)var5_4);
            return;
        }
    }

    public long c(String string2) {
        int n2;
        xr.a(string2);
        this.j();
        this.c();
        try {
            n2 = this.A().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{string2, String.valueOf((int)this.y().f(string2))});
        }
        catch (SQLiteException var3_3) {
            this.w().f().a("Error deleting over the limit events", (Object)var3_3);
            return 0;
        }
        return n2;
    }

    /*
     * Exception decompiling
     */
    public agf c(String var1, String var2_2) {
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

    /*
     * Exception decompiling
     */
    Map<Integer, List<abq.b>> d(String var1, String var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 13[SIMPLE_IF_TAKEN]
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

    /*
     * Exception decompiling
     */
    public byte[] d(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[CATCHBLOCK]], but top level block is 8[UNCONDITIONALDOLOOP]
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

    /*
     * Exception decompiling
     */
    Map<Integer, List<abq.e>> e(String var1, String var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 13[SIMPLE_IF_TAKEN]
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
    protected void e() {
    }

    void e(String string2) {
        this.c();
        this.j();
        xr.a(string2);
        SQLiteDatabase sQLiteDatabase = this.A();
        sQLiteDatabase.delete("property_filters", "app_id=?", new String[]{string2});
        sQLiteDatabase.delete("event_filters", "app_id=?", new String[]{string2});
    }

    /*
     * Exception decompiling
     */
    Map<Integer, abs.f> f(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[CATCHBLOCK]
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

    public void f() {
        this.c();
        this.A().beginTransaction();
    }

    public void g() {
        this.c();
        this.A().setTransactionSuccessful();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void g(String string2) {
        int n2;
        this.c();
        this.j();
        xr.a(string2);
        try {
            SQLiteDatabase sQLiteDatabase = this.A();
            String[] arrstring = new String[]{string2};
            n2 = 0 + sQLiteDatabase.delete("events", "app_id=?", arrstring) + sQLiteDatabase.delete("user_attributes", "app_id=?", arrstring) + sQLiteDatabase.delete("apps", "app_id=?", arrstring) + sQLiteDatabase.delete("raw_events", "app_id=?", arrstring) + sQLiteDatabase.delete("raw_events_metadata", "app_id=?", arrstring) + sQLiteDatabase.delete("event_filters", "app_id=?", arrstring) + sQLiteDatabase.delete("property_filters", "app_id=?", arrstring) + sQLiteDatabase.delete("audience_filter_values", "app_id=?", arrstring);
            if (n2 <= 0) return;
        }
        catch (SQLiteException var3_5) {
            this.w().f().a("Error deleting application data. appId, error", string2, (Object)var3_5);
            return;
        }
        this.w().E().a("Deleted application data. app, records", string2, n2);
    }

    public void h(String string2) {
        SQLiteDatabase sQLiteDatabase = this.A();
        try {
            sQLiteDatabase.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", (Object[])new String[]{string2, string2});
            return;
        }
        catch (SQLiteException var3_3) {
            this.w().f().a("Failed to remove unused event metadata", (Object)var3_3);
            return;
        }
    }

    public long i(String string2) {
        xr.a(string2);
        return super.a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{string2}, 0);
    }

    public void z() {
        this.c();
        this.A().endTransaction();
    }

    public static class a {
        long a;
        long b;
        long c;
        long d;
    }

    static interface b {
        public void a(abs.e var1);

        public boolean a(long var1, abs.b var3);
    }

    class c
    extends SQLiteOpenHelper {
        c(Context context, String string2) {
            super(context, string2, null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase, String string2, String string3, String string4, Map<String, String> map) throws SQLiteException {
            if (!this.a(sQLiteDatabase, string2)) {
                sQLiteDatabase.execSQL(string3);
            }
            try {
                this.a(sQLiteDatabase, string2, string4, map);
                return;
            }
            catch (SQLiteException var6_6) {
                agk.this.w().f().a("Failed to verify columns on table that was just created", string2);
                throw var6_6;
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase, String string2, String string3, Map<String, String> map) throws SQLiteException {
            Set<String> set = super.b(sQLiteDatabase, string2);
            for (String string4 : string3.split(",")) {
                if (set.remove((Object)string4)) continue;
                throw new SQLiteException(new StringBuilder(35 + String.valueOf((Object)string2).length() + String.valueOf((Object)string4).length()).append("Table ").append(string2).append(" is missing required column: ").append(string4).toString());
            }
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (set.remove(entry.getKey())) continue;
                    sQLiteDatabase.execSQL((String)entry.getValue());
                }
            }
            if (!set.isEmpty()) {
                throw new SQLiteException(new StringBuilder(30 + String.valueOf((Object)string2).length()).append("Table ").append(string2).append(" table has extra columns").toString());
            }
        }

        /*
         * Unable to fully structure code
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private boolean a(SQLiteDatabase var1, String var2_2) {
            var3_3 = null;
            var6_5 = var7_4 = var1.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{var2_2}, null, null, null);
            try {
                var8_6 = var6_5.moveToFirst();
                if (var6_5 == null) return var8_6;
            }
            catch (SQLiteException var5_9) {
                ** GOTO lbl12
            }
            var6_5.close();
            return var8_6;
            catch (SQLiteException var5_7) {
                var6_5 = null;
lbl12: // 3 sources:
                agk.this.w().z().a("Error querying for table", var2_2, var5_8);
                if (var6_5 == null) return false;
                var6_5.close();
                return false;
            }
            catch (Throwable var4_10) lbl-1000: // 2 sources:
            {
                do {
                    if (var3_3 == null) throw var4_11;
                    var3_3.close();
                    throw var4_11;
                    break;
                } while (true);
            }
            {
                catch (Throwable var4_12) {
                    var3_3 = var6_5;
                    ** continue;
                }
            }
        }

        private Set<String> b(SQLiteDatabase sQLiteDatabase, String string2) {
            HashSet hashSet = new HashSet();
            Cursor cursor = sQLiteDatabase.rawQuery(new StringBuilder(22 + String.valueOf((Object)string2).length()).append("SELECT * FROM ").append(string2).append(" LIMIT 0").toString(), null);
            try {
                Collections.addAll((Collection)hashSet, (Object[])cursor.getColumnNames());
                return hashSet;
            }
            finally {
                cursor.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!agk.this.c.a(agk.this.y().H())) {
                throw new SQLiteException("Database open failed");
            }
            try {
                SQLiteDatabase sQLiteDatabase = super.getWritableDatabase();
                return sQLiteDatabase;
            }
            catch (SQLiteException var1_2) {
                agk.this.c.a();
                agk.this.w().f().a("Opening the database failed, dropping and recreating it");
                String string2 = agk.this.B();
                agk.this.q().getDatabasePath(string2).delete();
                try {
                    SQLiteDatabase sQLiteDatabase = super.getWritableDatabase();
                    agk.this.c.b();
                    return sQLiteDatabase;
                }
                catch (SQLiteException var4_5) {
                    agk.this.w().f().a("Failed to open freshly created database", (Object)var4_5);
                    throw var4_5;
                }
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            if (Build.VERSION.SDK_INT < 15) {
                cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                cursor.moveToFirst();
            }
            super.a(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            super.a(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            super.a(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", a);
            super.a(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
            super.a(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
            super.a(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
            super.a(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
            super.a(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
            super.a(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
            return;
            finally {
                cursor.close();
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        }
    }

}

