/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class bn {
    private static final Object f = new Object();
    private static bn g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap();
    private final HashMap<String, ArrayList<b>> c = new HashMap();
    private final ArrayList<a> d = new ArrayList();
    private final Handler e;

    private bn(Context context) {
        this.a = context;
        this.e = new Handler(context.getMainLooper()){

            public void handleMessage(Message message) {
                switch (message.what) {
                    default: {
                        super.handleMessage(message);
                        return;
                    }
                    case 1: 
                }
                bn.this.a();
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static bn a(Context context) {
        Object object;
        Object object2 = object = f;
        synchronized (object2) {
            if (g != null) return g;
            g = new bn(context.getApplicationContext());
            return g;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        block3 : do {
            HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
            Object[] arrobject;
            HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap2 = hashMap = this.b;
            synchronized (hashMap2) {
                int n2 = this.d.size();
                if (n2 <= 0) {
                    return;
                }
                arrobject = new a[n2];
                this.d.toArray(arrobject);
                this.d.clear();
            }
            int n3 = 0;
            do {
                if (n3 >= arrobject.length) continue block3;
                Object object = arrobject[n3];
                for (int i2 = 0; i2 < object.b.size(); ++i2) {
                    ((b)object.b.get((int)i2)).b.onReceive(this.a, object.a);
                }
                ++n3;
            } while (true);
            break;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(BroadcastReceiver var1) {
        var13_3 = var2_2 = this.b;
        // MONITORENTER : var13_3
        var4_4 = (ArrayList)this.b.remove((Object)var1);
        if (var4_4 == null) {
            // MONITOREXIT : var13_3
            return;
        }
        var5_7 = 0;
        block3 : do {
            if (var5_7 >= var4_4.size()) {
                // MONITOREXIT : var13_3
                return;
            }
            var6_10 = (IntentFilter)var4_4.get(var5_7);
            var7_9 = 0;
            do {
                if (var7_9 >= var6_10.countActions()) ** GOTO lbl20
                var8_5 = var6_10.getAction(var7_9);
                var9_6 = (ArrayList)this.c.get((Object)var8_5);
                if (var9_6 == null) ** GOTO lbl34
                ** GOTO lbl22
lbl20: // 1 sources:
                ++var5_7;
                continue block3;
lbl22: // 1 sources:
                var10_8 = 0;
                do {
                    if (var10_8 < var9_6.size()) {
                        if (((b)var9_6.get((int)var10_8)).b == var1) {
                            var9_6.remove(var10_8);
                            --var10_8;
                        }
                    } else {
                        if (var9_6.size() > 0) break;
                        this.c.remove((Object)var8_5);
                        break;
                    }
                    ++var10_8;
                } while (true);
lbl34: // 3 sources:
                ++var7_9;
            } while (true);
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap2 = hashMap = this.b;
        synchronized (hashMap2) {
            b b2 = new b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList)this.b.get((Object)broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.b.put((Object)broadcastReceiver, (Object)arrayList);
            }
            arrayList.add((Object)intentFilter);
            int n2 = 0;
            while (n2 < intentFilter.countActions()) {
                String string2 = intentFilter.getAction(n2);
                ArrayList arrayList2 = (ArrayList)this.c.get((Object)string2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.c.put((Object)string2, (Object)arrayList2);
                }
                arrayList2.add((Object)b2);
                ++n2;
            }
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public boolean a(Intent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
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

    static class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    static class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append((Object)this.b);
            stringBuilder.append(" filter=");
            stringBuilder.append((Object)this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

}

