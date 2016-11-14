/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Process
 *  android.util.Log
 *  android.util.SparseArray
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.api.Status
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.ref.PhantomReference
 *  java.lang.ref.Reference
 *  java.lang.ref.ReferenceQueue
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.Map
 *  java.util.Queue
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class aay
implements Handler.Callback {
    private static final Object d = new Object();
    private static aay e;
    private long a;
    private long b;
    private long c;
    private final Context f;
    private final wv g;
    private int h;
    private final SparseArray<c<?>> i;
    private final Map<aas<?>, c<?>> j;
    private aax k;
    private final Set<aas<?>> l;
    private final Handler m;
    private final ReferenceQueue<xj<?>> n;
    private final SparseArray<a> o;
    private b p;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static aay a() {
        Object object;
        Object object2 = object = d;
        synchronized (object2) {
            return e;
        }
    }

    private void a(aar aar2) {
        ((c)this.i.get(aar2.a)).a(aar2);
    }

    private void a(xj<?> xj2, int n2) {
        aas aas2 = xj2.d();
        if (!this.j.containsKey(aas2)) {
            this.j.put(aas2, (aay)this.new c(xj2));
        }
        c c2 = (c)this.j.get(aas2);
        c2.b(n2);
        this.i.put(n2, (Object)c2);
        c2.j();
        this.o.put(n2, (Object)(aay)this.new a(xj2, n2, this.n));
        if (this.p == null || !this.p.c.get()) {
            this.p = new b(this.n, this.o);
            this.p.start();
        }
    }

    private void b(int n2, boolean bl2) {
        c c2 = (c)this.i.get(n2);
        if (c2 != null) {
            if (!bl2) {
                this.i.delete(n2);
            }
            c2.a(n2, bl2);
            return;
        }
        Log.wtf((String)"GoogleApiManager", (String)new StringBuilder(52).append("onRelease received for unknown instance: ").append(n2).toString(), (Throwable)new Exception());
    }

    static /* synthetic */ aax d(aay aay2) {
        return null;
    }

    private void d() {
        for (c c2 : this.j.values()) {
            c2.b();
            c2.j();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2, boolean bl2) {
        Handler handler = this.m;
        Handler handler2 = this.m;
        int n3 = bl2 ? 1 : 2;
        handler.sendMessage(handler2.obtainMessage(7, n2, n3));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(aat aat2) {
        for (aas aas2 : aat2.b()) {
            c c2 = (c)this.j.get((Object)aas2);
            if (c2 == null) {
                aat2.f();
                return;
            }
            if (c2.d()) {
                aat2.a(aas2, ConnectionResult.a);
                continue;
            }
            if (c2.c() != null) {
                aat2.a(aas2, c2.c());
                continue;
            }
            c2.a(aat2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(aax aax2) {
        Object object;
        Object object2 = object = d;
        synchronized (object2) {
            if (aax2 == null) {
                this.k = null;
                this.l.clear();
            }
            return;
        }
    }

    boolean a(ConnectionResult connectionResult, int n2) {
        if (connectionResult.a() || this.g.a(connectionResult.c())) {
            this.g.a(this.f, connectionResult, n2);
            return true;
        }
        return false;
    }

    public void b() {
        this.m.sendMessage(this.m.obtainMessage(3));
    }

    public void b(ConnectionResult connectionResult, int n2) {
        if (!this.a(connectionResult, n2)) {
            this.m.sendMessage(this.m.obtainMessage(5, n2, 0));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            default: {
                int n2 = message.what;
                Log.w((String)"GoogleApiManager", (String)new StringBuilder(31).append("Unknown message id: ").append(n2).toString());
                return false;
            }
            case 1: {
                this.a((aat)message.obj);
                return true;
            }
            case 6: {
                super.a((xj)message.obj, message.arg1);
                return true;
            }
            case 3: {
                super.d();
                return true;
            }
            case 2: 
            case 7: {
                int n3 = message.arg1;
                int n4 = message.arg2;
                boolean bl2 = false;
                if (n4 == 1) {
                    bl2 = true;
                }
                super.b(n3, bl2);
                return true;
            }
            case 4: {
                super.a((aar)message.obj);
                return true;
            }
            case 5: {
                if (this.i.get(message.arg1) == null) return true;
                ((c)this.i.get(message.arg1)).a(new Status(17, "Error resolution was canceled by the user."));
                return true;
            }
            case 8: {
                if (!this.j.containsKey(message.obj)) return true;
                ((c)this.j.get(message.obj)).e();
                return true;
            }
            case 9: {
                if (!this.j.containsKey(message.obj)) return true;
                ((c)this.j.get(message.obj)).g();
                return true;
            }
            case 10: 
        }
        if (!this.j.containsKey(message.obj)) return true;
        ((c)this.j.get(message.obj)).i();
        return true;
    }

    final class a
    extends PhantomReference<xj<?>> {
        private final int b;

        public a(xj xj2, int n2, ReferenceQueue<xj<?>> referenceQueue) {
            super((Object)xj2, referenceQueue);
            this.b = n2;
        }

        public void a() {
            aay.this.m.sendMessage(aay.this.m.obtainMessage(2, this.b, 2));
        }
    }

    static final class b
    extends Thread {
        private final ReferenceQueue<xj<?>> a;
        private final SparseArray<a> b;
        private final AtomicBoolean c = new AtomicBoolean();

        public b(ReferenceQueue<xj<?>> referenceQueue, SparseArray<a> sparseArray) {
            super("GoogleApiCleanup");
            this.a = referenceQueue;
            this.b = sparseArray;
        }

        public void run() {
            this.c.set(true);
            Process.setThreadPriority((int)10);
            try {
                while (this.c.get()) {
                    a a2 = (a)this.a.remove();
                    this.b.remove(a2.b);
                    a2.a();
                }
            }
            catch (InterruptedException var2_2) {
                return;
            }
            return;
            finally {
                this.c.set(false);
            }
        }
    }

    class c<O extends wx.a>
    implements wz.b,
    wz.c {
        private final Queue<aar> b;
        private final wx.f c;
        private final wx.c d;
        private final aas<O> e;
        private final SparseArray<abi> f;
        private final Set<aat> g;
        private final SparseArray<Map<Object, aau.a>> h;
        private boolean i;
        private ConnectionResult j;

        /*
         * Enabled aggressive block sorting
         */
        public c(xj<O> xj2) {
            this.b = new LinkedList();
            this.f = new SparseArray();
            this.g = new HashSet();
            this.h = new SparseArray();
            this.j = null;
            this.c = super.a(xj2);
            this.d = this.c instanceof xw ? ((xw)this.c).h() : this.c;
            this.e = xj2.d();
        }

        private wx.f a(xj xj2) {
            wx wx2 = xj2.b();
            if (wx2.d()) {
                wx.i i2 = wx2.b();
                return new xw(xj2.e(), aay.this.m.getLooper(), i2.a(), (wz.b)this, (wz.c)this, yd.a(xj2.e()), i2.a(xj2.c()));
            }
            return xj2.b().a().a(xj2.e(), aay.this.m.getLooper(), yd.a(xj2.e()), xj2.c(), (wz.b)this, (wz.c)this);
        }

        private void a(Status status) {
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                ((aar)iterator.next()).a(status);
            }
            this.b.clear();
        }

        /*
         * Exception decompiling
         */
        private void b(aar var1) {
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
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }

        private void b(ConnectionResult connectionResult) {
            Iterator iterator = this.g.iterator();
            while (iterator.hasNext()) {
                ((aat)iterator.next()).a(this.e, connectionResult);
            }
            this.g.clear();
        }

        private void e() {
            if (this.i) {
                this.j();
            }
        }

        private void f() {
            if (this.i) {
                aay.this.m.removeMessages(9, this.e);
                aay.this.m.removeMessages(8, this.e);
                this.i = false;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        private void g() {
            if (this.i) {
                this.f();
                Status status = aay.this.g.a(aay.this.f) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error.");
                this.a(status);
                this.c.a();
            }
        }

        private void h() {
            aay.this.m.removeMessages(10, this.e);
            aay.this.m.sendMessageDelayed(aay.this.m.obtainMessage(10, this.e), aay.this.c);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private void i() {
            if (!this.c.b() || this.h.size() != 0) return;
            for (int i2 = 0; i2 < this.f.size(); ++i2) {
                if (!((abi)this.f.get(this.f.keyAt(i2))).b()) continue;
                this.h();
                return;
            }
            this.c.a();
        }

        private void j() {
            if (this.c.b() || this.c.c()) {
                return;
            }
            if (this.c.d() && aay.this.h != 0) {
                aay.this.h = aay.this.g.a(aay.this.f);
                if (aay.this.h != 0) {
                    this.a(new ConnectionResult(aay.this.h, null));
                    return;
                }
            }
            this.c.a(new d(this.c, this.e));
        }

        public void a() {
            while (this.c.b() && !this.b.isEmpty()) {
                this.b((aar)this.b.remove());
            }
        }

        @Override
        public void a(int n2) {
            this.b();
            this.i = true;
            aay.this.m.sendMessageDelayed(Message.obtain((Handler)aay.this.m, (int)8, this.e), aay.this.a);
            aay.this.m.sendMessageDelayed(Message.obtain((Handler)aay.this.m, (int)9, this.e), aay.this.b);
            aay.this.h = -1;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void a(int n2, boolean bl2) {
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                aar aar2 = (aar)iterator.next();
                if (aar2.a != n2 || aar2.b == 1 || !aar2.a()) continue;
                iterator.remove();
            }
            ((abi)this.f.get(n2)).a();
            this.h.delete(n2);
            if (!bl2) {
                this.f.remove(n2);
                aay.this.o.remove(n2);
                if (this.f.size() == 0 && this.b.isEmpty()) {
                    Object object;
                    super.f();
                    this.c.a();
                    aay.this.j.remove(this.e);
                    Object object2 = object = d;
                    synchronized (object2) {
                        aay.this.l.remove(this.e);
                        return;
                    }
                }
            }
        }

        public void a(aar aar2) {
            if (this.c.b()) {
                super.b(aar2);
                super.h();
                return;
            }
            this.b.add((Object)aar2);
            if (this.j != null && this.j.a()) {
                this.a(this.j);
                return;
            }
            super.j();
        }

        public void a(aat aat2) {
            this.g.add((Object)aat2);
        }

        @Override
        public void a(Bundle bundle) {
            this.b();
            super.b(ConnectionResult.a);
            super.f();
            for (int i2 = 0; i2 < this.h.size(); ++i2) {
                for (aau.a a2 : ((Map)this.h.get(this.h.keyAt(i2))).values()) {
                    try {
                        a2.a(this.d);
                    }
                    catch (DeadObjectException var5_4) {
                        this.c.a();
                        this.a(1);
                    }
                }
            }
            this.a();
            super.h();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(ConnectionResult connectionResult) {
            Object object;
            this.b();
            aay.this.h = -1;
            super.b(connectionResult);
            int n2 = this.f.keyAt(0);
            if (this.b.isEmpty()) {
                this.j = connectionResult;
                return;
            }
            Object object2 = object = d;
            synchronized (object2) {
                if (aay.d(aay.this) != null && aay.this.l.contains(this.e)) {
                    aay.d(aay.this).b(connectionResult, n2);
                    return;
                }
            }
            if (aay.this.a(connectionResult, n2)) return;
            {
                if (connectionResult.c() == 18) {
                    this.i = true;
                }
                if (this.i) {
                    aay.this.m.sendMessageDelayed(Message.obtain((Handler)aay.this.m, (int)8, this.e), aay.this.a);
                    return;
                }
            }
            String string = String.valueOf((Object)this.e.b());
            super.a(new Status(17, new StringBuilder(38 + String.valueOf((Object)string).length()).append("API: ").append(string).append(" is not available on this device.").toString()));
        }

        public void b() {
            this.j = null;
        }

        public void b(int n2) {
            this.f.put(n2, (Object)new abi(this.e.a(), this.c));
        }

        ConnectionResult c() {
            return this.j;
        }

        boolean d() {
            return this.c.b();
        }
    }

    class d
    implements ya.f {
        private final wx.f b;
        private final aas<?> c;

        public d(wx.f f2, aas<?> aas2) {
            this.b = f2;
            this.c = aas2;
        }

        @Override
        public void a(ConnectionResult connectionResult) {
            if (connectionResult.b()) {
                this.b.a(null, Collections.emptySet());
                return;
            }
            ((c)aay.this.j.get(this.c)).a(connectionResult);
        }
    }

}

