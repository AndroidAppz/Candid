/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.settings.SettingsCacheBehavior
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import org.json.JSONException;
import org.json.JSONObject;

class anl
implements ant {
    private final anx a;
    private final anw b;
    private final alm c;
    private final ani d;
    private final any e;
    private final aku f;
    private final ana g;

    public anl(aku aku2, anx anx2, alm alm2, anw anw2, ani ani2, any any2) {
        this.f = aku2;
        this.a = anx2;
        this.c = alm2;
        this.b = anw2;
        this.d = ani2;
        this.e = any2;
        this.g = new anb(this.f);
    }

    private void a(JSONObject jSONObject, String string2) throws JSONException {
        akp.h().a("Fabric", string2 + jSONObject.toString());
    }

    /*
     * Exception decompiling
     */
    private anu b(SettingsCacheBehavior var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl24 : TryStatement: try { 1[TRYBLOCK]

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

    @Override
    public anu a() {
        return this.a(SettingsCacheBehavior.a);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    @Override
    public anu a(SettingsCacheBehavior settingsCacheBehavior) {
        anu anu2 = null;
        try {
            JSONObject jSONObject;
            boolean bl2 = akp.i();
            anu2 = null;
            if (!bl2) {
                boolean bl3 = this.d();
                anu2 = null;
                if (!bl3) {
                    anu2 = super.b(settingsCacheBehavior);
                }
            }
            if (anu2 == null && (jSONObject = this.e.a(this.a)) != null) {
                anu2 = this.b.a(this.c, jSONObject);
                this.d.a(anu2.g, jSONObject);
                super.a(jSONObject, "Loaded settings: ");
                this.a(this.b());
            }
            if (anu2 == null) {
                anu anu3;
                anu2 = anu3 = super.b(SettingsCacheBehavior.c);
            }
            return anu2;
        }
        catch (Exception var3_7) {
            akp.h().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", (Throwable)var3_7);
            return anu2;
        }
    }

    @SuppressLint(value={"CommitPrefEdits"})
    boolean a(String string2) {
        SharedPreferences.Editor editor = this.g.b();
        editor.putString("existing_instance_identifier", string2);
        return this.g.a(editor);
    }

    String b() {
        String[] arrstring = new String[]{CommonUtils.m((Context)this.f.E())};
        return CommonUtils.a((String[])arrstring);
    }

    String c() {
        return this.g.a().getString("existing_instance_identifier", "");
    }

    boolean d() {
        if (!this.c().equals((Object)this.b())) {
            return true;
        }
        return false;
    }
}

