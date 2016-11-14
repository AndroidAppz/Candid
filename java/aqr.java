/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.LinkedList
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public final class aqr
implements apk {
    private LinkedList<apk> a;
    private volatile boolean b;

    public aqr() {
    }

    public aqr(apk apk2) {
        this.a = new LinkedList();
        this.a.add((Object)apk2);
    }

    public /* varargs */ aqr(apk ... arrapk) {
        this.a = new LinkedList((Collection)Arrays.asList((Object[])arrapk));
    }

    private static void a(Collection<apk> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (apk apk2 : collection) {
            try {
                apk2.unsubscribe();
            }
            catch (Throwable var4_3) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((Object)var4_3);
            }
        }
        app.a(arrayList);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(apk apk2) {
        if (apk2.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            void var5_2 = this;
            synchronized (var5_2) {
                if (!this.b) {
                    LinkedList linkedList = this.a;
                    if (linkedList == null) {
                        this.a = linkedList = new LinkedList();
                    }
                    linkedList.add((Object)apk2);
                    return;
                }
            }
        }
        apk2.unsubscribe();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void b(apk apk2) {
        if (this.b) return;
        void var5_2 = this;
        // MONITORENTER : var5_2
        LinkedList<apk> linkedList = this.a;
        if (!this.b && linkedList != null) {
            boolean bl2 = linkedList.remove((Object)apk2);
            // MONITOREXIT : var5_2
            if (!bl2) return;
            apk2.unsubscribe();
            return;
        }
        // MONITOREXIT : var5_2
    }

    @Override
    public boolean isUnsubscribed() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void unsubscribe() {
        LinkedList<apk> linkedList;
        if (this.b) {
            return;
        }
        aqr aqr2 = this;
        synchronized (aqr2) {
            if (this.b) {
                return;
            }
            this.b = true;
            linkedList = this.a;
            this.a = null;
        }
        aqr.a(linkedList);
    }
}

