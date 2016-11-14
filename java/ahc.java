/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 *  android.util.Pair
 *  com.google.android.gms.measurement.AppMeasurement
 *  com.google.android.gms.measurement.internal.AppMetadata
 *  com.google.android.gms.measurement.internal.EventParams
 *  com.google.android.gms.measurement.internal.EventParcel
 *  com.google.android.gms.measurement.internal.UserAttributeParcel
 *  com.google.android.gms.measurement.internal.zzw
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.channels.FileLock
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 */
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ahc {
    private static volatile ahc b;
    private List<Long> A;
    private int B;
    private int C;
    public final ahp a;
    private final Context c;
    private final agj d;
    private final agz e;
    private final agv f;
    private final zzw g;
    private final aga h;
    private final ahb i;
    private final AppMeasurement j;
    private final agg k;
    private final agk l;
    private final agw m;
    private final zf n;
    private final afy o;
    private final agm p;
    private final afx q;
    private final agt r;
    private final agx s;
    private final agd t;
    private final agi u;
    private final boolean v;
    private boolean w;
    private Boolean x;
    private FileLock y;
    private FileChannel z;

    /*
     * Enabled aggressive block sorting
     */
    ahc(afw afw2) {
        xr.a(afw2);
        this.c = afw2.a;
        this.n = afw2.l((ahc)this);
        this.d = afw2.a((ahc)this);
        agz agz2 = afw2.b((ahc)this);
        agz2.d();
        this.e = agz2;
        agv agv2 = afw2.c((ahc)this);
        agv2.d();
        this.f = agv2;
        this.f().C().a("App measurement is starting up, version", this.d().N());
        this.f().C().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        this.f().D().a("Debug logging enabled");
        this.f().D().a("AppMeasurement singleton hash", System.identityHashCode((Object)this));
        this.k = afw2.i((ahc)this);
        agm agm2 = afw2.n((ahc)this);
        agm2.d();
        this.p = agm2;
        agt agt2 = afw2.o((ahc)this);
        agt2.d();
        this.r = agt2;
        agk agk2 = afw2.j((ahc)this);
        agk2.d();
        this.l = agk2;
        agi agi2 = afw2.r((ahc)this);
        agi2.d();
        this.u = agi2;
        agw agw2 = afw2.k((ahc)this);
        agw2.d();
        this.m = agw2;
        afy afy2 = afw2.m((ahc)this);
        afy2.d();
        this.o = afy2;
        afx afx2 = afw2.h((ahc)this);
        afx2.d();
        this.q = afx2;
        agd agd2 = afw2.q((ahc)this);
        agd2.d();
        this.t = agd2;
        this.s = afw2.p((ahc)this);
        this.j = afw2.g((ahc)this);
        this.a = new ahp((ahc)this);
        aga aga2 = afw2.e((ahc)this);
        aga2.d();
        this.h = aga2;
        ahb ahb2 = afw2.f((ahc)this);
        ahb2.d();
        this.i = ahb2;
        zzw zzw2 = afw2.d((ahc)this);
        zzw2.d();
        this.g = zzw2;
        if (this.B != this.C) {
            this.f().f().a("Not all components initialized", this.B, this.C);
        }
        this.v = true;
        if (!this.d.O() && !this.C()) {
            if (this.c.getApplicationContext() instanceof Application) {
                if (Build.VERSION.SDK_INT >= 14) {
                    this.l().f();
                } else {
                    this.f().D().a("Not tracking deep linking pre-ICS");
                }
            } else {
                this.f().z().a("Application context is not an Application");
            }
        }
        this.g.a(new Runnable(){

            public void run() {
                ahc.this.c();
            }
        });
    }

    private boolean L() {
        this.y();
        if (this.A != null) {
            return true;
        }
        return false;
    }

    private boolean M() {
        this.y();
        this.a();
        if (this.o().H() || !TextUtils.isEmpty((CharSequence)this.o().C())) {
            return true;
        }
        return false;
    }

    private void N() {
        this.y();
        this.a();
        if (!this.K()) {
            return;
        }
        if (!this.b() || !this.M()) {
            this.v().b();
            this.w().f();
            return;
        }
        long l2 = this.O();
        if (l2 == 0) {
            this.v().b();
            this.w().f();
            return;
        }
        if (!this.p().f()) {
            this.v().a();
            this.w().f();
            return;
        }
        long l3 = this.e().e.a();
        long l4 = this.d().ab();
        if (!this.n().a(l3, l4)) {
            l2 = Math.max((long)l2, (long)(l3 + l4));
        }
        this.v().b();
        long l5 = l2 - this.r().a();
        if (l5 <= 0) {
            this.w().a(1);
            return;
        }
        this.f().E().a("Upload scheduled in approximately ms", l5);
        this.w().a(l5);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long O() {
        long l2 = this.r().a();
        long l3 = this.d().ae();
        long l4 = this.d().ac();
        long l5 = this.e().c.a();
        long l6 = this.e().d.a();
        long l7 = Math.max((long)this.o().F(), (long)this.o().G());
        if (l7 == 0) {
            return 0;
        }
        long l8 = l2 - Math.abs((long)(l7 - l2));
        long l9 = l2 - Math.abs((long)(l5 - l2));
        long l10 = l2 - Math.abs((long)(l6 - l2));
        long l11 = Math.max((long)l9, (long)l10);
        long l12 = l3 + l8;
        if (!this.n().a(l11, l4)) {
            l12 = l11 + l4;
        }
        if (l10 == 0) return l12;
        if (l10 < l8) return l12;
        int n2 = 0;
        while (n2 < this.d().ag()) {
            if ((l12 += (long)(1 << n2) * this.d().af()) > l10) return l12;
            ++n2;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ahc a(Context context) {
        xr.a(context);
        xr.a(context.getApplicationContext());
        if (b != null) return b;
        reference var4_1 = ahc.class;
        // MONITORENTER : ahc.class
        if (b == null) {
            b = new afw(context).a();
        }
        // MONITOREXIT : var4_1
        return b;
    }

    /*
     * Exception decompiling
     */
    private void a(int var1, Throwable var2_3, byte[] var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredIf.transformStructuredChildren(StructuredIf.java:82)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
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

    private void a(ahe ahe2) {
        if (ahe2 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(List<Long> list) {
        boolean bl2 = !list.isEmpty();
        xr.b(bl2);
        if (this.A != null) {
            this.f().f().a("Set uploading progress before finishing the previous upload");
            return;
        }
        this.A = new ArrayList(list);
    }

    /*
     * Exception decompiling
     */
    private boolean a(String var1, long var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 2[TRYBLOCK]
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

    private abs.a[] a(String string2, abs.g[] arrg, abs.b[] arrb) {
        xr.a(string2);
        return this.x().a(string2, arrb, arrg);
    }

    private void b(afv afv2) {
        if (afv2 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!afv2.a()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(AppMetadata appMetadata) {
        boolean bl2;
        boolean bl3 = true;
        this.y();
        this.a();
        xr.a(appMetadata);
        xr.a(appMetadata.b);
        afu afu2 = this.o().b(appMetadata.b);
        String string2 = this.e().b(appMetadata.b);
        if (afu2 == null) {
            afu afu3 = new afu((ahc)this, appMetadata.b);
            afu3.a(this.e().f());
            afu3.c(string2);
            afu2 = afu3;
            bl2 = bl3;
        } else {
            boolean bl4 = string2.equals((Object)afu2.e());
            bl2 = false;
            if (!bl4) {
                afu2.c(string2);
                afu2.a(this.e().f());
                bl2 = bl3;
            }
        }
        if (!TextUtils.isEmpty((CharSequence)appMetadata.c) && !appMetadata.c.equals((Object)afu2.d())) {
            afu2.b(appMetadata.c);
            bl2 = bl3;
        }
        if (!TextUtils.isEmpty((CharSequence)appMetadata.l) && !appMetadata.l.equals((Object)afu2.f())) {
            afu2.d(appMetadata.l);
            bl2 = bl3;
        }
        if (appMetadata.f != 0 && appMetadata.f != afu2.l()) {
            afu2.d(appMetadata.f);
            bl2 = bl3;
        }
        if (!TextUtils.isEmpty((CharSequence)appMetadata.d) && !appMetadata.d.equals((Object)afu2.i())) {
            afu2.e(appMetadata.d);
            bl2 = bl3;
        }
        if (appMetadata.k != afu2.j()) {
            afu2.c(appMetadata.k);
            bl2 = bl3;
        }
        if (!TextUtils.isEmpty((CharSequence)appMetadata.e) && !appMetadata.e.equals((Object)afu2.k())) {
            afu2.f(appMetadata.e);
            bl2 = bl3;
        }
        if (appMetadata.g != afu2.m()) {
            afu2.e(appMetadata.g);
            bl2 = bl3;
        }
        if (appMetadata.i != afu2.n()) {
            afu2.a(appMetadata.i);
        } else {
            bl3 = bl2;
        }
        if (bl3) {
            this.o().a(afu2);
        }
    }

    void A() {
        this.y();
        this.a();
        if (this.K() && this.B()) {
            this.a(this.a(this.z()), this.u().A());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean B() {
        this.y();
        String string2 = this.l.B();
        File file = new File(this.q().getFilesDir(), string2);
        try {
            this.z = new RandomAccessFile(file, "rw").getChannel();
            this.y = this.z.tryLock();
            if (this.y != null) {
                this.f().E().a("Storage concurrent access okay");
                return true;
            }
            this.f().f().a("Storage concurrent data access panic");
            return false;
        }
        catch (FileNotFoundException var4_3) {
            this.f().f().a("Failed to acquire storage lock", (Object)var4_3);
            return false;
        }
        catch (IOException var3_4) {
            this.f().f().a("Failed to access storage lock file", (Object)var3_4);
            return false;
        }
    }

    protected boolean C() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean D() {
        boolean bl2;
        this.y();
        this.a();
        if (this.d().Q()) {
            return false;
        }
        Boolean bl3 = this.d().R();
        if (bl3 != null) {
            bl2 = bl3;
            return this.e().c(bl2);
        }
        boolean bl4 = this.d().S();
        bl2 = false;
        if (bl4) return this.e().c(bl2);
        bl2 = true;
        return this.e().c(bl2);
    }

    long E() {
        return (this.r().a() + this.e().z()) / 1000 / 60 / 60 / 24;
    }

    void F() {
        if (this.d().O()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    void G() {
        if (!this.d().O()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    /*
     * Exception decompiling
     */
    public void H() {
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

    void I() {
        this.C = 1 + this.C;
    }

    void J() {
        this.y();
        this.a();
        if (!this.w) {
            this.f().C().a("This instance being marked as an uploader");
            this.A();
        }
        this.w = true;
    }

    boolean K() {
        this.y();
        this.a();
        if (this.w || this.C()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    int a(FileChannel fileChannel) {
        this.y();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f().f().a("Bad chanel to read from");
            return 0;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)4);
        try {
            fileChannel.position(0);
            int n2 = fileChannel.read(byteBuffer);
            if (n2 != 4) {
                this.f().z().a("Unexpected data length or empty data in channel. Bytes read", n2);
                return 0;
            }
            byteBuffer.flip();
            return byteBuffer.getInt();
        }
        catch (IOException var3_4) {
            this.f().f().a("Failed to read from channel", (Object)var3_4);
            return 0;
        }
    }

    void a() {
        if (!this.v) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void a(afv afv2) {
        this.B = 1 + this.B;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(agn agn2, AppMetadata appMetadata) {
        long l2;
        this.y();
        this.a();
        xr.a(agn2);
        xr.a(appMetadata);
        xr.a(agn2.a);
        xr.b(agn2.a.equals((Object)appMetadata.b));
        abs.e e2 = new abs.e();
        e2.b = 1;
        e2.j = "android";
        e2.p = appMetadata.b;
        e2.o = appMetadata.e;
        e2.q = appMetadata.d;
        e2.D = (int)appMetadata.k;
        e2.r = appMetadata.f;
        e2.z = appMetadata.c;
        Long l3 = appMetadata.g == 0 ? null : Long.valueOf((long)appMetadata.g);
        e2.w = l3;
        Pair<String, Boolean> pair = this.e().a(appMetadata.b);
        if (pair != null && !TextUtils.isEmpty((CharSequence)((CharSequence)pair.first))) {
            e2.t = (String)pair.first;
            e2.u = (Boolean)pair.second;
        } else if (!this.t().a(this.c)) {
            String string2 = Settings.Secure.getString((ContentResolver)this.c.getContentResolver(), (String)"android_id");
            if (string2 == null) {
                this.f().z().a("null secure ID");
                string2 = "null";
            } else if (string2.isEmpty()) {
                this.f().z().a("empty secure ID");
            }
            e2.G = string2;
        }
        e2.l = this.t().f();
        e2.k = this.t().g();
        e2.n = (int)this.t().z();
        e2.m = this.t().A();
        e2.s = null;
        e2.e = null;
        e2.f = null;
        e2.g = null;
        afu afu2 = this.o().b(appMetadata.b);
        if (afu2 == null) {
            afu2 = new afu((ahc)this, appMetadata.b);
            afu2.a(this.e().f());
            afu2.d(appMetadata.l);
            afu2.b(appMetadata.c);
            afu2.c(this.e().b(appMetadata.b));
            afu2.f(0);
            afu2.a(0);
            afu2.b(0);
            afu2.e(appMetadata.d);
            afu2.c(appMetadata.k);
            afu2.f(appMetadata.e);
            afu2.d(appMetadata.f);
            afu2.e(appMetadata.g);
            afu2.a(appMetadata.i);
            this.o().a(afu2);
        }
        e2.v = afu2.c();
        e2.C = afu2.f();
        List<agf> list = this.o().a(appMetadata.b);
        e2.d = new abs.g[list.size()];
        for (int i2 = 0; i2 < list.size(); ++i2) {
            abs.g g2;
            e2.d[i2] = g2 = new abs.g();
            g2.c = ((agf)list.get((int)i2)).b;
            g2.b = ((agf)list.get((int)i2)).c;
            this.n().a(g2, ((agf)list.get((int)i2)).d);
        }
        try {
            l2 = this.o().b(e2);
        }
        catch (IOException var14_12) {
            this.f().f().a("Data loss. Failed to insert raw event metadata", (Object)var14_12);
            return;
        }
        this.o().a(agn2, l2);
    }

    void a(AppMetadata appMetadata) {
        this.y();
        this.a();
        xr.a(appMetadata.b);
        super.c(appMetadata);
    }

    void a(AppMetadata appMetadata, long l2) {
        afu afu2 = this.o().b(appMetadata.b);
        if (afu2 != null && afu2.d() != null && !afu2.d().equals((Object)appMetadata.c)) {
            this.f().z().a("New GMP App Id passed in. Removing cached database data.");
            this.o().g(afu2.b());
            afu2 = null;
        }
        if (afu2 != null && afu2.i() != null && !afu2.i().equals((Object)appMetadata.d)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", afu2.i());
            this.a(new EventParcel("_au", new EventParams(bundle), "auto", l2), appMetadata);
        }
    }

    /*
     * Exception decompiling
     */
    void a(EventParcel var1, AppMetadata var2_2) {
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
    void a(EventParcel var1, String var2_2) {
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        this.y();
        this.a();
        if (TextUtils.isEmpty((CharSequence)appMetadata.c)) {
            return;
        }
        if (!appMetadata.i) {
            super.c(appMetadata);
            return;
        }
        int n2 = this.n().c(userAttributeParcel.b);
        if (n2 != 0) {
            String string2 = this.n().a(userAttributeParcel.b, this.d().d(), true);
            this.n().a(n2, "_ev", string2);
            return;
        }
        int n3 = this.n().c(userAttributeParcel.b, userAttributeParcel.a());
        if (n3 != 0) {
            String string3 = this.n().a(userAttributeParcel.b, this.d().d(), true);
            this.n().a(n3, "_ev", string3);
            return;
        }
        Object object = this.n().d(userAttributeParcel.b, userAttributeParcel.a());
        if (object == null) return;
        agf agf2 = new agf(appMetadata.b, userAttributeParcel.b, userAttributeParcel.c, object);
        this.f().D().a("Setting user property", agf2.b, object);
        this.o().f();
        try {
            super.c(appMetadata);
            boolean bl2 = this.o().a(agf2);
            this.o().g();
            if (bl2) {
                this.f().D().a("User property set", agf2.b, agf2.d);
                return;
            }
            this.f().f().a("Too many unique user properties are set. Ignoring user property.", agf2.b, agf2.d);
            this.n().a(9, null, null);
            return;
        }
        finally {
            this.o().z();
        }
    }

    /*
     * Exception decompiling
     */
    void a(String var1_4, int var2_5, Throwable var3_2, byte[] var4_3, Map<String, List<String>> var5_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl57 : TryStatement: try { 6[TRYBLOCK]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
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

    public void a(boolean bl2) {
        super.N();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean a(int n2, int n3) {
        this.y();
        if (n2 > n3) {
            this.f().f().a("Panic: can't downgrade version. Previous, current version", n2, n3);
            return false;
        }
        if (n2 >= n3) return true;
        if (this.a(n3, this.z())) {
            this.f().E().a("Storage version upgraded. Previous, current version", n2, n3);
            return true;
        }
        this.f().f().a("Storage version upgrade failed. Previous, current version", n2, n3);
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean a(int n2, FileChannel fileChannel) {
        boolean bl2 = true;
        this.y();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f().f().a("Bad chanel to read from");
            return false;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)4);
        byteBuffer.putInt(n2);
        byteBuffer.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(byteBuffer);
            fileChannel.force(true);
            if (fileChannel.size() == 4) return bl2;
            this.f().f().a("Error writing to channel. Bytes written", fileChannel.size());
            return bl2;
        }
        catch (IOException var7_5) {
            this.f().f().a("Failed to write to channel", (Object)var7_5);
            return false;
        }
    }

    boolean a(long l2) {
        return super.a((String)null, l2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(AppMetadata appMetadata) {
        this.y();
        this.a();
        xr.a(appMetadata);
        xr.a(appMetadata.b);
        if (TextUtils.isEmpty((CharSequence)appMetadata.c)) {
            return;
        }
        if (!appMetadata.i) {
            super.c(appMetadata);
            return;
        }
        long l2 = this.r().a();
        this.o().f();
        try {
            this.a(appMetadata, l2);
            super.c(appMetadata);
            if (this.o().a(appMetadata.b, "_f") == null) {
                this.a(new UserAttributeParcel("_fot", l2, (Object)(3600000 * (1 + l2 / 3600000)), "auto"), appMetadata);
                this.b(appMetadata, l2);
                this.c(appMetadata, l2);
            } else if (appMetadata.j) {
                this.d(appMetadata, l2);
            }
            this.o().g();
            return;
        }
        finally {
            this.o().z();
        }
    }

    void b(AppMetadata appMetadata, long l2) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        this.a(new EventParcel("_f", new EventParams(bundle), "auto", l2), appMetadata);
    }

    void b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        this.y();
        this.a();
        if (TextUtils.isEmpty((CharSequence)appMetadata.c)) {
            return;
        }
        if (!appMetadata.i) {
            super.c(appMetadata);
            return;
        }
        this.f().D().a("Removing user property", userAttributeParcel.b);
        this.o().f();
        try {
            super.c(appMetadata);
            this.o().b(appMetadata.b, userAttributeParcel.b);
            this.o().g();
            this.f().D().a("User property removed", userAttributeParcel.b);
            return;
        }
        finally {
            this.o().z();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected boolean b() {
        this.a();
        this.y();
        if (this.x == null) {
            boolean bl2 = this.n().i("android.permission.INTERNET") && this.n().i("android.permission.ACCESS_NETWORK_STATE") && aha.a(this.q()) && afz.a(this.q());
            this.x = bl2;
            if (this.x.booleanValue() && !this.d().O()) {
                this.x = this.n().f(this.u().g());
            }
        }
        return this.x;
    }

    /*
     * Exception decompiling
     */
    public byte[] b(EventParcel var1, String var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:371)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:449)
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
     */
    protected void c() {
        this.y();
        if (this.C() && (!this.g.a() || this.g.b())) {
            this.f().f().a("Scheduler shutting down before Scion.start() called");
            return;
        }
        this.o().D();
        if (!this.b()) {
            if (this.D()) {
                if (!this.n().i("android.permission.INTERNET")) {
                    this.f().f().a("App is missing INTERNET permission");
                }
                if (!this.n().i("android.permission.ACCESS_NETWORK_STATE")) {
                    this.f().f().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!aha.a(this.q())) {
                    this.f().f().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!afz.a(this.q())) {
                    this.f().f().a("AppMeasurementService not registered/enabled");
                }
                this.f().f().a("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!this.d().O() && !TextUtils.isEmpty((CharSequence)this.u().g())) {
                String string2 = this.e().A();
                if (string2 == null) {
                    this.e().c(this.u().g());
                } else if (!string2.equals((Object)this.u().g())) {
                    this.f().C().a("Rechecking which service to use due to a GMP App Id change");
                    this.e().C();
                    this.o.C();
                    this.o.A();
                    this.e().c(this.u().g());
                }
            }
            if (!(this.d().O() || this.C() || TextUtils.isEmpty((CharSequence)this.u().g()))) {
                this.l().g();
            }
        }
        this.N();
    }

    void c(AppMetadata appMetadata, long l2) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        this.a(new EventParcel("_e", new EventParams(bundle), "auto", l2), appMetadata);
    }

    public agj d() {
        return this.d;
    }

    void d(AppMetadata appMetadata, long l2) {
        this.a(new EventParcel("_cd", new EventParams(new Bundle()), "auto", l2), appMetadata);
    }

    public agz e() {
        this.a((ahe)this.e);
        return this.e;
    }

    public agv f() {
        this.b(this.f);
        return this.f;
    }

    public agv g() {
        if (this.f != null && this.f.a()) {
            return this.f;
        }
        return null;
    }

    public zzw h() {
        this.b((afv)this.g);
        return this.g;
    }

    public aga i() {
        this.b(this.h);
        return this.h;
    }

    public ahb j() {
        this.b(this.i);
        return this.i;
    }

    zzw k() {
        return this.g;
    }

    public afx l() {
        this.b(this.q);
        return this.q;
    }

    public AppMeasurement m() {
        return this.j;
    }

    public agg n() {
        this.a(this.k);
        return this.k;
    }

    public agk o() {
        this.b(this.l);
        return this.l;
    }

    public agw p() {
        this.b(this.m);
        return this.m;
    }

    public Context q() {
        return this.c;
    }

    public zf r() {
        return this.n;
    }

    public afy s() {
        this.b(this.o);
        return this.o;
    }

    public agm t() {
        this.b(this.p);
        return this.p;
    }

    public agt u() {
        this.b(this.r);
        return this.r;
    }

    public agx v() {
        if (this.s == null) {
            throw new IllegalStateException("Network broadcast receiver not created");
        }
        return this.s;
    }

    public agd w() {
        this.b(this.t);
        return this.t;
    }

    public agi x() {
        this.b(this.u);
        return this.u;
    }

    public void y() {
        this.h().j();
    }

    FileChannel z() {
        return this.z;
    }

    class a
    implements agk.b {
        abs.e a;
        List<Long> b;
        List<abs.b> c;
        long d;
        final /* synthetic */ ahc e;

        private a(ahc ahc2) {
            this.e = ahc2;
        }

        /* synthetic */ a(ahc ahc2,  var2_2) {
            super(ahc2);
        }

        private long a(abs.b b2) {
            return b2.d / 1000 / 60 / 60;
        }

        @Override
        public void a(abs.e e2) {
            xr.a(e2);
            this.a = e2;
        }

        boolean a() {
            if (this.c == null || this.c.isEmpty()) {
                return true;
            }
            return false;
        }

        @Override
        public boolean a(long l2, abs.b b2) {
            xr.a(b2);
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (this.c.size() > 0 && super.a((abs.b)this.c.get(0)) != super.a(b2)) {
                return false;
            }
            long l3 = this.d + (long)b2.b();
            if (l3 >= (long)this.e.d().X()) {
                return false;
            }
            this.d = l3;
            this.c.add((Object)b2);
            this.b.add((Object)l2);
            if (this.c.size() >= this.e.d().Y()) {
                return false;
            }
            return true;
        }
    }

}

